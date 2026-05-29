package net.potionstudios.byg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class BYGPlantPlacementHelper {
  private static final ResourceLocation GRASS_PLACE_SOUND = new ResourceLocation("block.grass.place");
  private static final ResourceLocation SLIME_PLACE_SOUND = new ResourceLocation("block.slime.place");

  private BYGPlantPlacementHelper() {}

  public static boolean placeOnGrassOrMud(World world, BlockPos supportPos, EntityPlayer player, EnumHand hand, EnumFacing side, Item item, Block plantBlock) {
    if (world == null || supportPos == null || side != EnumFacing.UP)
      return false;

    Block supportBlock = world.getBlockState(supportPos).getBlock();
    if (supportBlock != Blocks.GRASS && supportBlock != Mudblock.block)
      return false;

    return placeHeldItemBlock(world, supportPos.up(), supportPos, player, hand, item, plantBlock.getDefaultState(), GRASS_PLACE_SOUND);
  }

  public static boolean placeGlowshroom(World world, BlockPos clickedPos, EntityPlayer player, EnumHand hand, Item item, Block glowshroomBlock) {
    if (world == null || clickedPos == null || player == null || glowshroomBlock == null)
      return false;

    if (isGlowshroomPlant(world.getBlockState(clickedPos).getBlock()))
      return false;

    IBlockState state = glowshroomBlock.getDefaultState();
    if (state.getPropertyKeys().contains(BlockHorizontal.FACING))
      state = state.withProperty(BlockHorizontal.FACING, player.getHorizontalFacing().getOpposite());

    return placeHeldItemBlock(world, clickedPos.up(), clickedPos, player, hand, item, state, SLIME_PLACE_SOUND);
  }

  public static boolean growGlowshroom(World world, BlockPos pos, EntityPlayer player, EnumHand hand, Item item, Block nextStageBlock) {
    if (world == null || pos == null || player == null || hand == null || item == null || nextStageBlock == null)
      return false;

    ItemStack held = player.getHeldItem(hand);
    if (held.isEmpty() || held.getItem() != item)
      return false;

    if (!world.isRemote) {
      SoundEvent sound = SoundEvent.REGISTRY.getObject(SLIME_PLACE_SOUND);
      if (sound != null)
        world.playSound((EntityPlayer)null, pos, sound, SoundCategory.NEUTRAL, 1.0F, 1.0F);

      world.setBlockToAir(pos);
      world.setBlockState(pos, nextStageBlock.getDefaultState(), 3);
      if (!player.capabilities.isCreativeMode)
        held.shrink(1);
    }

    return true;
  }

  public static boolean placeHeldItemRelative(World world, BlockPos clickedPos, EntityPlayer player, EnumHand hand, EnumFacing side, Item item, Block supportBlock, Block plantBlock, EnumFacing placementSide) {
    if (world == null || clickedPos == null || player == null || hand == null || side == null || item == null || supportBlock == null || plantBlock == null || placementSide == null)
      return false;

    if (side != placementSide)
      return false;

    if (world.getBlockState(clickedPos).getBlock() != supportBlock)
      return false;

    ItemStack held = player.getHeldItem(hand);
    if (held.isEmpty() || held.getItem() != item)
      return false;

    BlockPos placePos = clickedPos.offset(placementSide);
    if (!world.getBlockState(placePos).getBlock().isReplaceable(world, placePos))
      return false;

    if (!world.isRemote) {
      world.setBlockState(placePos, plantBlock.getDefaultState(), 3);
      if (!player.capabilities.isCreativeMode)
        held.shrink(1);
    }

    return true;
  }

  private static boolean placeHeldItemBlock(World world, BlockPos placePos, BlockPos soundPos, EntityPlayer player, EnumHand hand, Item item, IBlockState state, ResourceLocation soundName) {
    if (world == null || placePos == null || soundPos == null || player == null || hand == null || item == null || state == null)
      return false;

    ItemStack held = player.getHeldItem(hand);
    if (held.isEmpty() || held.getItem() != item)
      return false;

    if (!world.getBlockState(placePos).getBlock().isReplaceable(world, placePos))
      return false;

    if (!world.isRemote) {
      SoundEvent sound = SoundEvent.REGISTRY.getObject(soundName);
      if (sound != null)
        world.playSound((EntityPlayer)null, soundPos, sound, SoundCategory.NEUTRAL, 1.0F, 1.0F);

      world.setBlockState(placePos, state, 3);
      if (!player.capabilities.isCreativeMode)
        held.shrink(1);
    }

    return true;
  }

  private static boolean isGlowshroomPlant(Block block) {
    return block == Small_blue_glowshroom.block
        || block == Small_green_glowshroom.block
        || block == Small_purple_glowshroom.block
        || block == Medium_blue_glowshroom.block
        || block == Medium_green_glowshroom.block
        || block == Medium_purple_glowshroom.block
        || block == Blueglowshroom.block
        || block == Green_glowshroom.block
        || block == Purple_glowshroom.block;
  }
}

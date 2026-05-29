package net.potionstudios.byg;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public final class BYGBonemealGrowthHelper {
  private BYGBonemealGrowthHelper() {}

  public static boolean isHeldBonemeal(Entity entity, EnumHand hand) {
    if (!(entity instanceof EntityPlayer) || hand == null)
      return false;

    ItemStack held = ((EntityPlayer)entity).getHeldItem(hand);
    return isBonemeal(held);
  }

  public static void consumeHeldBonemeal(World world, Entity entity, EnumHand hand) {
    if (world == null || world.isRemote || !(entity instanceof EntityPlayer) || hand == null)
      return;

    EntityPlayer player = (EntityPlayer)entity;
    if (player.capabilities.isCreativeMode)
      return;

    ItemStack held = player.getHeldItem(hand);
    if (isBonemeal(held))
      held.shrink(1);
  }

  public static void spawnHappyParticles(World world, BlockPos pos) {
    if (world instanceof WorldServer && pos != null)
      ((WorldServer)world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX(), pos.getY(), pos.getZ(), 5, 3.0D, 3.0D, 3.0D, 1.0D, new int[0]);
  }

  public static boolean growSimpleStage(World world, BlockPos pos, EntityPlayer player, EnumHand hand, Block nextStageBlock) {
    if (world == null || pos == null || player == null || hand == null || nextStageBlock == null)
      return false;

    ItemStack held = player.getHeldItem(hand);
    if (!isBonemeal(held))
      return false;

    if (!world.isRemote) {
      if (Math.random() < 0.4D) {
        spawnHappyParticles(world, pos);

        world.setBlockToAir(pos);
        world.setBlockState(pos, nextStageBlock.getDefaultState(), 3);
      }

      if (!player.capabilities.isCreativeMode)
        held.shrink(1);
    }

    return true;
  }

  private static boolean isBonemeal(ItemStack stack) {
    return !stack.isEmpty() && stack.getItem() == Items.DYE && stack.getMetadata() == 15;
  }
}

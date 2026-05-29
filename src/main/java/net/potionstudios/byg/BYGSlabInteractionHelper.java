package net.potionstudios.byg;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class BYGSlabInteractionHelper {
  private BYGSlabInteractionHelper() {}

  public static boolean combineHeldSlab(World world, BlockPos pos, EntityPlayer player, EnumHand hand, Block slabBlock, Block plankBlock) {
    if (world == null || pos == null || player == null || hand == null || slabBlock == null || plankBlock == null)
      return false;

    ItemStack held = player.getHeldItem(hand);
    if (held.isEmpty() || held.getItem() != Item.getItemFromBlock(slabBlock))
      return false;

    if (!world.isRemote) {
      world.setBlockToAir(pos);
      world.setBlockState(pos, plankBlock.getDefaultState(), 3);
      if (!player.capabilities.isCreativeMode)
        held.shrink(1);
    }

    return true;
  }
}

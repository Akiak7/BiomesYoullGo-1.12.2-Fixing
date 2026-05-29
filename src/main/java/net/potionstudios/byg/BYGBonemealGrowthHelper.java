package net.potionstudios.byg;

import net.minecraft.block.Block;
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

  public static boolean growSimpleStage(World world, BlockPos pos, EntityPlayer player, EnumHand hand, Block nextStageBlock) {
    if (world == null || pos == null || player == null || hand == null || nextStageBlock == null)
      return false;

    ItemStack held = player.getHeldItem(hand);
    if (held.isEmpty() || held.getItem() != Items.DYE || held.getMetadata() != 15)
      return false;

    if (!world.isRemote) {
      if (Math.random() < 0.4D) {
        if (world instanceof WorldServer)
          ((WorldServer)world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX(), pos.getY(), pos.getZ(), 5, 3.0D, 3.0D, 3.0D, 1.0D, new int[0]);

        world.setBlockToAir(pos);
        world.setBlockState(pos, nextStageBlock.getDefaultState(), 3);
      }

      if (!player.capabilities.isCreativeMode)
        held.shrink(1);
    }

    return true;
  }
}

package net.potionstudios.byg;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

final class BYGWaterPlantTickHelper {
  private BYGWaterPlantTickHelper() {}

  static void updateWaterSurvivalPlant(World world, BlockPos pos, Item dropItem) {
    if (hasNearbyWater(world, pos)) {
      return;
    }

    world.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), (SoundEvent)SoundEvent.REGISTRY
        .getObject(new ResourceLocation("block.grass.break")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
    world.setBlockToAir(pos);
    if (!world.isRemote) {
      EntityItem entityToSpawn = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(dropItem, 1));
      entityToSpawn.setPickupDelay(10);
      world.spawnEntity((Entity)entityToSpawn);
    }
  }

  private static boolean hasNearbyWater(World world, BlockPos pos) {
    BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos();
    for (int offZ = -3; offZ < 3; offZ++) {
      for (int offY = -3; offY < 3; offY++) {
        for (int offX = -3; offX < 3; offX++) {
          checkPos.setPos(pos.getX() + offX, pos.getY() + offY, pos.getZ() + offZ);
          if (world.getBlockState(checkPos).getBlock() == Blocks.WATER) {
            return true;
          }
        }
      }
    }
    return false;
  }
}

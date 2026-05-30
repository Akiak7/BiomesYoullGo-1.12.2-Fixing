package net.potionstudios.byg;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public final class BYGLeafDropHelper {
  private BYGLeafDropHelper() {}

  public static void addSaplingDrop(NonNullList<ItemStack> drops, Block sapling, double chance) {
    if (sapling != null && Math.random() < chance) {
      drops.add(new ItemStack(sapling, 1));
    }
  }
}

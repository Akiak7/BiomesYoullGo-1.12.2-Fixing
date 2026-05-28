package net.potionstudios.byg;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BYGWoodBlock extends Block {
  protected BYGWoodBlock(Material material) {
    super(material);
  }

  public void breakBlock(World world, BlockPos pos, IBlockState state) {
    notifyNearbyLeaves(world, pos);
    super.breakBlock(world, pos, state);
  }

  public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
    return true;
  }

  public boolean isWood(IBlockAccess world, BlockPos pos) {
    return true;
  }

  public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
    return 5;
  }

  public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
    return 5;
  }

  public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
    return true;
  }

  private static void notifyNearbyLeaves(World world, BlockPos pos) {
    if (!world.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5))) {
      return;
    }

    for (BlockPos leafPos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4))) {
      IBlockState leafState = world.getBlockState(leafPos);
      Block leafBlock = leafState.getBlock();
      if (leafBlock.isLeaves(leafState, world, leafPos)) {
        leafBlock.beginLeavesDecay(leafState, world, leafPos);
      }
    }
  }
}

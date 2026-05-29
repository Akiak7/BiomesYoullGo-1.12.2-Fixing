package net.potionstudios.byg;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class BYGDoorGateStateHelper {
  private BYGDoorGateStateHelper() {}

  public static IBlockState withFacing(World world, BlockPos pos, IBlockState targetState) {
    EnumFacing facing = getFacing(world.getBlockState(pos));
    if (facing != null) {
      return withFacing(targetState, facing);
    }
    return targetState;
  }

  public static void replaceWithFacing(World world, BlockPos pos, IBlockState targetState, int flags) {
    world.setBlockState(pos, withFacing(world, pos, targetState), flags);
  }

  public static IBlockState withEntityFacing(Entity entity, IBlockState targetState) {
    if (entity instanceof EntityLivingBase && targetState.getPropertyKeys().contains(BlockHorizontal.FACING)) {
      EnumFacing facing = ((EntityLivingBase)entity).getHorizontalFacing().getOpposite();
      return targetState.withProperty(BlockHorizontal.FACING, facing);
    }
    return targetState;
  }

  public static void placeDoor(World world, BlockPos bottomPos, IBlockState bottomState, IBlockState topState, Entity entity, int flags) {
    world.setBlockState(bottomPos, withEntityFacing(entity, bottomState), flags);
    world.setBlockState(bottomPos.up(), withEntityFacing(entity, topState), flags);
  }

  public static boolean canPlaceDoor(World world, BlockPos supportPos, EnumFacing side) {
    BlockPos bottomPos = supportPos.up();
    BlockPos topPos = bottomPos.up();
    return side == EnumFacing.UP &&
      world.getBlockState(supportPos).isSideSolid(world, supportPos, EnumFacing.UP) &&
      world.isAirBlock(bottomPos) &&
      world.isAirBlock(topPos);
  }

  public static void replaceDoorFromBottom(World world, BlockPos bottomPos, IBlockState bottomState, IBlockState topState, int flags) {
    replaceDoorPair(world, bottomPos, bottomState, topState, flags);
  }

  public static void replaceDoorFromTop(World world, BlockPos topPos, IBlockState bottomState, IBlockState topState, int flags) {
    replaceDoorPair(world, topPos.down(), bottomState, topState, flags);
  }

  private static void replaceDoorPair(World world, BlockPos bottomPos, IBlockState bottomState, IBlockState topState, int flags) {
    BlockPos topPos = bottomPos.up();
    EnumFacing facing = getFacing(world.getBlockState(bottomPos));
    if (facing == null) {
      facing = getFacing(world.getBlockState(topPos));
    }
    if (facing != null) {
      bottomState = withFacing(bottomState, facing);
      topState = withFacing(topState, facing);
    }
    world.setBlockState(bottomPos, bottomState, flags);
    world.setBlockState(topPos, topState, flags);
  }

  private static IBlockState withFacing(IBlockState targetState, EnumFacing facing) {
    if (targetState.getPropertyKeys().contains(BlockHorizontal.FACING)) {
      return targetState.withProperty(BlockHorizontal.FACING, facing);
    }
    return targetState;
  }

  private static EnumFacing getFacing(IBlockState state) {
    if (state.getPropertyKeys().contains(BlockHorizontal.FACING)) {
      try {
        return (EnumFacing)state.getValue(BlockHorizontal.FACING);
      } catch (IllegalArgumentException ignored) {}
    }
    return null;
  }
}

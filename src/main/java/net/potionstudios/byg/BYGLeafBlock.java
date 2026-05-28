package net.potionstudios.byg;

import java.util.Random;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BYGLeafBlock extends BlockLeaves {
  protected BYGLeafBlock(Material material) {
    super();
    setDefaultState(this.blockState.getBaseState()
      .withProperty((IProperty)DECAYABLE, Boolean.valueOf(true))
      .withProperty((IProperty)CHECK_DECAY, Boolean.valueOf(false)));
  }

  protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, new IProperty[] { (IProperty)DECAYABLE, (IProperty)CHECK_DECAY });
  }

  public IBlockState getStateFromMeta(int meta) {
    return getDefaultState()
      .withProperty((IProperty)DECAYABLE, Boolean.valueOf((meta & 4) == 0))
      .withProperty((IProperty)CHECK_DECAY, Boolean.valueOf((meta & 8) != 0));
  }

  public int getMetaFromState(IBlockState state) {
    int meta = 0;
    if (!((Boolean)state.getValue((IProperty)DECAYABLE)).booleanValue()) {
      meta |= 4;
    }
    if (((Boolean)state.getValue((IProperty)CHECK_DECAY)).booleanValue()) {
      meta |= 8;
    }
    return meta;
  }

  public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
    return getDefaultState()
      .withProperty((IProperty)DECAYABLE, Boolean.valueOf(false))
      .withProperty((IProperty)CHECK_DECAY, Boolean.valueOf(false));
  }

  public int damageDropped(IBlockState state) {
    return 0;
  }

  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    return Items.AIR;
  }

  public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
    return Collections.singletonList(new ItemStack(this, 1, 0));
  }

  public BlockPlanks.EnumType getWoodType(int meta) {
    return BlockPlanks.EnumType.OAK;
  }

  public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
    return 60;
  }

  public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
    return 30;
  }

  public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
    return true;
  }

  @SideOnly(Side.CLIENT)
  public static void registerStateMapper(Block block) {
    ModelLoader.setCustomStateMapper(block, (new StateMap.Builder()).ignore(new IProperty[] { (IProperty)DECAYABLE, (IProperty)CHECK_DECAY }).build());
  }
}

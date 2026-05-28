 package net.potionstudios.byg;
 import javax.annotation.Nullable;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockDirectional;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.properties.IProperty;
 import net.minecraft.block.properties.PropertyDirection;
 import net.minecraft.block.state.BlockStateContainer;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.util.BlockRenderLayer;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.math.AxisAlignedBB;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Ivy extends Elementsbyg.ModElement {
   @ObjectHolder("byg:ivy")
   public static final Block block = null;
   
   public Ivy(Elementsbyg instance) {
     super(instance, 2354);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:ivy", "inventory"));
   }
   
   public static class BlockCustom extends Block {
     public static final PropertyDirection FACING = BlockDirectional.FACING;
     
     public BlockCustom() {
       super(Material.PLANTS);
       setRegistryName("ivy");
       setUnlocalizedName("ivy");
       setSoundType(SoundType.PLANT);
       setHarvestLevel("pickaxe", 0);
       setHardness(0.01F);
       setResistance(1.0F);
       setLightLevel(0.0F);
       setLightOpacity(0);
       setCreativeTab(BYGTab.tab);
       setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.SOUTH));
     }
 
     
     @SideOnly(Side.CLIENT)
     public BlockRenderLayer getBlockLayer() {
       return BlockRenderLayer.TRANSLUCENT;
     }
 
     
     @Nullable
     public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
       return NULL_AABB;
     }
 
     
     public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
       return true;
     }
 
     
     public boolean isFullCube(IBlockState state) {
       return false;
     }
 
     
     public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
       switch ((EnumFacing)state.getValue((IProperty)BlockDirectional.FACING))
       
       { default:
           return new AxisAlignedBB(1.0D, 0.0D, 1.0D, 0.0D, 0.1D, 0.0D);
         case NORTH:
           return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1D, 1.0D);
         case WEST:
           return new AxisAlignedBB(0.0D, 0.0D, 1.0D, 1.0D, 0.1D, 0.0D);
         case EAST:
           return new AxisAlignedBB(1.0D, 0.0D, 0.0D, 0.0D, 0.1D, 1.0D);
         case UP:
           return new AxisAlignedBB(0.0D, 1.0D, 0.0D, 1.0D, 0.0D, 0.1D);
         case DOWN:
           break; }  return new AxisAlignedBB(0.0D, 0.0D, 1.0D, 1.0D, 1.0D, 0.9D);
     }
 
 
     
     protected BlockStateContainer createBlockState() {
       return new BlockStateContainer(this, new IProperty[] { (IProperty)FACING });
     }
 
     
     public IBlockState getStateFromMeta(int meta) {
       return getDefaultState().withProperty((IProperty)FACING, (Comparable)EnumFacing.getFront(meta));
     }
 
     
     public int getMetaFromState(IBlockState state) {
       return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
     }
 
 
     
     public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
       if (facing == EnumFacing.WEST || facing == EnumFacing.EAST) {
         facing = EnumFacing.UP;
       } else if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH) {
         facing = EnumFacing.EAST;
       } else {
         facing = EnumFacing.SOUTH;
       }  return getDefaultState().withProperty((IProperty)FACING, (Comparable)facing);
     }
 
     
     public boolean isOpaqueCube(IBlockState state) {
       return false;
     }
   }
 }




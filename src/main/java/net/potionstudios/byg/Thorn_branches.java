 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockDirectional;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.MapColor;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.properties.IProperty;
 import net.minecraft.block.properties.PropertyDirection;
 import net.minecraft.block.state.BlockFaceShape;
 import net.minecraft.block.state.BlockStateContainer;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
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
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Thorn_branches
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:thorn_branches")
   public static final Block block = null;
   
   public Thorn_branches(Elementsbyg instance) {
     super(instance, 2297);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("logWood", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:thorn_branches", "inventory"));
   }
   
   public static class BlockCustom extends Block {
     public static final PropertyDirection FACING = BlockDirectional.FACING;
     
     public BlockCustom() {
       super(Material.WOOD);
       setRegistryName("thorn_branches");
       setUnlocalizedName("thorn_branches");
       setSoundType(SoundType.WOOD);
       setHarvestLevel("axe", 1);
       setHardness(2.0F);
       setResistance(10.0F);
       setLightLevel(0.0F);
       setLightOpacity(0);
       setCreativeTab(BYGTab.tab);
       setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.SOUTH));
     }
 
     
     @SideOnly(Side.CLIENT)
     public BlockRenderLayer getBlockLayer() {
       return BlockRenderLayer.CUTOUT_MIPPED;
     }
 
     
     public boolean isFullCube(IBlockState state) {
       return false;
     }
 
     
     public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
       switch ((EnumFacing)state.getValue((IProperty)BlockDirectional.FACING))
       
       { default:
           return new AxisAlignedBB(0.8D, 0.0D, 0.8D, 0.2D, 1.0D, 0.2D);
         case NORTH:
           return new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 1.0D, 0.8D);
         case WEST:
           return new AxisAlignedBB(0.2D, 0.0D, 0.8D, 0.8D, 1.0D, 0.2D);
         case EAST:
           return new AxisAlignedBB(0.8D, 0.0D, 0.2D, 0.2D, 1.0D, 0.8D);
         case UP:
           return new AxisAlignedBB(0.2D, 0.8D, 0.0D, 0.8D, 0.2D, 1.0D);
         case DOWN:
           break; }  return new AxisAlignedBB(0.2D, 0.2D, 1.0D, 0.8D, 0.8D, 0.0D);
     }
 
 
     
     public int tickRate(World world) {
       return 2600;
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
 
     
     public boolean isFlammable(IBlockAccess blockAccess, BlockPos pos, EnumFacing face) {
       return true;
     }
 
     
     public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
       return MapColor.WOOD;
     }
 
     
     public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
       return BlockFaceShape.MIDDLE_POLE;
     }
 
     
     public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
       return false;
     }
 
     
     public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
       super.onEntityCollidedWithBlock(world, pos, state, entity);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("entity", entity);
       ThornblockEntityCollidesInTheBlock.executeProcedure($_dependencies);
     }
 
 
     
     public void onEntityWalk(World world, BlockPos pos, Entity entity) {
       super.onEntityWalk(world, pos, entity);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("entity", entity);
       ThornblockEntityWalksOnTheBlock.executeProcedure($_dependencies);
     }
   }
 }




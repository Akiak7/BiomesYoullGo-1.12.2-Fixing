 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockHorizontal;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.properties.IProperty;
 import net.minecraft.block.properties.PropertyDirection;
 import net.minecraft.block.state.BlockStateContainer;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.BlockRenderLayer;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.EnumHand;
 import net.minecraft.util.NonNullList;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Baobabfruitblock
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:baobabfruitblock")
   public static final Block block = null;
   
   public Baobabfruitblock(Elementsbyg instance) {
     super(instance, 661);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:baobabfruitblock", "inventory"));
   }
   
   public static class BlockCustom extends Block {
     public static final PropertyDirection FACING = BlockHorizontal.FACING;
     
     public BlockCustom() {
       super(Material.PLANTS);
       setRegistryName("baobabfruitblock");
       setUnlocalizedName("baobabfruitblock");
       setSoundType(SoundType.WOOD);
       setHarvestLevel("axe", 0);
       setHardness(1.0F);
       setResistance(5.0F);
       setLightLevel(0.0F);
       setLightOpacity(0);
       setCreativeTab(null);
       setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH));
     }
 
     
     @SideOnly(Side.CLIENT)
     public BlockRenderLayer getBlockLayer() {
       return BlockRenderLayer.CUTOUT_MIPPED;
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
       if (facing == EnumFacing.UP || facing == EnumFacing.DOWN)
         return getDefaultState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH); 
       return getDefaultState().withProperty((IProperty)FACING, (Comparable)facing);
     }
 
     
     public boolean isOpaqueCube(IBlockState state) {
       return false;
     }
 
     
     public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
       return false;
     }
 
     
     public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
       drops.add(new ItemStack(Baobabfruit.block, 3));
     }
 
     
     public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos) {
       super.neighborChanged(state, world, pos, neighborBlock, fromPos);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       if (world.isBlockIndirectlyGettingPowered(new BlockPos(x, y, z)) > 0);
 
 
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       BaobabfruitblockNeighbourBlockChanges.executeProcedure($_dependencies);
     }
 
 
 
     
     public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
       super.onBlockActivated(world, pos, state, entity, hand, side, hitX, hitY, hitZ);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       BaobabfruitblockOnBlockRightClicked.executeProcedure($_dependencies);
       
       return true;
     }
   }
 }




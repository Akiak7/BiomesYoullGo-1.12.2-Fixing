 package net.potionstudios.byg;
 
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockHorizontal;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.MapColor;
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
 import net.minecraft.util.EnumFacing;
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
 public class Jackomelon extends Elementsbyg.ModElement {
   @ObjectHolder("byg:jackomelon")
   public static final Block block = null;
   
   public Jackomelon(Elementsbyg instance) {
     super(instance, 1965);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("blockMelon", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:jackomelon", "inventory"));
   }
   
   public static class BlockCustom extends Block {
     public static final PropertyDirection FACING = BlockHorizontal.FACING;
     
     public BlockCustom() {
       super(Material.WOOD);
       setRegistryName("jackomelon");
       setUnlocalizedName("jackomelon");
       setSoundType(SoundType.WOOD);
       setHardness(1.0F);
       setResistance(10.0F);
       setLightLevel(1.0F);
       setLightOpacity(255);
       setCreativeTab(BYGTab.tab);
       setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH));
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
       return getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite());
     }
 
     
     public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
       return MapColor.GREEN;
     }
 
     
     public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
       return false;
     }
   }
 }




 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Blocks;
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
 public class Baobabastage1
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:baobabastage1")
   public static final Block block = null;
   
   public Baobabastage1(Elementsbyg instance) {
     super(instance, 975);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:baobabastage1", "inventory"));
   }
   
   public static class BlockCustom extends Block {
     public BlockCustom() {
       super(Material.PLANTS);
       setRegistryName("baobabastage1");
       setUnlocalizedName("baobabastage1");
       setSoundType(SoundType.WOOD);
       setHarvestLevel("axe", 0);
       setHardness(1.0F);
       setResistance(5.0F);
       setLightLevel(0.0F);
       setLightOpacity(0);
       setCreativeTab(null);
     }
 
     
     @SideOnly(Side.CLIENT)
     public BlockRenderLayer getBlockLayer() {
       return BlockRenderLayer.CUTOUT_MIPPED;
     }
 
     
     public int tickRate(World world) {
       return 1800;
     }
 
     
     public boolean isOpaqueCube(IBlockState state) {
       return false;
     }
 
     
     public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
       return false;
     }
 
     
     public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
       drops.add(new ItemStack(Blocks.AIR, 1));
     }
 
     
     public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
       super.onBlockAdded(world, pos, state);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       world.scheduleUpdate(new BlockPos(x, y, z), this, tickRate(world));
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
       Baobabastage1NeighbourBlockChanges.executeProcedure($_dependencies);
     }
 
 
     
     public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
       super.updateTick(world, pos, state, random);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       Baobabastage1UpdateTick.executeProcedure($_dependencies);
       
       world.scheduleUpdate(new BlockPos(x, y, z), this, tickRate(world));
     }
 
 
     
     public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
       super.onBlockActivated(world, pos, state, entity, hand, side, hitX, hitY, hitZ);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("entity", entity);
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       Baobabastage1OnBlockRightClicked.executeProcedure($_dependencies);
       
       return true;
     }
   }
 }




 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockReed;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.properties.IProperty;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.util.math.RayTraceResult;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.EnumPlantType;
 import net.minecraftforge.common.IPlantable;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Weeping_milk_cap extends Elementsbyg.ModElement {
   @ObjectHolder("byg:weeping_milk_cap")
   public static final Block block = null;
   
   public Weeping_milk_cap(Elementsbyg instance) {
     super(instance, 2367);
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("mushroomBrown", block);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustomFlower());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:weeping_milk_cap", "inventory"));
   }
   
   public static class BlockCustomFlower extends BlockReed {
     public BlockCustomFlower() {
       setSoundType(SoundType.PLANT);
       setCreativeTab(BYGTab.tab);
       setHardness(0.01F);
       setResistance(2.0F);
       setLightLevel(0.0F);
       setUnlocalizedName("weeping_milk_cap");
       setRegistryName("weeping_milk_cap");
     }
 
     
     public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
       return new ItemStack(Item.getItemFromBlock((Block)this), 1, damageDropped(state));
     }
 
     
     public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
       return EnumPlantType.Cave;
     }
 
     
     public boolean canPlaceBlockAt(World world, BlockPos pos) {
       Block block2 = world.getBlockState(pos.down()).getBlock();
       return (block2.canSustainPlant(world.getBlockState(pos.down()), (IBlockAccess)world, pos.down(), EnumFacing.UP, (IPlantable)this) || block2 == Weeping_milk_cap.block);
     }
     
     @SideOnly(Side.CLIENT)
     public int colorMultiplier(IBlockAccess p_149720_1_, BlockPos pos, int pass) {
       return 16777215;
     }
 
     
     public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       BlockCustomFlower blockCustomFlower = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       BlackpuffUpdateTick.executeProcedure($_dependencies);
       
       if ((world.getBlockState(pos.down()).getBlock() == blockCustomFlower || checkForDrop(world, pos, state)) && 
         world.isAirBlock(pos.up())) {
         int l;
         for (l = 1; world.getBlockState(pos.down(l)).getBlock() == this; l++);
         if (l < 1) {
           int i1 = ((Integer)state.getValue((IProperty)AGE)).intValue();
           if (i1 == 15) {
             world.setBlockState(pos.up(), getDefaultState());
             world.setBlockState(pos, state.withProperty((IProperty)AGE, Integer.valueOf(0)), 4);
           } else {
             world.setBlockState(pos, state.withProperty((IProperty)AGE, Integer.valueOf(i1 + 1)), 4);
           } 
         } 
       } 
     }
   }
 }




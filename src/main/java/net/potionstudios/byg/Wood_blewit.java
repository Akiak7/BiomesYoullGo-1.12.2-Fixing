 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockFlower;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.creativetab.CreativeTabs;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.NonNullList;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Wood_blewit
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:wood_blewit")
   public static final Block block = null;
   
   public Wood_blewit(Elementsbyg instance) {
     super(instance, 2368);
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
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:wood_blewit", "inventory"));
   }
   
   public static class BlockCustomFlower extends BlockFlower {
     public BlockCustomFlower() {
       setSoundType(SoundType.PLANT);
       setCreativeTab(BYGTab.tab);
       setHardness(0.01F);
       setResistance(2.0F);
       setLightLevel(0.0F);
       setUnlocalizedName("wood_blewit");
       setRegistryName("wood_blewit");
     }
 
     
     public BlockFlower.EnumFlowerColor getBlockType() {
       return BlockFlower.EnumFlowerColor.YELLOW;
     }
 
     
     @SideOnly(Side.CLIENT)
     public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
       for (BlockFlower.EnumFlowerType blockflower$enumflowertype : BlockFlower.EnumFlowerType.getTypes(getBlockType())) {
         list.add(new ItemStack((Block)this, 1, blockflower$enumflowertype.getMeta()));
       }
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
     }
   }
 }




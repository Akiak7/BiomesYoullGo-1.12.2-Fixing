 package net.potionstudios.byg;
 
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockStairs;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.util.BlockRenderLayer;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Sodalite_brick_stairs
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:sodalite_brick_stairs")
   public static final Block block = null;
   
   public Sodalite_brick_stairs(Elementsbyg instance) {
     super(instance, 1748);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("stairsSodaLiteBrcik", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:sodalite_brick_stairs", "inventory"));
   }
   
   public static class BlockCustom
     extends BlockStairs {
     public BlockCustom() {
       super((new Block(Material.ROCK)).getDefaultState());
       setRegistryName("sodalite_brick_stairs");
       setUnlocalizedName("sodalite_brick_stairs");
       setSoundType(SoundType.STONE);
       setHarvestLevel("pickaxe", 1);
       setHardness(1.5F);
       setResistance(30.0F);
       setLightLevel(0.0F);
       setLightOpacity(0);
       setCreativeTab(BYGTab.tab);
     }
 
     
     @SideOnly(Side.CLIENT)
     public BlockRenderLayer getBlockLayer() {
       return BlockRenderLayer.CUTOUT_MIPPED;
     }
 
     
     public boolean isOpaqueCube(IBlockState state) {
       return false;
     }
   }
 }




 package net.potionstudios.byg;
 
 import net.minecraft.block.Block;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Glowcaneblockpurple
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:glowcaneblockpurple")
   public static final Block block = null;
   
   public Glowcaneblockpurple(Elementsbyg instance) {
     super(instance, 888);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("blockGlowCane", block);
   }
 
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:glowcaneblockpurple", "inventory"));
   }
   
   public static class BlockCustom extends Block {
     public BlockCustom() {
       super(Material.REDSTONE_LIGHT);
       setRegistryName("glowcaneblockpurple");
       setUnlocalizedName("glowcaneblockpurple");
       setSoundType(SoundType.GLASS);
       setHarvestLevel("pickaxe", 1);
       setHardness(1.5F);
       setResistance(8.0F);
       setLightLevel(1.0F);
       setLightOpacity(1);
       setCreativeTab(BYGTab.tab);
     }
   }
 }




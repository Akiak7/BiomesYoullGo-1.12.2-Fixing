 package net.potionstudios.byg;
 
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockFalling;
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
 public class Whitesand
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:whitesand")
   public static final Block block = null;
   
   public Whitesand(Elementsbyg instance) {
     super(instance, 74);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("sand", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:whitesand", "inventory"));
   }
   
   public static class BlockCustom extends BlockFalling {
     public BlockCustom() {
       super(Material.SAND);
       setRegistryName("whitesand");
       setUnlocalizedName("whitesand");
       setSoundType(SoundType.SAND);
       setHarvestLevel("shovel", 0);
       setHardness(1.0F);
       setResistance(5.0F);
       setLightLevel(0.0F);
       setLightOpacity(255);
       setCreativeTab(BYGTab.tab);
     }
   }
 }




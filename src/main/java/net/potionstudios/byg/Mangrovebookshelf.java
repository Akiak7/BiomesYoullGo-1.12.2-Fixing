 package net.potionstudios.byg;
 
 import net.minecraft.block.Block;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
 public class Mangrovebookshelf
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:mangrovebookshelf")
   public static final Block block = null;
   
   public Mangrovebookshelf(Elementsbyg instance) {
     super(instance, 424);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("bookshelfWood", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:mangrovebookshelf", "inventory"));
   }
   
   public static class BlockCustom extends Block {
     public BlockCustom() {
       super(Material.WOOD);
       setRegistryName("mangrovebookshelf");
       setUnlocalizedName("mangrovebookshelf");
       setSoundType(SoundType.WOOD);
       setHarvestLevel("axe", 0);
       setHardness(1.0F);
       setResistance(8.0F);
       setLightLevel(0.0F);
       setLightOpacity(255);
       setCreativeTab(BYGTab.tab);
     }
 
     
     public float getEnchantPowerBonus(World world, BlockPos pos) {
       return 1.0F;
     }
 
     
     public boolean isFlammable(IBlockAccess blockAccess, BlockPos pos, EnumFacing face) {
       return true;
     }
   }
 }




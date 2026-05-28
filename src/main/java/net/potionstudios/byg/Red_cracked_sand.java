 package net.potionstudios.byg;
 
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockFalling;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.IPlantable;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Red_cracked_sand
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:red_cracked_sand")
   public static final Block block = null;
   
   public Red_cracked_sand(Elementsbyg instance) {
     super(instance, 1275);
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
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:red_cracked_sand", "inventory"));
   }
   
   public static class BlockCustom extends BlockFalling {
     public BlockCustom() {
       super(Material.SAND);
       setRegistryName("red_cracked_sand");
       setUnlocalizedName("red_cracked_sand");
       setSoundType(SoundType.SAND);
       setHarvestLevel("shovel", 0);
       setHardness(1.0F);
       setResistance(5.0F);
       setLightLevel(0.0F);
       setLightOpacity(255);
       setCreativeTab(BYGTab.tab);
     }
 
 
     
     public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
       return true;
     }
   }
 }




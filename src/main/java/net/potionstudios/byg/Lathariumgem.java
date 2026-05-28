 package net.potionstudios.byg;
 
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Lathariumgem
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:lathariumgem")
   public static final Item block = null;
   
   public Lathariumgem(Elementsbyg instance) {
     super(instance, 918);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> new ItemCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("gemLatharium", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:lathariumgem", "inventory"));
   }
   
   public static class ItemCustom extends Item {
     public ItemCustom() {
       setMaxDamage(0);
       this.maxStackSize = 64;
       setUnlocalizedName("lathariumgem");
       setRegistryName("lathariumgem");
       setCreativeTab(BYGTab.tab);
     }
 
     
     public int getItemEnchantability() {
       return 0;
     }
 
     
     public int getMaxItemUseDuration(ItemStack itemstack) {
       return 0;
     }
 
     
     public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
       return 1.0F;
     }
   }
 }




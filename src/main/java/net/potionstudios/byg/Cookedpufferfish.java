 package net.potionstudios.byg;
 
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.creativetab.CreativeTabs;
 import net.minecraft.item.EnumAction;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemFood;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Cookedpufferfish
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:cookedpufferfish")
   public static final Item block = null;
   
   public Cookedpufferfish(Elementsbyg instance) {
     super(instance, 130);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> new ItemFoodCustom());
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:cookedpufferfish", "inventory"));
   }
   
   public static class ItemFoodCustom extends ItemFood {
     public ItemFoodCustom() {
       super(6, 0.3F, false);
       setUnlocalizedName("cookedpufferfish");
       setRegistryName("cookedpufferfish");
       setCreativeTab(CreativeTabs.FOOD);
       setMaxStackSize(64);
     }
 
     
     public EnumAction getItemUseAction(ItemStack par1ItemStack) {
       return EnumAction.EAT;
     }
   }
 }




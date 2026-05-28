 package net.potionstudios.byg;
 
 import net.minecraft.creativetab.CreativeTabs;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class BYGTab
   extends Elementsbyg.ModElement {
   public BYGTab(Elementsbyg instance) {
     super(instance, 317);
   }
   public static CreativeTabs tab = (new CreativeTabs("tabbyg")
     {
       @SideOnly(Side.CLIENT)
       public ItemStack getTabIconItem() {
         return new ItemStack(BYGLogo.block, 1);
       }
       
       @SideOnly(Side.CLIENT)
       public boolean hasSearchBar() {
         return true;
       }
     }).setBackgroundImageName("item_search.png");
 }




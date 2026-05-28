 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Set;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemSpade;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.util.EnumHelper;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Lathariumshovel
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:lathariumshovel")
   public static final Item block = null;
   
   public Lathariumshovel(Elementsbyg instance) {
     super(instance, 936);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> ((Item)(new ItemSpade(EnumHelper.addToolMaterial("LATHARIUMSHOVEL", 2, 950, 9.0F, 2.0F, 8)) {
           public Set<String> getToolClasses(ItemStack stack) {
             HashMap<String, Object> ret = new HashMap<>();
             ret.put("spade", Integer.valueOf(2));
             return ret.keySet();
           }
         }).setUnlocalizedName("lathariumshovel").setRegistryName("lathariumshovel")).setCreativeTab(BYGTab.tab));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:lathariumshovel", "inventory"));
   }
 }




 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Set;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemHoe;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.util.EnumHelper;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Pendoritehoe
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:pendoritehoe")
   public static final Item block = null;
   
   public Pendoritehoe(Elementsbyg instance) {
     super(instance, 521);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> ((Item)(new ItemHoe(EnumHelper.addToolMaterial("PENDORITEHOE", 1, 1200, 4.0F, 5.0F, 2)) {
           public Set<String> getToolClasses(ItemStack stack) {
             HashMap<String, Object> ret = new HashMap<>();
             ret.put("hoe", Integer.valueOf(1));
             return ret.keySet();
           }
         }).setUnlocalizedName("pendoritehoe").setRegistryName("pendoritehoe")).setCreativeTab(BYGTab.tab));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:pendoritehoe", "inventory"));
   }
 }




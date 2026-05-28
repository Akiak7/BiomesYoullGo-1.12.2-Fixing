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
 public class Tamreliteshovel
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:tamreliteshovel")
   public static final Item block = null;
   
   public Tamreliteshovel(Elementsbyg instance) {
     super(instance, 487);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> ((Item)(new ItemSpade(EnumHelper.addToolMaterial("TAMRELITESHOVEL", 2, 750, 6.0F, 1.0F, 8)) {
           public Set<String> getToolClasses(ItemStack stack) {
             HashMap<String, Object> ret = new HashMap<>();
             ret.put("spade", Integer.valueOf(2));
             return ret.keySet();
           }
         }).setUnlocalizedName("tamreliteshovel").setRegistryName("tamreliteshovel")).setCreativeTab(BYGTab.tab));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:tamreliteshovel", "inventory"));
   }
 }




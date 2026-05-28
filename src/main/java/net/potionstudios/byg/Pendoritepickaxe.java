 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Set;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemPickaxe;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.util.EnumHelper;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Pendoritepickaxe
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:pendoritepickaxe")
   public static final Item block = null;
   
   public Pendoritepickaxe(Elementsbyg instance) {
     super(instance, 518);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> ((Item)(new ItemPickaxe(EnumHelper.addToolMaterial("PENDORITEPICKAXE", 5, 1200, 12.0F, 3.0F, 15)) {
           public Set<String> getToolClasses(ItemStack stack) {
             HashMap<String, Object> ret = new HashMap<>();
             ret.put("pickaxe", Integer.valueOf(5));
             return ret.keySet();
           }
         }).setUnlocalizedName("pendoritepickaxe").setRegistryName("pendoritepickaxe")).setCreativeTab(BYGTab.tab));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:pendoritepickaxe", "inventory"));
   }
 }




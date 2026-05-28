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
 public class Tamrelitepickaxe
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:tamrelitepickaxe")
   public static final Item block = null;
   
   public Tamrelitepickaxe(Elementsbyg instance) {
     super(instance, 485);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> ((Item)(new ItemPickaxe(EnumHelper.addToolMaterial("TAMRELITEPICKAXE", 4, 750, 5.0F, 1.0F, 8)) {
           public Set<String> getToolClasses(ItemStack stack) {
             HashMap<String, Object> ret = new HashMap<>();
             ret.put("pickaxe", Integer.valueOf(4));
             return ret.keySet();
           }
         }).setUnlocalizedName("tamrelitepickaxe").setRegistryName("tamrelitepickaxe")).setCreativeTab(BYGTab.tab));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:tamrelitepickaxe", "inventory"));
   }
 }




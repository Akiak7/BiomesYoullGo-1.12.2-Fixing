 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Set;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.item.ItemSword;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.util.EnumHelper;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Pendoritesword
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:pendoritesword")
   public static final Item block = null;
   
   public Pendoritesword(Elementsbyg instance) {
     super(instance, 517);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> ((Item)(new ItemSword(EnumHelper.addToolMaterial("PENDORITESWORD", 1, 1200, 4.0F, 5.0F, 15)) {
           public Set<String> getToolClasses(ItemStack stack) {
             HashMap<String, Object> ret = new HashMap<>();
             ret.put("sword", Integer.valueOf(1));
             return ret.keySet();
           }
         }).setUnlocalizedName("pendoritesword").setRegistryName("pendoritesword")).setCreativeTab(BYGTab.tab));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:pendoritesword", "inventory"));
   }
 }




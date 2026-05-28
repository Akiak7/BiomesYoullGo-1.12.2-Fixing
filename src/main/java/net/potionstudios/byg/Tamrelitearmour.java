 package net.potionstudios.byg;
 
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemArmor;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.util.EnumHelper;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Tamrelitearmour
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:tamrelitearmourhelmet")
   public static final Item helmet = null;
   @ObjectHolder("byg:tamrelitearmourbody")
   public static final Item body = null;
   @ObjectHolder("byg:tamrelitearmourlegs")
   public static final Item legs = null;
   @ObjectHolder("byg:tamrelitearmourboots")
   public static final Item boots = null;
   
   public Tamrelitearmour(Elementsbyg instance) {
     super(instance, 489);
   }
 
   
   public void initElements() {
     ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("TAMRELITEARMOUR", "byg:tamralite_", 44, new int[] { 4, 7, 8, 4 }, 10, null, 2.5F);
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD)).setUnlocalizedName("tamrelitearmourhelmet").setRegistryName("tamrelitearmourhelmet")).setCreativeTab(BYGTab.tab));
     
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST)).setUnlocalizedName("tamrelitearmourbody").setRegistryName("tamrelitearmourbody")).setCreativeTab(BYGTab.tab));
     
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS)).setUnlocalizedName("tamrelitearmourlegs").setRegistryName("tamrelitearmourlegs")).setCreativeTab(BYGTab.tab));
     
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET)).setUnlocalizedName("tamrelitearmourboots").setRegistryName("tamrelitearmourboots")).setCreativeTab(BYGTab.tab));
   }
 
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("byg:tamrelitearmourhelmet", "inventory"));
     ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("byg:tamrelitearmourbody", "inventory"));
     ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("byg:tamrelitearmourlegs", "inventory"));
     ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("byg:tamrelitearmourboots", "inventory"));
   }
 }




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
 public class Kasaiarmour
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:kasaiarmourhelmet")
   public static final Item helmet = null;
   @ObjectHolder("byg:kasaiarmourbody")
   public static final Item body = null;
   @ObjectHolder("byg:kasaiarmourlegs")
   public static final Item legs = null;
   @ObjectHolder("byg:kasaiarmourboots")
   public static final Item boots = null;
   
   public Kasaiarmour(Elementsbyg instance) {
     super(instance, 681);
   }
 
   
   public void initElements() {
     ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("KASAIARMOUR", "byg:kasai_chainmail_", 30, new int[] { 4, 6, 6, 4 }, 11, null, 3.5F);
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD)).setUnlocalizedName("kasaiarmourhelmet").setRegistryName("kasaiarmourhelmet")).setCreativeTab(BYGTab.tab));
     
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST)).setUnlocalizedName("kasaiarmourbody").setRegistryName("kasaiarmourbody")).setCreativeTab(BYGTab.tab));
     
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS)).setUnlocalizedName("kasaiarmourlegs").setRegistryName("kasaiarmourlegs")).setCreativeTab(BYGTab.tab));
     
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET)).setUnlocalizedName("kasaiarmourboots").setRegistryName("kasaiarmourboots")).setCreativeTab(BYGTab.tab));
   }
 
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("byg:kasaiarmourhelmet", "inventory"));
     ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("byg:kasaiarmourbody", "inventory"));
     ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("byg:kasaiarmourlegs", "inventory"));
     ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("byg:kasaiarmourboots", "inventory"));
   }
 }




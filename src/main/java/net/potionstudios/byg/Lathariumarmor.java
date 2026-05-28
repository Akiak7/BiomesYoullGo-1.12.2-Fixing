 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.util.EnumHelper;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Lathariumarmor
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:lathariumarmorhelmet")
   public static final Item helmet = null;
   @ObjectHolder("byg:lathariumarmorbody")
   public static final Item body = null;
   @ObjectHolder("byg:lathariumarmorlegs")
   public static final Item legs = null;
   @ObjectHolder("byg:lathariumarmorboots")
   public static final Item boots = null;
   
   public Lathariumarmor(Elementsbyg instance) {
     super(instance, 920);
   }
 
   
   public void initElements() {
     ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("LATHARIUMARMOR", "byg:latharium_", 30, new int[] { 4, 6, 6, 4 }, 16, null, 3.0F);
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD)).setUnlocalizedName("lathariumarmorhelmet").setRegistryName("lathariumarmorhelmet")).setCreativeTab(BYGTab.tab));
     
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST)).setUnlocalizedName("lathariumarmorbody").setRegistryName("lathariumarmorbody")).setCreativeTab(BYGTab.tab));
     
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS)).setUnlocalizedName("lathariumarmorlegs").setRegistryName("lathariumarmorlegs")).setCreativeTab(BYGTab.tab));
     
     this.elements.items.add(() -> ((Item)(new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET)
         {
           public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
             int x = (int)entity.posX;
             int y = (int)entity.posY;
             int z = (int)entity.posZ;
             
             HashMap<Object, Object> $_dependencies = new HashMap<>();
             $_dependencies.put("entity", entity);
             $_dependencies.put("x", Integer.valueOf(x));
             $_dependencies.put("y", Integer.valueOf(y));
             $_dependencies.put("z", Integer.valueOf(z));
             $_dependencies.put("world", world);
             LathariumarmorBootsTickEvent.executeProcedure((HashMap)$_dependencies);
           }
         }).setUnlocalizedName("lathariumarmorboots").setRegistryName("lathariumarmorboots")).setCreativeTab(BYGTab.tab));
   }
 
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("byg:lathariumarmorhelmet", "inventory"));
     ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("byg:lathariumarmorbody", "inventory"));
     ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("byg:lathariumarmorlegs", "inventory"));
     ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("byg:lathariumarmorboots", "inventory"));
   }
 }




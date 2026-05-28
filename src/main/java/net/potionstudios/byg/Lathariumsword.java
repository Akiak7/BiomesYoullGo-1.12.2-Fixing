 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Set;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.item.ItemSword;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.util.EnumHelper;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Lathariumsword
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:lathariumsword")
   public static final Item block = null;
   
   public Lathariumsword(Elementsbyg instance) {
     super(instance, 933);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> ((Item)(new ItemSword(EnumHelper.addToolMaterial("LATHARIUMSWORD", 1, 950, 4.0F, 3.0F, 8)) {
           public Set<String> getToolClasses(ItemStack stack) {
             HashMap<String, Object> ret = new HashMap<>();
             ret.put("sword", Integer.valueOf(1));
             return ret.keySet();
           }
 
           
           public boolean hitEntity(ItemStack itemstack, EntityLivingBase entity, EntityLivingBase entity2) {
             super.hitEntity(itemstack, entity, entity2);
             int x = (int)entity.posX;
             int y = (int)entity.posY;
             int z = (int)entity.posZ;
             World world = entity.world;
             
             HashMap<Object, Object> $_dependencies = new HashMap<>();
             $_dependencies.put("entity", entity);
             $_dependencies.put("x", Integer.valueOf(x));
             $_dependencies.put("y", Integer.valueOf(y));
             $_dependencies.put("z", Integer.valueOf(z));
             $_dependencies.put("world", world);
             LathariumswordMobIsHitWithTool.executeProcedure((HashMap)$_dependencies);
             
             return true;
           }
         }).setUnlocalizedName("lathariumsword").setRegistryName("lathariumsword")).setCreativeTab(BYGTab.tab));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:lathariumsword", "inventory"));
   }
 }




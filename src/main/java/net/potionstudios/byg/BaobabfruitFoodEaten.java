 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 
 @Elementsbyg.ModElement.Tag
 public class BaobabfruitFoodEaten
   extends Elementsbyg.ModElement {
   public BaobabfruitFoodEaten(Elementsbyg instance) {
     super(instance, 973);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure BaobabfruitFoodEaten!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     if (entity instanceof EntityLivingBase)
       ((EntityLivingBase)entity).clearActivePotions(); 
   }
 }




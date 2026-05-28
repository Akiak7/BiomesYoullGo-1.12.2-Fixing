 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 
 @Elementsbyg.ModElement.Tag
 public class KasaiswordMobIsHitWithTool
   extends Elementsbyg.ModElement {
   public KasaiswordMobIsHitWithTool(Elementsbyg instance) {
     super(instance, 683);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure KasaiswordMobIsHitWithTool!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     entity.setFire(10);
   }
 }




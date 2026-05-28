 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.util.EnumParticleTypes;
 import net.minecraft.world.World;
 import net.minecraft.world.WorldServer;
 
 @Elementsbyg.ModElement.Tag
 public class SpringwaterUpdateTick
   extends Elementsbyg.ModElement {
   public SpringwaterUpdateTick(Elementsbyg instance) {
     super(instance, 2308);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure SpringwaterUpdateTick!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure SpringwaterUpdateTick!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure SpringwaterUpdateTick!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure SpringwaterUpdateTick!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (Math.random() < 0.4D && 
       world instanceof WorldServer)
       ((WorldServer)world).spawnParticle(EnumParticleTypes.WATER_BUBBLE, x, y, z, 2, 1.0D, 1.0D, 1.0D, 0.05D, new int[0]); 
   }
 }




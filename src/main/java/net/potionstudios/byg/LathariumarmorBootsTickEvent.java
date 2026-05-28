 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.init.MobEffects;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.util.EnumParticleTypes;
 import net.minecraft.world.World;
 import net.minecraft.world.WorldServer;
 
 @Elementsbyg.ModElement.Tag
 public class LathariumarmorBootsTickEvent
   extends Elementsbyg.ModElement {
   public LathariumarmorBootsTickEvent(Elementsbyg instance) {
     super(instance, 921);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure LathariumarmorBootsTickEvent!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure LathariumarmorBootsTickEvent!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure LathariumarmorBootsTickEvent!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure LathariumarmorBootsTickEvent!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure LathariumarmorBootsTickEvent!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (entity.isSneaking() == true) {
       if (entity instanceof EntityLivingBase)
         ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 40, 2, false, false)); 
       if (Math.random() < 0.1D && 
         world instanceof WorldServer)
         ((WorldServer)world).spawnParticle(EnumParticleTypes.END_ROD, x, y, z, 5, 3.0D, 3.0D, 3.0D, 1.0D, new int[0]); 
     } 
   }
 }




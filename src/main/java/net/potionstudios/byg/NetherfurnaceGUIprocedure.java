 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class NetherfurnaceGUIprocedure
   extends Elementsbyg.ModElement {
   public NetherfurnaceGUIprocedure(Elementsbyg instance) {
     super(instance, 649);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure NetherfurnaceGUIprocedure!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure NetherfurnaceGUIprocedure!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure NetherfurnaceGUIprocedure!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure NetherfurnaceGUIprocedure!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure NetherfurnaceGUIprocedure!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (entity instanceof EntityPlayer)
       ((EntityPlayer)entity).openGui(byg.instance, NetherfurnaceGUI.GUIID, world, x, y, z); 
   }
 }




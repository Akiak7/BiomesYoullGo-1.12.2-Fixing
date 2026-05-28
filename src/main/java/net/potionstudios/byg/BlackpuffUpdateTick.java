 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class BlackpuffUpdateTick
   extends Elementsbyg.ModElement {
   public BlackpuffUpdateTick(Elementsbyg instance) {
     super(instance, 2376);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure BlackpuffUpdateTick!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure BlackpuffUpdateTick!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure BlackpuffUpdateTick!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure BlackpuffUpdateTick!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (world.getLightFromNeighbors(new BlockPos(x, y, z)) >= 13) {
       world.getBlockState(new BlockPos(x, y, z)).getBlock()
         .dropBlockAsItem(world, new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)), 1);
       world.setBlockToAir(new BlockPos(x, y, z));
     } 
   }
 }




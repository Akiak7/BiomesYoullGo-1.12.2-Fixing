 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class Baobabastage1NeighbourBlockChanges
   extends Elementsbyg.ModElement {
   public Baobabastage1NeighbourBlockChanges(Elementsbyg instance) {
     super(instance, 1168);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure Baobabastage1NeighbourBlockChanges!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure Baobabastage1NeighbourBlockChanges!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure Baobabastage1NeighbourBlockChanges!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure Baobabastage1NeighbourBlockChanges!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     
     if (!((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Baobableaves.block.getDefaultState().getBlock()) ? true : false))
       world.setBlockToAir(new BlockPos(x, y, z)); 
   }
 }




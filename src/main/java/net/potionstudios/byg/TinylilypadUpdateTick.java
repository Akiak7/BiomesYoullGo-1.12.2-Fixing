 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class TinylilypadUpdateTick
   extends Elementsbyg.ModElement {
   public TinylilypadUpdateTick(Elementsbyg instance) {
     super(instance, 2372);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure TinylilypadUpdateTick!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure TinylilypadUpdateTick!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure TinylilypadUpdateTick!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure TinylilypadUpdateTick!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (!((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false)) {
       world.getBlockState(new BlockPos(x, y, z)).getBlock()
         .dropBlockAsItem(world, new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)), 1);
       world.setBlockToAir(new BlockPos(x, y, z));
     } 
   }
 }




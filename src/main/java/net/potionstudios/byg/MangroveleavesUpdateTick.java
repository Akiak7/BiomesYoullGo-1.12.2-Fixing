 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.item.EntityItem;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class MangroveleavesUpdateTick extends Elementsbyg.ModElement {
   public MangroveleavesUpdateTick(Elementsbyg instance) {
     super(instance, 1601);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure MangroveleavesUpdateTick!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure MangroveleavesUpdateTick!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure MangroveleavesUpdateTick!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure MangroveleavesUpdateTick!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     bygVariables.OffZ = -3.0D;
     bygVariables.Found = false;
     if (Math.random() < 0.25D) {
       for (int index0 = 0; index0 < 6; index0++) {
         bygVariables.OffY = -3.0D;
         for (int index1 = 0; index1 < 6; index1++) {
           bygVariables.OffX = -3.0D;
           for (int index2 = 0; index2 < 6; index2++) {
             if (world.getBlockState(new BlockPos((int)(x + bygVariables.OffX), (int)(y + bygVariables.OffY), (int)(z + bygVariables.OffZ)))
               .getBlock() == Mangrovelog.block.getDefaultState().getBlock()) {
               bygVariables.Found = true;
             }
             bygVariables.OffX++;
           } 
           bygVariables.OffY++;
         } 
         bygVariables.OffZ++;
       } 
       if (!bygVariables.Found) {
         world.setBlockToAir(new BlockPos(x, y, z));
         if (Math.random() < 0.02D && 
           !world.isRemote) {
           EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(Mangrovesapling.block, 1));
           entityToSpawn.setPickupDelay(10);
           world.spawnEntity((Entity)entityToSpawn);
         } 
       } 
     } 
   }
 }




 package net.potionstudios.byg;
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.item.EntityItem;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Blocks;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.SoundCategory;
 import net.minecraft.util.SoundEvent;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class CattailsUpdateTick extends Elementsbyg.ModElement {
   public CattailsUpdateTick(Elementsbyg instance) {
     super(instance, 1617);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure CattailsUpdateTick!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure CattailsUpdateTick!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure CattailsUpdateTick!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure CattailsUpdateTick!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     bygVariables.OffZ = -3.0D;
     bygVariables.Found = false;
     if (Math.random() < 1.0D) {
       for (int index0 = 0; index0 < 6; index0++) {
         bygVariables.OffY = -3.0D;
         for (int index1 = 0; index1 < 6; index1++) {
           bygVariables.OffX = -3.0D;
           for (int index2 = 0; index2 < 6; index2++) {
             if (world.getBlockState(new BlockPos((int)(x + bygVariables.OffX), (int)(y + bygVariables.OffY), (int)(z + bygVariables.OffZ)))
               .getBlock() == Blocks.WATER.getDefaultState().getBlock()) {
               bygVariables.Found = true;
             }
             bygVariables.OffX++;
           } 
           bygVariables.OffY++;
         } 
         bygVariables.OffZ++;
       } 
       if (!bygVariables.Found) {
         world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
             .getObject(new ResourceLocation("block.grass.break")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
         
         world.setBlockToAir(new BlockPos(x, y, z));
         if (!world.isRemote) {
           EntityItem entityToSpawn = new EntityItem(world, x, y, z, new ItemStack(Cattail.block, 1));
           entityToSpawn.setPickupDelay(10);
           world.spawnEntity((Entity)entityToSpawn);
         } 
       } 
     } 
   }
 }




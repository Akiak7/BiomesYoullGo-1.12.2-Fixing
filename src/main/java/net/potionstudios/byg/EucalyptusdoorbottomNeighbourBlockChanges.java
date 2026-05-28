 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.SoundCategory;
 import net.minecraft.util.SoundEvent;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class EucalyptusdoorbottomNeighbourBlockChanges extends Elementsbyg.ModElement {
   public EucalyptusdoorbottomNeighbourBlockChanges(Elementsbyg instance) {
     super(instance, 2074);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure EucalyptusdoorbottomNeighbourBlockChanges!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure EucalyptusdoorbottomNeighbourBlockChanges!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure EucalyptusdoorbottomNeighbourBlockChanges!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure EucalyptusdoorbottomNeighbourBlockChanges!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Eucalyptus_door_open_top.block
       .getDefaultState().getBlock()) {
       world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
           .getObject(new ResourceLocation("block.wooden_door.open")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
       
       world.setBlockToAir(new BlockPos(x, y, z));
       world.setBlockState(new BlockPos(x, y, z), Eucalyptus_door_open_bottom.block.getDefaultState(), 3);
     } 
   }
 }




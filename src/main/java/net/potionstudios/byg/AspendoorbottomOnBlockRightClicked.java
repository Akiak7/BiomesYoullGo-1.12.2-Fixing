 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.SoundCategory;
 import net.minecraft.util.SoundEvent;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class AspendoorbottomOnBlockRightClicked extends Elementsbyg.ModElement {
   public AspendoorbottomOnBlockRightClicked(Elementsbyg instance) {
     super(instance, 1754);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure AspendoorbottomOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure AspendoorbottomOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure AspendoorbottomOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure AspendoorbottomOnBlockRightClicked!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
         .getObject(new ResourceLocation("block.wooden_door.open")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
     
     world.setBlockToAir(new BlockPos(x, y, z));
     world.setBlockState(new BlockPos(x, y, z), Aspen_door_open_bottom.block.getDefaultState(), 3);
   }
 }




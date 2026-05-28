 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.SoundCategory;
 import net.minecraft.util.SoundEvent;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class WitchhazeldoorRightClickedOnBlock extends Elementsbyg.ModElement {
   public WitchhazeldoorRightClickedOnBlock(Elementsbyg instance) {
     super(instance, 1930);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure WitchhazeldoorRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure WitchhazeldoorRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure WitchhazeldoorRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure WitchhazeldoorRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure WitchhazeldoorRightClickedOnBlock!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (!((entity instanceof EntityPlayer) ? ((EntityPlayer)entity).capabilities.isCreativeMode : false)) {
       if (entity instanceof EntityPlayer) {
         ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Witch_hazel_door.block, 1)).getItem(), -1, 1, null);
       }
       world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
           .getObject(new ResourceLocation("block.wood.place")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
       
       world.setBlockState(new BlockPos(x, y + 1, z), Witch_hazel_door_bottom.block.getDefaultState(), 3);
       world.setBlockState(new BlockPos(x, y + 2, z), Witch_hazel_door_top.block.getDefaultState(), 3);
     } else if (((entity instanceof EntityPlayer) ? ((EntityPlayer)entity).capabilities.isCreativeMode : false) == true) {
       world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
           .getObject(new ResourceLocation("block.wood.place")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
       
       world.setBlockState(new BlockPos(x, y + 1, z), Witch_hazel_door_bottom.block.getDefaultState(), 3);
       world.setBlockState(new BlockPos(x, y + 2, z), Witch_hazel_door_top.block.getDefaultState(), 3);
     } 
   }
 }




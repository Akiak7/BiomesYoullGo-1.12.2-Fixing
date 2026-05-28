 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Blocks;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.SoundCategory;
 import net.minecraft.util.SoundEvent;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class ReedsRightClickedOnBlock extends Elementsbyg.ModElement {
   public ReedsRightClickedOnBlock(Elementsbyg instance) {
     super(instance, 1611);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure ReedsRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure ReedsRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure ReedsRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure ReedsRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure ReedsRightClickedOnBlock!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Mudblock.block.getDefaultState().getBlock() || world
       .getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.GRASS.getDefaultState().getBlock()) {
       world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
           .getObject(new ResourceLocation("block.grass.place")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
       
       if (entity instanceof EntityPlayer)
         ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Reeds.block, 1)).getItem(), -1, 1, null); 
       world.setBlockState(new BlockPos(x, y + 1, z), Reed.block.getDefaultState(), 3);
     } 
   }
 }




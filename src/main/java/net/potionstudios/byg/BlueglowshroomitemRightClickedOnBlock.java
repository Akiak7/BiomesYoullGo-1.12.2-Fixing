 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.SoundCategory;
 import net.minecraft.util.SoundEvent;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class BlueglowshroomitemRightClickedOnBlock extends Elementsbyg.ModElement {
   public BlueglowshroomitemRightClickedOnBlock(Elementsbyg instance) {
     super(instance, 2413);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure BlueglowshroomitemRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure BlueglowshroomitemRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure BlueglowshroomitemRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure BlueglowshroomitemRightClickedOnBlock!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure BlueglowshroomitemRightClickedOnBlock!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (new ItemStack(Blueglowshroomitem.block, 1))
       .getItem()) {
       world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
           .getObject(new ResourceLocation("block.slime.place")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
       
       if (entity instanceof EntityPlayer) {
         ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Blueglowshroomitem.block, 1)).getItem(), -1, 1, null);
       }
       world.setBlockState(new BlockPos(x, y + 1, z), Small_blue_glowshroom.block.getDefaultState(), 3);
     } 
   }
 }




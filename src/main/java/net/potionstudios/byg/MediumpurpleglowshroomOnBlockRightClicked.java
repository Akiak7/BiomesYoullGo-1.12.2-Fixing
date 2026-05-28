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
 public class MediumpurpleglowshroomOnBlockRightClicked extends Elementsbyg.ModElement {
   public MediumpurpleglowshroomOnBlockRightClicked(Elementsbyg instance) {
     super(instance, 2412);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure MediumpurpleglowshroomOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure MediumpurpleglowshroomOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure MediumpurpleglowshroomOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure MediumpurpleglowshroomOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure MediumpurpleglowshroomOnBlockRightClicked!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (new ItemStack(Purpleglowshroomitem.block, 1))
       .getItem()) {
       world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
           .getObject(new ResourceLocation("block.slime.place")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
       
       if (entity instanceof EntityPlayer) {
         ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Purpleglowshroomitem.block, 1)).getItem(), -1, 1, null);
       }
       world.setBlockToAir(new BlockPos(x, y, z));
       world.setBlockState(new BlockPos(x, y, z), Purple_glowshroom.block.getDefaultState(), 3);
     } 
   }
 }




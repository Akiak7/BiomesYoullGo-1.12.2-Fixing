 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.EnumParticleTypes;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraft.world.WorldServer;
 
 @Elementsbyg.ModElement.Tag
 public class Rudostage2OnBlockRightclicked
   extends Elementsbyg.ModElement {
   public Rudostage2OnBlockRightclicked(Elementsbyg instance) {
     super(instance, 864);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure Rudostage2OnBlockRightclicked!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure Rudostage2OnBlockRightclicked!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure Rudostage2OnBlockRightclicked!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure Rudostage2OnBlockRightclicked!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure Rudostage2OnBlockRightclicked!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (Math.random() < 0.4D && entity instanceof EntityPlayer && ((EntityPlayer)entity).inventory.hasItemStack(new ItemStack(Items.DYE, 1, 15))) {
       
       if (world instanceof WorldServer)
         ((WorldServer)world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, x, y, z, 5, 3.0D, 3.0D, 3.0D, 1.0D, new int[0]); 
       if (entity instanceof EntityPlayer)
         ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Items.DYE, 1, 15)).getItem(), 15, 1, null); 
       world.setBlockToAir(new BlockPos(x, y, z));
       world.setBlockState(new BlockPos(x, y, z), Rudostage3.block.getDefaultState(), 3);
     }
     else if (entity instanceof EntityPlayer) {
       ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Items.DYE, 1, 15)).getItem(), 15, 1, null);
     } 
   }
 }




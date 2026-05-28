 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class JacarandaslabOnBlockRightClicked
   extends Elementsbyg.ModElement {
   public JacarandaslabOnBlockRightClicked(Elementsbyg instance) {
     super(instance, 804);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure JacarandaslabOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure JacarandaslabOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure JacarandaslabOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure JacarandaslabOnBlockRightClicked!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure JacarandaslabOnBlockRightClicked!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (entity instanceof EntityPlayer && ((EntityPlayer)entity).inventory
       .hasItemStack(new ItemStack(Jacarandaslab.block, 1))) {
       
       world.setBlockToAir(new BlockPos(x, y, z));
       world.setBlockState(new BlockPos(x, y, z), Jacarandaplanks.block.getDefaultState(), 3);
       if (entity instanceof EntityPlayer)
         ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Jacarandaslab.block, 1)).getItem(), -1, 1, null); 
     } 
   }
 }




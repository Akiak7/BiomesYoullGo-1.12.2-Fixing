 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 @Elementsbyg.ModElement.Tag
 public class StructurecheckblockUpdateTick
   extends Elementsbyg.ModElement {
   public StructurecheckblockUpdateTick(Elementsbyg instance) {
     super(instance, 1191);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure StructurecheckblockUpdateTick!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure StructurecheckblockUpdateTick!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure StructurecheckblockUpdateTick!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure StructurecheckblockUpdateTick!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     
     if (!((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Structure_check_block_disabled.block.getDefaultState().getBlock()) ? true : false)) {
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Pinelog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Pinelog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Pinelog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Pinelog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Skyrislog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Skyrislog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Skyrislog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Skyrislog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Firlog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Firlog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Firlog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Firlog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Frozenoaklog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Frozenoaklog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Frozenoaklog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Frozenoaklog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Enchantedlog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Enchantedlog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Enchantedlog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Enchantedlog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Greenenchantedlog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Greenenchantedlog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Greenenchantedlog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Greenenchantedlog.block.getDefaultState(), 3);
       } 
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.LOG.getStateFromMeta(1).getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Blocks.LOG.getStateFromMeta(1), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.LOG.getStateFromMeta(1).getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Blocks.LOG.getStateFromMeta(1), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Willowlog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Willowlog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Willowlog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Willowlog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Witchhazellog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Witchhazellog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Witchhazellog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Witchhazellog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Baobablog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Baobablog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Baobablog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Baobablog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Mangrovelog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Mangrovelog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Mangrovelog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Mangrovelog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Cypresslog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Cypresslog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Cypresslog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Cypresslog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Cikalog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Cikalog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Cikalog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Cikalog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Redwoodlog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Redwoodlog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Redwoodlog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Redwoodlog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Maplelog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Maplelog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Maplelog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Maplelog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Ebonylog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Ebonylog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Ebonylog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Ebonylog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Mahogany_log.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Mahogany_log.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Mahogany_log.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Mahogany_log.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Palm_log.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Palm_log.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Palm_log.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Palm_log.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Cherrylog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Cherrylog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Cherrylog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Cherrylog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Hawthornlog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Hawthornlog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Hawthornlog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Hawthornlog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Rowanlog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Rowanlog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Rowanlog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Rowanlog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Aspen_log.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Aspen_log.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Aspen_log.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Aspen_log.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Hollylog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Hollylog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Hollylog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Hollylog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Rainboweucalyptuslog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Rainboweucalyptuslog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Rainboweucalyptuslog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Rainboweucalyptuslog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Zelkovalog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Zelkovalog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Zelkovalog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Zelkovalog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Greatoaklog.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Greatoaklog.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Greatoaklog.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Greatoaklog.block.getDefaultState(), 3);
       } 
       
       if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Plant_stem.block.getDefaultState().getBlock()) ? true : false) == true && ((
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) == true || (
         (world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false) == true)) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Plant_stem.block.getDefaultState(), 3);
         world.setBlockState(new BlockPos(x, y - 1, z), Structurecheckblock.block.getDefaultState(), 3);
       }
       else if (((world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Plant_stem.block.getDefaultState().getBlock()) ? true : false) == true && (
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FLOWING_WATER.getDefaultState().getBlock()) ? true : false) || 
         !((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) ? true : false))) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Plant_stem.block.getDefaultState(), 3);
       } 
     } 
   }
 }




 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.block.Block;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.EnumParticleTypes;
 import net.minecraft.util.Mirror;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.Rotation;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.util.math.ChunkPos;
 import net.minecraft.world.World;
 import net.minecraft.world.WorldServer;
 import net.minecraft.world.gen.structure.template.PlacementSettings;
 import net.minecraft.world.gen.structure.template.Template;
 
 @Elementsbyg.ModElement.Tag
 public class GreatoaksaplingOnBlockRightclicked
   extends Elementsbyg.ModElement {
   public GreatoaksaplingOnBlockRightclicked(Elementsbyg instance) {
     super(instance, 564);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure GreatoaksaplingOnBlockRightclicked!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure GreatoaksaplingOnBlockRightclicked!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure GreatoaksaplingOnBlockRightclicked!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure GreatoaksaplingOnBlockRightclicked!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure GreatoaksaplingOnBlockRightclicked!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (Math.random() < 0.4D && ((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY)
       .getItem() == (new ItemStack(Items.DYE, 1, 15)).getItem() && world.canSeeSky(new BlockPos(x, y, z)) && world
       .isDaytime() && ((world.getBiome(new BlockPos(x, y, z)).getTemperature(new BlockPos(x, y, z)) * 100.0F) >= 0.7D || (world
       .getBiome(new BlockPos(x, y, z)).getTemperature(new BlockPos(x, y, z)) * 100.0F) <= 0.89D)) {
       if (Math.random() < 0.5D) {
         if (entity instanceof EntityPlayer)
           ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Items.DYE, 1, 15)).getItem(), 15, 1, null); 
         world.setBlockToAir(new BlockPos(x, y, z));
         
         if (world.isRemote)
           return; 
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "sapling_skyris1"));
         
         if (template == null)
           return; 
         BlockPos spawnTo = new BlockPos(x - 0, y, z - 0);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
       } else {
         
         if (entity instanceof EntityPlayer)
           ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Items.DYE, 1, 15)).getItem(), 15, 1, null); 
         world.setBlockToAir(new BlockPos(x, y, z));
         
         if (world.isRemote)
           return; 
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "sapling_skyris2"));
         
         if (template == null)
           return; 
         BlockPos spawnTo = new BlockPos(x - 0, y, z - 0);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
       }
     
     } else if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (new ItemStack(Items.DYE, 1, 15))
       .getItem()) {
       if (entity instanceof EntityPlayer)
         ((EntityPlayer)entity).inventory.clearMatchingItems((new ItemStack(Items.DYE, 1, 15)).getItem(), 15, 1, null); 
       if (world instanceof WorldServer)
         ((WorldServer)world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, x, y, z, 5, 3.0D, 3.0D, 3.0D, 1.0D, new int[0]); 
     } 
   }
 }




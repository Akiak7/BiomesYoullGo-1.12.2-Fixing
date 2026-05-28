 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.block.Block;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.Mirror;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.Rotation;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.util.math.ChunkPos;
 import net.minecraft.world.World;
 import net.minecraft.world.WorldServer;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.gen.structure.template.PlacementSettings;
 import net.minecraft.world.gen.structure.template.Template;
 
 @Elementsbyg.ModElement.Tag
 public class StructurespawnblockUpdateTick
   extends Elementsbyg.ModElement {
   public StructurespawnblockUpdateTick(Elementsbyg instance) {
     super(instance, 2399);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure StructurespawnblockUpdateTick!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure StructurespawnblockUpdateTick!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure StructurespawnblockUpdateTick!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure StructurespawnblockUpdateTick!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (((ResourceLocation)Biome.REGISTRY.getNameForObject(world.getBiome(new BlockPos(x, y, z)))).equals(new ResourceLocation("byg:bcolored_canyons")) == true) {
       
       if (y <= 100 && Math.random() < 0.2D) {
         
         if (world.isRemote)
           return; 
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "canyon_color_middle1"));
         
         if (template == null)
           return; 
         BlockPos spawnTo = new BlockPos(x - 3, y - 1, z - 3);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
         
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Blocks.SAND.getStateFromMeta(1), 3);
       }
       else if (Math.random() < 0.5D) {
         
         if (world.isRemote)
           return; 
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "canyon_color_top1"));
         
         if (template == null)
           return; 
         BlockPos spawnTo = new BlockPos(x - 3, y - 1, z - 4);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
         
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Blocks.SAND.getStateFromMeta(1), 3);
       } else {
         
         if (world.isRemote)
           return; 
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "canyon_color_top2"));
         
         if (template == null)
           return; 
         BlockPos spawnTo = new BlockPos(x - 5, y - 1, z - 6);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
         
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Blocks.SAND.getStateFromMeta(1), 3);
       } 
     } else {
       
       world.setBlockToAir(new BlockPos(x, y, z));
       world.setBlockState(new BlockPos(x, y, z), Blocks.SAND.getStateFromMeta(1), 3);
     } 
     if (((ResourceLocation)Biome.REGISTRY.getNameForObject(world.getBiome(new BlockPos(x, y, z)))).equals(new ResourceLocation("byg:bcrystal_canyons")) == true) {
       
       if (Math.random() < 0.25D) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Whitesand.block.getDefaultState(), 3);
         
         if (world.isRemote)
           return; 
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "canyon_crystal_topblue"));
         
         if (template == null)
           return; 
         BlockPos spawnTo = new BlockPos(x - 2, y - 5, z - 3);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
       }
       else if (Math.random() < 0.25D) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Whitesand.block.getDefaultState(), 3);
         
         if (world.isRemote)
           return; 
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "canyon_crystal_toppurple"));
         
         if (template == null)
           return; 
         BlockPos spawnTo = new BlockPos(x - 3, y - 5, z - 3);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
       } 
       
       if (Math.random() < 0.25D) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Whitesand.block.getDefaultState(), 3);
         
         if (world.isRemote)
           return; 
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "canyon_crystal_topred"));
         
         if (template == null)
           return; 
         BlockPos spawnTo = new BlockPos(x - 3, y - 5, z - 3);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
       }
       else if (Math.random() < 0.25D) {
         world.setBlockToAir(new BlockPos(x, y, z));
         world.setBlockState(new BlockPos(x, y, z), Whitesand.block.getDefaultState(), 3);
         
         if (world.isRemote)
           return; 
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "canyon_crystal_topwhite"));
         
         if (template == null)
           return; 
         BlockPos spawnTo = new BlockPos(x - 3, y - 5, z - 3);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
       } 
     } else {
       
       world.setBlockToAir(new BlockPos(x, y, z));
       world.setBlockState(new BlockPos(x, y, z), Whitesand.block.getDefaultState(), 3);
     } 
   }
 }




 package net.potionstudios.byg;
 
 import java.util.Random;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.chunk.IChunkProvider;
 import net.minecraft.world.gen.IChunkGenerator;
 
 @Elementsbyg.ModElement.Tag
 public class Zelkovan extends Elementsbyg.ModElement {
   public Zelkovan(Elementsbyg instance) {
     super(instance, 355);
   }
 
   
   public void generateWorld(Random random, int i2, int k2, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
     boolean dimensionCriteria = false;
     boolean isNetherType = false;
     if (dimID == 0)
       dimensionCriteria = true; 
     if (!dimensionCriteria)
       return; 
     if (random.nextInt(1000000) + 1 <= 1000000) {
       int i = i2 + random.nextInt(16) + 8;
       int k = k2 + random.nextInt(16) + 8;
       int height = 255;
       if (isNetherType) {
         boolean notpassed = true;
         while (height > 0) {
           if (notpassed && (world
             .isAirBlock(new BlockPos(i, height, k)) || world.getBlockState(new BlockPos(i, height, k)).getBlock()
             .isReplaceable((IBlockAccess)world, new BlockPos(i, height, k)))) {
             notpassed = false;
           } else if (!notpassed && !world.isAirBlock(new BlockPos(i, height, k)) && 
             !world.getBlockState(new BlockPos(i, height, k)).getBlock().isReplaceable((IBlockAccess)world, new BlockPos(i, height, k))) {
             break;
           }  height--;
         } 
       } else {
         while (height > 0 && (
           world.isAirBlock(new BlockPos(i, height, k)) || world
           .getBlockState(new BlockPos(i, height, k)).getBlock().isReplaceable((IBlockAccess)world, new BlockPos(i, height, k))))
         {
           height--;
         }
       } 
       int j = height - 1;
       IBlockState blockAt = world.getBlockState(new BlockPos(i, j + 1, k));
       boolean blockCriteria = false;
       
       IBlockState require = Blocks.TALLGRASS.getDefaultState();
       if (blockAt.getBlock() == require.getBlock())
         blockCriteria = true; 
       if (!blockCriteria)
         return; 
       boolean biomeCriteria = false;
       Biome biome = world.getBiome(new BlockPos(i, j, k));
       if (((ResourceLocation)Biome.REGISTRY.getNameForObject(biome)).equals(new ResourceLocation("byg:bzelkovaforest")))
         biomeCriteria = true; 
       if (!biomeCriteria)
         return;
       if (world.isRemote)
         return;
       world.setBlockState(new BlockPos(i, j + 1, k), Kovan.block.getDefaultState(), 3);
     }
   }
 }


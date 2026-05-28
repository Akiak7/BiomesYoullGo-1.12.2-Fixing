 package net.potionstudios.byg;
 
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.gen.feature.WorldGenAbstractTree;
 import net.minecraftforge.common.BiomeDictionary;
 import net.minecraftforge.common.BiomeManager;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class BRedwoodTropics
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:bredwoodtropics")
   public static final BiomeGenCustom biome = null;
   
   public BRedwoodTropics(Elementsbyg instance) {
     super(instance, 192);
   }
 
   
   public void initElements() {
     this.elements.biomes.add(() -> new BiomeGenCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST });
     BiomeManager.addSpawnBiome(biome);
     BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 4));
   }
   
   static class BiomeGenCustom extends Biome {
     public BiomeGenCustom() {
       super((new Biome.BiomeProperties("Redwood Tropics")).setRainfall(0.8F).setBaseHeight(0.5F).setWaterColor(-12618012)
           .setHeightVariation(0.1F).setTemperature(0.95F));
       setRegistryName("bredwoodtropics");
       this.topBlock = Blocks.GRASS.getDefaultState();
       this.fillerBlock = Blocks.DIRT.getStateFromMeta(0);
       this.decorator.generateFalls = false;
       this.decorator.treesPerChunk = 0;
       this.decorator.flowersPerChunk = 2;
       this.decorator.grassPerChunk = 20;
       this.decorator.deadBushPerChunk = 0;
       this.decorator.mushroomsPerChunk = 2;
       this.decorator.bigMushroomsPerChunk = 0;
       this.decorator.reedsPerChunk = 30;
       this.decorator.cactiPerChunk = 0;
       this.decorator.sandPatchesPerChunk = 35;
       this.decorator.gravelPatchesPerChunk = 0;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getGrassColorAtPos(BlockPos pos) {
       return -11167488;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getFoliageColorAtPos(BlockPos pos) {
       return -11167488;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getSkyColorByTemp(float currentTemperature) {
       return -13395457;
     }
 
     
     public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
       return new BRedwoodTropics.CustomTree();
     }
   }
   
   static class CustomTree extends WorldGenAbstractTree {
     CustomTree() {
       super(false);
     }
 
     
     public boolean generate(World world, Random rand, BlockPos position) {
       int height = rand.nextInt(5) + 10;
       boolean spawnTree = true;
       if (position.getY() >= 1 && position.getY() + height + 1 <= world.getHeight()) {
         for (int j = position.getY(); j <= position.getY() + 1 + height; j++) {
           int k = 1;
           if (j == position.getY())
             k = 0; 
           if (j >= position.getY() + height - 1)
             k = 2; 
           for (int px = position.getX() - k; px <= position.getX() + k && spawnTree; px++) {
             for (int pz = position.getZ() - k; pz <= position.getZ() + k && spawnTree; pz++) {
               if (j >= 0 && j < world.getHeight()) {
                 if (!isReplaceable(world, new BlockPos(px, j, pz))) {
                   spawnTree = false;
                 }
               } else {
                 spawnTree = false;
               } 
             } 
           } 
         } 
         if (!spawnTree) {
           return false;
         }
         Block ground = world.getBlockState(position.add(0, -1, 0)).getBlock();
         Block ground2 = world.getBlockState(position.add(0, -2, 0)).getBlock();
         if ((ground != Blocks.GRASS.getDefaultState().getBlock() && ground != Blocks.DIRT.getStateFromMeta(0).getBlock()) || (ground2 != Blocks.GRASS
           .getDefaultState().getBlock() && ground2 != Blocks.DIRT.getStateFromMeta(0).getBlock()))
           return false; 
         IBlockState state = world.getBlockState(position.down());
         if (position.getY() < world.getHeight() - height - 1) {
           world.setBlockState(position.down(), Blocks.DIRT.getStateFromMeta(0), 2); int genh;
           for (genh = position.getY() - 3 + height; genh <= position.getY() + height; genh++) {
             int i4 = genh - position.getY() + height;
             int j1 = (int)(1.0D - i4 * 0.5D);
             for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; k1++) {
               for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; i2++) {
                 int j2 = i2 - position.getZ();
                 if (Math.abs(position.getX()) != j1 || Math.abs(j2) != j1 || (rand.nextInt(2) != 0 && i4 != 0)) {
                   BlockPos blockpos = new BlockPos(k1, genh, i2);
                   state = world.getBlockState(blockpos);
                   if (state.getBlock().isAir(state, (IBlockAccess)world, blockpos) || state.getBlock().isLeaves(state, (IBlockAccess)world, blockpos) || state
                     .getBlock() == Blocks.AIR.getDefaultState().getBlock() || state
                     .getBlock() == Blocks.AIR.getDefaultState().getBlock()) {
                     setBlockAndNotifyAdequately(world, blockpos, Blocks.AIR.getDefaultState());
                   }
                 } 
               } 
             } 
           } 
           for (genh = 0; genh < height; genh++) {
             BlockPos genhPos = position.up(genh);
             state = world.getBlockState(genhPos);
             if (state.getBlock().isAir(state, (IBlockAccess)world, genhPos) || state.getBlock() == Blocks.AIR.getDefaultState().getBlock() || state
               .getBlock() == Blocks.AIR.getDefaultState().getBlock()) {
               setBlockAndNotifyAdequately(world, position.up(genh), Blocks.AIR.getDefaultState());
             }
           } 
           if (rand.nextInt(4) == 0 && height > 5) {
             for (int hlevel = 0; hlevel < 2; hlevel++) {
               for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
                 if (rand.nextInt(4 - hlevel) == 0) {
                   EnumFacing enumfacing1 = enumfacing.getOpposite();
                   setBlockAndNotifyAdequately(world, position
                       .add(enumfacing1.getFrontOffsetX(), height - 5 + hlevel, enumfacing1.getFrontOffsetZ()), Blocks.AIR
                       .getDefaultState());
                 } 
               } 
             } 
           }
           return true;
         } 
         return false;
       } 
 
       
       return false;
     }
 
     
     private void addVines(World world, BlockPos pos) {
       setBlockAndNotifyAdequately(world, pos, Blocks.AIR.getDefaultState());
       int i = 5;
       for (BlockPos blockpos = pos.down(); world.isAirBlock(blockpos) && i > 0; i--) {
         setBlockAndNotifyAdequately(world, blockpos, Blocks.AIR.getDefaultState());
         blockpos = blockpos.down();
       } 
     }
 
     
     protected boolean canGrowInto(Block blockType) {
       return (blockType.getDefaultState().getMaterial() == Material.AIR || blockType == Blocks.AIR.getDefaultState().getBlock() || blockType == Blocks.AIR
         .getDefaultState().getBlock() || blockType == Blocks.GRASS.getDefaultState().getBlock() || blockType == Blocks.DIRT
         .getStateFromMeta(0).getBlock());
     }
 
     
     protected void setDirtAt(World world, BlockPos pos) {
       if (world.getBlockState(pos).getBlock() != Blocks.DIRT.getStateFromMeta(0).getBlock()) {
         setBlockAndNotifyAdequately(world, pos, Blocks.DIRT.getStateFromMeta(0));
       }
     }
     
     public boolean isReplaceable(World world, BlockPos pos) {
       IBlockState state = world.getBlockState(pos);
       return (state.getBlock().isAir(state, (IBlockAccess)world, pos) || canGrowInto(state.getBlock()) || state.getBlock().isReplaceable((IBlockAccess)world, pos));
     }
   }
 }




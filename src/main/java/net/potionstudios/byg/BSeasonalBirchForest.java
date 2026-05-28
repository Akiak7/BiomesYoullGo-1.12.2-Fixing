 package net.potionstudios.byg;
 
 import java.util.Random;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.gen.feature.WorldGenAbstractTree;
 import net.minecraft.world.gen.feature.WorldGenBirchTree;
 import net.minecraftforge.common.BiomeDictionary;
 import net.minecraftforge.common.BiomeManager;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class BSeasonalBirchForest
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:bseasonalbirchforest")
   public static final BiomeGenCustom biome = null;
   
   public BSeasonalBirchForest(Elementsbyg instance) {
     super(instance, 1047);
   }
 
   
   public void initElements() {
     this.elements.biomes.add(() -> new BiomeGenCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD });
     BiomeManager.addSpawnBiome(biome);
     BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 4));
   }
   
   static class BiomeGenCustom extends Biome {
     public BiomeGenCustom() {
       super((new Biome.BiomeProperties("Seasonal Birch Forest")).setRainfall(0.4F).setBaseHeight(0.75F).setWaterColor(-14329397)
           .setHeightVariation(0.1F).setTemperature(0.25F));
       setRegistryName("bseasonalbirchforest");
       this.topBlock = Blocks.GRASS.getDefaultState();
       this.fillerBlock = Blocks.DIRT.getStateFromMeta(0);
       this.decorator.generateFalls = false;
       this.decorator.treesPerChunk = 0;
       this.decorator.flowersPerChunk = 2;
       this.decorator.grassPerChunk = 12;
       this.decorator.deadBushPerChunk = 0;
       this.decorator.mushroomsPerChunk = 0;
       this.decorator.bigMushroomsPerChunk = 0;
       this.decorator.reedsPerChunk = 0;
       this.decorator.cactiPerChunk = 0;
       this.decorator.sandPatchesPerChunk = 0;
       this.decorator.gravelPatchesPerChunk = 25;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getGrassColorAtPos(BlockPos pos) {
       return -3039697;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getFoliageColorAtPos(BlockPos pos) {
       return -3039697;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getSkyColorByTemp(float currentTemperature) {
       return -13395457;
     }
 
     
     public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
       return (WorldGenAbstractTree)new WorldGenBirchTree(true, true);
     }
   }
 }




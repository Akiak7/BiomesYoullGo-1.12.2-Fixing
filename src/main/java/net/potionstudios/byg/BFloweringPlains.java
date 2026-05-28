 package net.potionstudios.byg;
 
 import java.util.Random;
 import net.minecraft.init.Blocks;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.gen.feature.WorldGenAbstractTree;
 import net.minecraftforge.common.BiomeDictionary;
 import net.minecraftforge.common.BiomeManager;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 
 @Elementsbyg.ModElement.Tag
 public class BFloweringPlains
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:bfloweringplains")
   public static final BiomeGenCustom biome = null;
   
   public BFloweringPlains(Elementsbyg instance) {
     super(instance, 1967);
   }
 
   
   public void initElements() {
     this.elements.biomes.add(() -> new BiomeGenCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE });
     BiomeManager.addSpawnBiome(biome);
     BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 2));
   }
   
   static class BiomeGenCustom extends Biome {
     public BiomeGenCustom() {
       super((new Biome.BiomeProperties("Flowering Plains")).setRainfall(0.6F).setBaseHeight(0.25F).setHeightVariation(0.15F).setTemperature(0.8F));
       setRegistryName("bfloweringplains");
       this.topBlock = Blocks.GRASS.getDefaultState();
       this.fillerBlock = Blocks.DIRT.getDefaultState();
       this.decorator.generateFalls = false;
       this.decorator.treesPerChunk = 0;
       this.decorator.flowersPerChunk = 0;
       this.decorator.grassPerChunk = 35;
       this.decorator.deadBushPerChunk = 0;
       this.decorator.mushroomsPerChunk = 0;
       this.decorator.bigMushroomsPerChunk = 0;
       this.decorator.reedsPerChunk = 0;
       this.decorator.cactiPerChunk = 0;
       this.decorator.sandPatchesPerChunk = 0;
       this.decorator.gravelPatchesPerChunk = 0;
     }
 
     
     public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
       return super.getRandomTreeFeature(rand);
     }
   }
 }




 package net.potionstudios.byg;
 
 import java.util.Random;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.gen.feature.WorldGenAbstractTree;
 import net.minecraft.world.gen.feature.WorldGenSavannaTree;
 import net.minecraftforge.common.BiomeDictionary;
 import net.minecraftforge.common.BiomeManager;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class BSavannaCanopy
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:bsavannacanopy")
   public static final BiomeGenCustom biome = null;
   
   public BSavannaCanopy(Elementsbyg instance) {
     super(instance, 209);
   }
 
   
   public void initElements() {
     this.elements.biomes.add(() -> new BiomeGenCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.HOT, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST });
     
     BiomeManager.addSpawnBiome(biome);
     BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 3));
   }
   
   static class BiomeGenCustom extends Biome {
     public BiomeGenCustom() {
       super((new Biome.BiomeProperties("Savanna Canopy")).setRainfall(0.3F).setBaseHeight(0.2F).setWaterColor(-13407068).setHeightVariation(0.1F)
           .setTemperature(1.2F));
       setRegistryName("bsavannacanopy");
       this.topBlock = Blocks.GRASS.getDefaultState();
       this.fillerBlock = Blocks.DIRT.getStateFromMeta(0);
       this.decorator.generateFalls = false;
       this.decorator.treesPerChunk = 2;
       this.decorator.flowersPerChunk = 3;
       this.decorator.grassPerChunk = 15;
       this.decorator.deadBushPerChunk = 0;
       this.decorator.mushroomsPerChunk = 1;
       this.decorator.bigMushroomsPerChunk = 0;
       this.decorator.reedsPerChunk = 5;
       this.decorator.cactiPerChunk = 0;
       this.decorator.sandPatchesPerChunk = 15;
       this.decorator.gravelPatchesPerChunk = 0;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getGrassColorAtPos(BlockPos pos) {
       return -4474795;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getFoliageColorAtPos(BlockPos pos) {
       return -4474795;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getSkyColorByTemp(float currentTemperature) {
       return -13395457;
     }
 
     
     public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
       return (WorldGenAbstractTree)new WorldGenSavannaTree(false);
     }
   }
 }




 package net.potionstudios.byg;
 
 import java.util.Random;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.gen.feature.WorldGenAbstractTree;
 import net.minecraftforge.common.BiomeDictionary;
 import net.minecraftforge.common.BiomeManager;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class BRedOakForest
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:bredoakforest")
   public static final BiomeGenCustom biome = null;
   
   public BRedOakForest(Elementsbyg instance) {
     super(instance, 179);
   }
 
   
   public void initElements() {
     this.elements.biomes.add(() -> new BiomeGenCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST });
     BiomeManager.addSpawnBiome(biome);
     BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 4));
   }
   
   static class BiomeGenCustom extends Biome {
     public BiomeGenCustom() {
       super((new Biome.BiomeProperties("Red Oak Forest")).setRainfall(0.6F).setBaseHeight(0.35F).setWaterColor(-12618012)
           .setHeightVariation(0.01F).setTemperature(0.7F));
       setRegistryName("bredoakforest");
       this.topBlock = Blocks.GRASS.getDefaultState();
       this.fillerBlock = Blocks.DIRT.getDefaultState();
       this.decorator.generateFalls = false;
       this.decorator.treesPerChunk = 6;
       this.decorator.flowersPerChunk = 2;
       this.decorator.grassPerChunk = 10;
       this.decorator.deadBushPerChunk = 0;
       this.decorator.mushroomsPerChunk = 0;
       this.decorator.bigMushroomsPerChunk = 0;
       this.decorator.reedsPerChunk = 0;
       this.decorator.cactiPerChunk = 0;
       this.decorator.sandPatchesPerChunk = 0;
       this.decorator.gravelPatchesPerChunk = 0;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getGrassColorAtPos(BlockPos pos) {
       return -8732583;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getFoliageColorAtPos(BlockPos pos) {
       return -8732583;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getSkyColorByTemp(float currentTemperature) {
       return -13395457;
     }
 
     
     public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
       return super.getRandomTreeFeature(rand);
     }
   }
 }




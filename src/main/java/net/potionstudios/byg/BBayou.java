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
 public class BBayou
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:bbayou")
   public static final BiomeGenCustom biome = null;
   
   public BBayou(Elementsbyg instance) {
     super(instance, 339);
   }
 
   
   public void initElements() {
     this.elements.biomes.add(() -> new BiomeGenCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.WET });
     BiomeManager.addSpawnBiome(biome);
     BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 4));
   }
   
   static class BiomeGenCustom extends Biome {
     public BiomeGenCustom() {
       super((new Biome.BiomeProperties("Bayou")).setRainfall(0.7F).setBaseHeight(-0.35F).setWaterColor(-10388636).setHeightVariation(0.0F)
           .setTemperature(0.8F));
       setRegistryName("bbayou");
       this.topBlock = Blocks.GRASS.getDefaultState();
       this.fillerBlock = Blocks.DIRT.getStateFromMeta(0);
       this.decorator.generateFalls = true;
       this.decorator.treesPerChunk = 0;
       this.decorator.flowersPerChunk = 4;
       this.decorator.grassPerChunk = 15;
       this.decorator.deadBushPerChunk = 0;
       this.decorator.mushroomsPerChunk = 2;
       this.decorator.bigMushroomsPerChunk = 0;
       this.decorator.reedsPerChunk = 35;
       this.decorator.cactiPerChunk = 0;
       this.decorator.sandPatchesPerChunk = 0;
       this.decorator.gravelPatchesPerChunk = 0;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getGrassColorAtPos(BlockPos pos) {
       return -11766212;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getFoliageColorAtPos(BlockPos pos) {
       return -11766212;
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




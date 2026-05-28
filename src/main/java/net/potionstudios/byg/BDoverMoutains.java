 package net.potionstudios.byg;
 
 import java.util.Random;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.gen.feature.WorldGenAbstractTree;
 import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
 import net.minecraftforge.common.BiomeDictionary;
 import net.minecraftforge.common.BiomeManager;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class BDoverMoutains
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:bdovermoutains")
   public static final BiomeGenCustom biome = null;
   
   public BDoverMoutains(Elementsbyg instance) {
     super(instance, 1247);
   }
 
   
   public void initElements() {
     this.elements.biomes.add(() -> new BiomeGenCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST });
     
     BiomeManager.addSpawnBiome(biome);
     BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 3));
   }
   
   static class BiomeGenCustom extends Biome {
     public BiomeGenCustom() {
       super((new Biome.BiomeProperties("Dover Mountains")).setRainfall(0.5F).setBaseHeight(2.0F).setWaterColor(-14329397).setHeightVariation(0.6F)
           .setTemperature(0.25F));
       setRegistryName("bdovermoutains");
       this.topBlock = Blocks.GRASS.getDefaultState();
       this.fillerBlock = Blocks.DIRT.getStateFromMeta(0);
       this.decorator.generateFalls = false;
       this.decorator.treesPerChunk = 8;
       this.decorator.flowersPerChunk = 1;
       this.decorator.grassPerChunk = 6;
       this.decorator.deadBushPerChunk = 0;
       this.decorator.mushroomsPerChunk = 0;
       this.decorator.bigMushroomsPerChunk = 0;
       this.decorator.reedsPerChunk = 0;
       this.decorator.cactiPerChunk = 0;
       this.decorator.sandPatchesPerChunk = 0;
       this.decorator.gravelPatchesPerChunk = 35;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getGrassColorAtPos(BlockPos pos) {
       return -13799876;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getFoliageColorAtPos(BlockPos pos) {
       return -13799876;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getSkyColorByTemp(float currentTemperature) {
       return -13395457;
     }
 
     
     public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
       return (WorldGenAbstractTree)new WorldGenMegaPineTree(false, true);
     }
   }
 }




 package net.potionstudios.byg;
 
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.init.Blocks;
 import net.minecraft.util.Mirror;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.Rotation;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.util.math.ChunkPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraft.world.WorldServer;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.gen.feature.WorldGenAbstractTree;
 import net.minecraft.world.gen.structure.template.PlacementSettings;
 import net.minecraft.world.gen.structure.template.Template;
 import net.minecraftforge.common.BiomeDictionary;
 import net.minecraftforge.common.BiomeManager;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class BEvergreenTaiga
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:bevergreentaiga")
   public static final BiomeGenCustom biome = null;
   
   public BEvergreenTaiga(Elementsbyg instance) {
     super(instance, 755);
   }
 
   
   public void initElements() {
     this.elements.biomes.add(() -> new BiomeGenCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     BiomeDictionary.addTypes(biome, new BiomeDictionary.Type[] { BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.CONIFEROUS });
     
     BiomeManager.addSpawnBiome(biome);
     BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 4));
   }
   
   static class BiomeGenCustom extends Biome {
     public BiomeGenCustom() {
       super((new Biome.BiomeProperties("Evergreen Taiga")).setRainfall(0.6F).setBaseHeight(0.75F).setWaterColor(-14329397)
           .setHeightVariation(0.1F).setTemperature(0.25F));
       setRegistryName("bevergreentaiga");
       this.topBlock = Blocks.GRASS.getDefaultState();
       this.fillerBlock = Blocks.DIRT.getDefaultState();
       this.decorator.generateFalls = false;
       this.decorator.treesPerChunk = 7;
       this.decorator.flowersPerChunk = 3;
       this.decorator.grassPerChunk = 10;
       this.decorator.deadBushPerChunk = 0;
       this.decorator.mushroomsPerChunk = 1;
       this.decorator.bigMushroomsPerChunk = 0;
       this.decorator.reedsPerChunk = 0;
       this.decorator.cactiPerChunk = 0;
       this.decorator.sandPatchesPerChunk = 0;
       this.decorator.gravelPatchesPerChunk = 45;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getGrassColorAtPos(BlockPos pos) {
       return -15244504;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getFoliageColorAtPos(BlockPos pos) {
       return -15244504;
     }
 
     
     @SideOnly(Side.CLIENT)
     public int getSkyColorByTemp(float currentTemperature) {
       return -13395457;
     }
 
     
     public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
       return new BEvergreenTaiga.CustomTree();
     }
   }
   
   static class CustomTree extends WorldGenAbstractTree {
     CustomTree() {
       super(false);
     }
 
     
     public boolean generate(World world, Random par2Random, BlockPos pos) {
       if (world.isRemote)
         return false; 
       Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "hollytree1"));
       
       if (template == null)
         return false; 
       Block ground = world.getBlockState(pos).getBlock();
       Block ground2 = world.getBlockState(pos.add(0, -1, 0)).getBlock();
       if (ground != Blocks.GRASS.getDefaultState().getBlock() && ground != Blocks.DIRT.getDefaultState().getBlock() && ground2 != Blocks.GRASS
         .getDefaultState().getBlock() && ground2 != Blocks.DIRT.getDefaultState().getBlock())
         return false; 
       Rotation rotation = Rotation.NONE;
       int rot = par2Random.nextInt(3);
       if (rot == 0) {
         rotation = Rotation.NONE;
       } else if (rot == 1) {
         rotation = Rotation.CLOCKWISE_90;
       } else if (rot == 2) {
         rotation = Rotation.CLOCKWISE_180;
       } else if (rot == 3) {
         rotation = Rotation.COUNTERCLOCKWISE_90;
       }  Mirror mirror = Mirror.NONE;
       int mir = par2Random.nextInt(2);
       if (mir == 0) {
         mirror = Mirror.NONE;
       } else if (mir == 1) {
         mirror = Mirror.LEFT_RIGHT;
       } else if (mir == 2) {
         mirror = Mirror.FRONT_BACK;
       }  BlockPos placeTo = pos.add(template.getSize().getX() / -2, 0, template.getSize().getZ() / -2);
       IBlockState iblockstate = world.getBlockState(placeTo);
       world.notifyBlockUpdate(placeTo, iblockstate, iblockstate, 3);
       template.addBlocksToWorldChunk(world, placeTo, (new PlacementSettings()).setRandom(par2Random).setRotation(rotation).setMirror(mirror)
           .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
       return true;
     }
 
     
     protected boolean canGrowInto(Block blockType) {
       Material material = blockType.getDefaultState().getMaterial();
       return (material == Material.AIR || blockType == Blocks.GRASS.getDefaultState().getBlock() || blockType == Blocks.DIRT
         .getDefaultState().getBlock());
     }
 
 
     
     protected void setDirtAt(World world, BlockPos pos) {}
 
     
     public boolean isReplaceable(World world, BlockPos pos) {
       IBlockState state = world.getBlockState(pos);
       return (state.getBlock().isAir(state, (IBlockAccess)world, pos) || canGrowInto(state.getBlock()) || state.getBlock().isReplaceable((IBlockAccess)world, pos));
     }
   }
 }




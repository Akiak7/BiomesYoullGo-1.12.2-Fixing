 package net.potionstudios.byg;
 
 import com.google.common.base.Predicate;
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.init.Blocks;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.NonNullList;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.chunk.IChunkProvider;
 import net.minecraft.world.gen.IChunkGenerator;
 import net.minecraft.world.gen.feature.WorldGenMinable;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.IPlantable;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Sandygrass
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:sandygrass")
   public static final Block block = null;
   
   public Sandygrass(Elementsbyg instance) {
     super(instance, 1069);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("grass", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:sandygrass", "inventory"));
   }
 
   
   public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
     boolean dimensionCriteria = false;
     if (dimID == 0)
       dimensionCriteria = true; 
     if (!dimensionCriteria)
       return; 
     boolean biomeCriteria = false;
     Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
     if (((ResourceLocation)Biome.REGISTRY.getNameForObject(biome)).equals(new ResourceLocation("byg:blushdesert")))
       biomeCriteria = true; 
     if (((ResourceLocation)Biome.REGISTRY.getNameForObject(biome)).equals(new ResourceLocation("byg:boutback")))
       biomeCriteria = true; 
     if (!biomeCriteria)
       return; 
     for (int i = 0; i < 32; i++) {
       int x = chunkX + random.nextInt(16);
       int y = random.nextInt(42) + 60;
       int z = chunkZ + random.nextInt(16);
       (new WorldGenMinable(block.getDefaultState(), 32, new Predicate<IBlockState>() {
             public boolean apply(IBlockState blockAt) {
               boolean blockCriteria = false;
               
               if (blockAt.getBlock() == Blocks.HARDENED_CLAY.getDefaultState().getBlock())
                 blockCriteria = true; 
               IBlockState require = Blocks.SAND.getStateFromMeta(0);
               try {
                 if (blockAt.getBlock() == require.getBlock() && blockAt
                   .getBlock().getMetaFromState(blockAt) == require.getBlock().getMetaFromState(require))
                   blockCriteria = true; 
               } catch (Exception e) {
                 if (blockAt.getBlock() == require.getBlock())
                   blockCriteria = true; 
               } 
               require = Blocks.SAND.getStateFromMeta(1);
               try {
                 if (blockAt.getBlock() == require.getBlock() && blockAt
                   .getBlock().getMetaFromState(blockAt) == require.getBlock().getMetaFromState(require))
                   blockCriteria = true; 
               } catch (Exception e) {
                 if (blockAt.getBlock() == require.getBlock())
                   blockCriteria = true; 
               } 
               if (blockAt.getBlock() == Hardeneddirt.block.getDefaultState().getBlock())
                 blockCriteria = true; 
               return blockCriteria;
             }
           })).generate(world, random, new BlockPos(x, y, z));
     } 
   }
   
   public static class BlockCustom extends Block {
     public BlockCustom() {
       super(Material.GRASS);
       setRegistryName("sandygrass");
       setUnlocalizedName("sandygrass");
       setSoundType(SoundType.PLANT);
       setHarvestLevel("axe", 1);
       setHardness(0.6F);
       setResistance(8.0F);
       setLightLevel(0.0F);
       setLightOpacity(255);
       setCreativeTab(BYGTab.tab);
     }
 
     
     public int tickRate(World world) {
       return 900;
     }
 
 
     
     public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
       return true;
     }
 
     
     public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
       drops.add(new ItemStack(Sandydirt.block, 1));
     }
   }
 }




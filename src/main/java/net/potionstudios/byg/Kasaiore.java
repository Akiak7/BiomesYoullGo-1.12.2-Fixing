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
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraft.world.chunk.IChunkProvider;
 import net.minecraft.world.gen.IChunkGenerator;
 import net.minecraft.world.gen.feature.WorldGenMinable;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Kasaiore
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:kasaiore")
   public static final Block block = null;
   
   public Kasaiore(Elementsbyg instance) {
     super(instance, 632);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("oreKasai", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:kasaiore", "inventory"));
   }
 
   
   public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
     boolean dimensionCriteria = false;
     if (dimID == -1)
       dimensionCriteria = true; 
     if (!dimensionCriteria)
       return; 
     for (int i = 0; i < 5; i++) {
       int x = chunkX + random.nextInt(16);
       int y = random.nextInt(6) + 106;
       int z = chunkZ + random.nextInt(16);
       (new WorldGenMinable(block.getDefaultState(), 6, new Predicate<IBlockState>() {
             public boolean apply(IBlockState blockAt) {
               boolean blockCriteria = false;
               
               if (blockAt.getBlock() == Blocks.NETHERRACK.getDefaultState().getBlock())
                 blockCriteria = true; 
               return blockCriteria;
             }
           })).generate(world, random, new BlockPos(x, y, z));
     } 
   }
   
   public static class BlockCustom extends Block {
     public BlockCustom() {
       super(Material.ROCK);
       setRegistryName("kasaiore");
       setUnlocalizedName("kasaiore");
       setSoundType(SoundType.STONE);
       setHarvestLevel("pickaxe", 5);
       setHardness(25.0F);
       setResistance(16.0F);
       setLightLevel(0.0F);
       setLightOpacity(255);
       setCreativeTab(BYGTab.tab);
     }
   }
 }




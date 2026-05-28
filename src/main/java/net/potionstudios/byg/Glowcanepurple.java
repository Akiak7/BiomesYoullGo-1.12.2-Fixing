 package net.potionstudios.byg;
 
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockReed;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.properties.IProperty;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.NonNullList;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.util.math.RayTraceResult;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraft.world.biome.Biome;
 import net.minecraft.world.chunk.IChunkProvider;
 import net.minecraft.world.gen.IChunkGenerator;
 import net.minecraft.world.gen.feature.WorldGenReed;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.EnumPlantType;
 import net.minecraftforge.common.IPlantable;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Glowcanepurple extends Elementsbyg.ModElement {
   @ObjectHolder("byg:glowcanepurple")
   public static final Block block = null;
   
   public Glowcanepurple(Elementsbyg instance) {
     super(instance, 886);
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("glowcane", block);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustomFlower());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:glowcanepurple", "inventory"));
   }
 
   
   public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
     boolean dimensionCriteria = false;
     if (dimID == 0)
       dimensionCriteria = true; 
     if (!dimensionCriteria)
       return; 
     boolean biomeCriteria = false;
     Biome biome = world.getBiome(new BlockPos(chunkX, 128, chunkZ));
     if (((ResourceLocation)Biome.REGISTRY.getNameForObject(biome)).equals(new ResourceLocation("byg:bglowshroombayou")))
       biomeCriteria = true; 
     if (!biomeCriteria)
       return; 
     for (int i = 0; i < 2; i++) {
       int l6 = chunkX + random.nextInt(16) + 8;
       int i11 = random.nextInt(128);
       int l14 = chunkZ + random.nextInt(16) + 8;
       (new WorldGenReed()
         {
           public boolean generate(World world, Random random, BlockPos pos) {
             for (int i = 0; i < 20; i++) {
               BlockPos blockpos1 = pos.add(random.nextInt(4) - random.nextInt(4), 0, random.nextInt(4) - random.nextInt(4));
               if (world.isAirBlock(blockpos1)) {
                 BlockPos blockpos2 = blockpos1.down();
                 int j = 1 + random.nextInt(random.nextInt(5) + 1);
                 j = Math.min(5, j);
                 for (int k = 0; k < j; k++) {
                   if (((BlockReed)Glowcanepurple.block).canBlockStay(world, blockpos1))
                     world.setBlockState(blockpos1.up(k), Glowcanepurple.block.getDefaultState(), 2); 
                 } 
               } 
             }  return true;
           }
         }).generate(world, random, new BlockPos(l6, i11, l14));
     } 
   }
   
   public static class BlockCustomFlower extends BlockReed {
     public BlockCustomFlower() {
       setSoundType(SoundType.PLANT);
       setCreativeTab(null);
       setHardness(0.01F);
       setResistance(2.0F);
       setLightLevel(0.6F);
       setUnlocalizedName("glowcanepurple");
       setRegistryName("glowcanepurple");
     }
 
     
     public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
       return new ItemStack(Item.getItemFromBlock((Block)this), 1, damageDropped(state));
     }
 
     
     public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
       return EnumPlantType.Cave;
     }
 
     
     public boolean canPlaceBlockAt(World world, BlockPos pos) {
       Block block2 = world.getBlockState(pos.down()).getBlock();
       return (block2.canSustainPlant(world.getBlockState(pos.down()), (IBlockAccess)world, pos.down(), EnumFacing.UP, (IPlantable)this) || block2 == Glowcanepurple.block);
     }
     
     @SideOnly(Side.CLIENT)
     public int colorMultiplier(IBlockAccess p_149720_1_, BlockPos pos, int pass) {
       return 16777215;
     }
 
     
     public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
       if ((world.getBlockState(pos.down()).getBlock() == Glowcanepurple.block || checkForDrop(world, pos, state)) && 
         world.isAirBlock(pos.up())) {
         int l;
         for (l = 1; world.getBlockState(pos.down(l)).getBlock() == this; l++);
         if (l < 5) {
           int i1 = ((Integer)state.getValue((IProperty)AGE)).intValue();
           if (i1 == 15) {
             world.setBlockState(pos.up(), getDefaultState());
             world.setBlockState(pos, state.withProperty((IProperty)AGE, Integer.valueOf(0)), 4);
           } else {
             world.setBlockState(pos, state.withProperty((IProperty)AGE, Integer.valueOf(i1 + 1)), 4);
           } 
         } 
       } 
     }
 
 
     
     public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
       drops.add(new ItemStack(Glowcanestalkpurple.block, 1));
     }
   }
 }




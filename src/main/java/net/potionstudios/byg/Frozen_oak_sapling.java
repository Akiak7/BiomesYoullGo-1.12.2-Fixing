 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockFlower;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.creativetab.CreativeTabs;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.EnumHand;
 import net.minecraft.util.NonNullList;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraft.world.chunk.IChunkProvider;
 import net.minecraft.world.gen.IChunkGenerator;
 import net.minecraft.world.gen.feature.WorldGenFlowers;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Frozen_oak_sapling
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:frozen_oak_sapling")
   public static final Block block = null;
   
   public Frozen_oak_sapling(Elementsbyg instance) {
     super(instance, 2387);
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("treeSapling", block);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustomFlower());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:frozen_oak_sapling", "inventory"));
   }
 
   
   public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
     boolean dimensionCriteria = false;
     if (dimID == 0)
       dimensionCriteria = true; 
     if (!dimensionCriteria)
       return; 
     for (int i = 0; i < 0; i++) {
       int l6 = chunkX + random.nextInt(16) + 8;
       int i11 = random.nextInt(128);
       int l14 = chunkZ + random.nextInt(16) + 8;
       (new WorldGenFlowers((BlockFlower)block, BlockFlower.EnumFlowerType.DANDELION)).generate(world, random, new BlockPos(l6, i11, l14));
     } 
   }
   
   public static class BlockCustomFlower extends BlockFlower {
     public BlockCustomFlower() {
       setSoundType(SoundType.PLANT);
       setCreativeTab(BYGTab.tab);
       setHardness(0.01F);
       setResistance(2.0F);
       setLightLevel(0.0F);
       setUnlocalizedName("frozen_oak_sapling");
       setRegistryName("frozen_oak_sapling");
     }
 
     
     public boolean isFlammable(IBlockAccess blockAccess, BlockPos pos, EnumFacing face) {
       return true;
     }
 
     
     public BlockFlower.EnumFlowerColor getBlockType() {
       return BlockFlower.EnumFlowerColor.YELLOW;
     }
 
     
     @SideOnly(Side.CLIENT)
     public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
       for (BlockFlower.EnumFlowerType blockflower$enumflowertype : BlockFlower.EnumFlowerType.getTypes(getBlockType())) {
         list.add(new ItemStack((Block)this, 1, blockflower$enumflowertype.getMeta()));
       }
     }
 
     
     public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       BlockCustomFlower blockCustomFlower = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       FrozenoaksaplingUpdateTick.executeProcedure($_dependencies);
     }
 
 
     
     public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       BlockCustomFlower blockCustomFlower = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("entity", entity);
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       FrozenoaksaplingPlantRightClicked.executeProcedure($_dependencies);
       
       return true;
     }
   }
 }




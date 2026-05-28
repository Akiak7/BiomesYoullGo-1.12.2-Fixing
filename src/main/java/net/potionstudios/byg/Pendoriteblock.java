 package net.potionstudios.byg;
 
 import net.minecraft.block.Block;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Pendoriteblock
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:pendoriteblock")
   public static final Block block = null;
   
   public Pendoriteblock(Elementsbyg instance) {
     super(instance, 603);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("blockPendorite", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:pendoriteblock", "inventory"));
   }
   
   public static class BlockCustom extends Block {
     public BlockCustom() {
       super(Material.IRON);
       setRegistryName("pendoriteblock");
       setUnlocalizedName("pendoriteblock");
       setSoundType(SoundType.METAL);
       setHarvestLevel("pickaxe", 4);
       setHardness(3.0F);
       setResistance(16.0F);
       setLightLevel(0.0F);
       setLightOpacity(255);
       setCreativeTab(BYGTab.tab);
     }
 
     
     public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
       return true;
     }
 
     
     public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
       return false;
     }
   }
 }




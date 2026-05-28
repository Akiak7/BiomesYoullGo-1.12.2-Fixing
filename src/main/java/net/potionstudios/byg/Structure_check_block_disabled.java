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
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Structure_check_block_disabled
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:structure_check_block_disabled")
   public static final Block block = null;
   
   public Structure_check_block_disabled(Elementsbyg instance) {
     super(instance, 1344);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:structure_check_block_disabled", "inventory"));
   }
   
   public static class BlockCustom
     extends Block {
     public BlockCustom() {
       super(Material.ROCK);
       setRegistryName("structure_check_block_disabled");
       setUnlocalizedName("structure_check_block_disabled");
       setSoundType(SoundType.STONE);
       setHarvestLevel("pickaxe", 1);
       setHardness(2.0F);
       setResistance(10.0F);
       setLightLevel(0.0F);
       setLightOpacity(255);
       setCreativeTab(null);
       setBlockUnbreakable();
     }
 
     
     public int tickRate(World world) {
       return 2;
     }
 
     
     public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
       return false;
     }
   }
 }




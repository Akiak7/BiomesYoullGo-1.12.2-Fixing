 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.EnumActionResult;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.EnumHand;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Witch_hazel_door
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:witch_hazel_door")
   public static final Item block = null;
   
   public Witch_hazel_door(Elementsbyg instance) {
     super(instance, 1812);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> new ItemCustom());
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:witch_hazel_door", "inventory"));
   }
   
   public static class ItemCustom extends Item {
     public ItemCustom() {
       setMaxDamage(0);
       this.maxStackSize = 64;
       setUnlocalizedName("witch_hazel_door");
       setRegistryName("witch_hazel_door");
       setCreativeTab(BYGTab.tab);
     }
 
     
     public int getItemEnchantability() {
       return 0;
     }
 
     
     public int getMaxItemUseDuration(ItemStack itemstack) {
       return 0;
     }
 
     
     public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
       return 1.0F;
     }
 
 
     
     public EnumActionResult onItemUseFirst(EntityPlayer entity, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
       ItemStack itemstack = entity.getHeldItem(hand);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("entity", entity);
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       WitchhazeldoorRightClickedOnBlock.executeProcedure($_dependencies);
       
       return EnumActionResult.PASS;
     }
   }
 }




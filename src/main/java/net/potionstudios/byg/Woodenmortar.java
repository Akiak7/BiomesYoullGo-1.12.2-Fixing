 package net.potionstudios.byg;
 
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
 public class Woodenmortar
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:woodenmortar")
   public static final Item block = null;
   
   public Woodenmortar(Elementsbyg instance) {
     super(instance, 2216);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> new ItemCustom());
   }
 
   
   public void init(FMLInitializationEvent event) {
     OreDictionary.registerOre("mortarWooden", block);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:woodenmortar", "inventory"));
   }
   
   public static class ItemCustom extends Item {
     public ItemCustom() {
       setMaxDamage(0);
       this.maxStackSize = 1;
       setUnlocalizedName("woodenmortar");
       setRegistryName("woodenmortar");
       setCreativeTab(BYGTab.tab);
       setContainerItem(this);
     }
 
     
     public int getItemEnchantability() {
       return 0;
     }
 
     
     public int getMaxItemUseDuration(ItemStack itemstack) {
       return 100;
     }
 
     
     public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
       return 1.0F;
     }
   }
 }




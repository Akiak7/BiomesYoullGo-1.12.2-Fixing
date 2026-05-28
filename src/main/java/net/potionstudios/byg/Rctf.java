 package net.potionstudios.byg;
 
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 
 @Elementsbyg.ModElement.Tag
 public class Rctf
   extends Elementsbyg.ModElement {
   public Rctf(Elementsbyg instance) {
     super(instance, 158);
   }
 
   
   public void init(FMLInitializationEvent event) {
     GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, 2), new ItemStack(Cookedtropicalfish.block, 1), 1.0F);
   }
 }




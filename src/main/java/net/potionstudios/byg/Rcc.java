 package net.potionstudios.byg;
 
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 
 @Elementsbyg.ModElement.Tag
 public class Rcc
   extends Elementsbyg.ModElement {
   public Rcc(Elementsbyg instance) {
     super(instance, 154);
   }
 
   
   public void init(FMLInitializationEvent event) {
     GameRegistry.addSmelting(new ItemStack(Items.CARROT, 1), new ItemStack(Cookedcarrot.block, 1), 1.0F);
   }
 }




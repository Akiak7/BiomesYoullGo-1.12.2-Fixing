 package net.potionstudios.byg;
 
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 
 @Elementsbyg.ModElement.Tag
 public class Rrrb
   extends Elementsbyg.ModElement {
   public Rrrb(Elementsbyg instance) {
     super(instance, 152);
   }
 
   
   public void init(FMLInitializationEvent event) {
     GameRegistry.addSmelting(new ItemStack(Rudobeans.block, 1), new ItemStack(Rudobeansroasted.block, 1), 1.0F);
   }
 }




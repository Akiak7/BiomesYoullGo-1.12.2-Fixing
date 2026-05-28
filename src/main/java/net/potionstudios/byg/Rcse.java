 package net.potionstudios.byg;
 
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 
 @Elementsbyg.ModElement.Tag
 public class Rcse
   extends Elementsbyg.ModElement {
   public Rcse(Elementsbyg instance) {
     super(instance, 156);
   }
 
   
   public void init(FMLInitializationEvent event) {
     GameRegistry.addSmelting(new ItemStack(Items.SPIDER_EYE, 1), new ItemStack(Cookedspidereye.block, 1), 1.0F);
   }
 }




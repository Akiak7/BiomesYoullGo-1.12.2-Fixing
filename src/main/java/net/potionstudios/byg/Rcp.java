 package net.potionstudios.byg;
 
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 
 @Elementsbyg.ModElement.Tag
 public class Rcp
   extends Elementsbyg.ModElement {
   public Rcp(Elementsbyg instance) {
     super(instance, 157);
   }
 
   
   public void init(FMLInitializationEvent event) {
     GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, 3), new ItemStack(Cookedpufferfish.block, 1), 1.0F);
   }
 }




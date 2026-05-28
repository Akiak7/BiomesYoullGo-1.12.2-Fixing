 package net.potionstudios.byg;
 
 import net.minecraft.block.Block;
 import net.minecraft.init.Blocks;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 
 @Elementsbyg.ModElement.Tag
 public class Rwhiteglass extends Elementsbyg.ModElement {
   public Rwhiteglass(Elementsbyg instance) {
     super(instance, 75);
   }
 
   
   public void init(FMLInitializationEvent event) {
     GameRegistry.addSmelting(new ItemStack(Whitesand.block, 1), new ItemStack((Block)Blocks.STAINED_GLASS, 1, 0), 1.0F);
   }
 }




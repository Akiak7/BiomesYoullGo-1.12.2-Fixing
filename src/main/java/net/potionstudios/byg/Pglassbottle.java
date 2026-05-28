 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.items.ItemHandlerHelper;
 
 @Elementsbyg.ModElement.Tag
 public class Pglassbottle
   extends Elementsbyg.ModElement
 {
   public Pglassbottle(Elementsbyg instance) {
     super(instance, 135);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure Pglassbottle!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     if (entity instanceof EntityPlayer)
       ItemHandlerHelper.giveItemToPlayer((EntityPlayer)entity, new ItemStack(Items.GLASS_BOTTLE, 1)); 
   }
 }




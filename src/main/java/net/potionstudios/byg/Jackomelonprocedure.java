 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Blocks;
 import net.minecraft.init.Items;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.SoundCategory;
 import net.minecraft.util.SoundEvent;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.event.entity.player.PlayerInteractEvent;
 import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
 import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 
 @Elementsbyg.ModElement.Tag
 public class Jackomelonprocedure extends Elementsbyg.ModElement {
   public Jackomelonprocedure(Elementsbyg instance) {
     super(instance, 1966);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure Jackomelonprocedure!");
       return;
     } 
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure Jackomelonprocedure!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure Jackomelonprocedure!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure Jackomelonprocedure!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure Jackomelonprocedure!");
       return;
     } 
     Entity entity = (Entity)dependencies.get("entity");
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     World world = (World)dependencies.get("world");
     if (((entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (new ItemStack((Item)Items.SHEARS, 1))
       .getItem() && (
       (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.MELON_BLOCK.getDefaultState().getBlock()) ? true : false) == true) {
       world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
           .getObject(new ResourceLocation("entity.sheep.shear")), SoundCategory.NEUTRAL, 1.0F, 1.0F);
       
       world.setBlockToAir(new BlockPos(x, y, z));
       world.setBlockState(new BlockPos(x, y, z), Carved_melon.block.getDefaultState(), 3);
     } 
   }
   
   @SubscribeEvent
   public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
     EntityPlayer entity = event.getEntityPlayer();
     int i = event.getPos().getX();
     int j = event.getPos().getY();
     int k = event.getPos().getZ();
     World world = event.getWorld();
     HashMap<String, Object> dependencies = new HashMap<>();
     dependencies.put("x", Integer.valueOf(i));
     dependencies.put("y", Integer.valueOf(j));
     dependencies.put("z", Integer.valueOf(k));
     dependencies.put("world", world);
     dependencies.put("entity", entity);
     dependencies.put("event", event);
     this.executeProcedure(dependencies);
   }
 
   
   public void preInit(FMLPreInitializationEvent event) {
     MinecraftForge.EVENT_BUS.register(this);
   }
 }




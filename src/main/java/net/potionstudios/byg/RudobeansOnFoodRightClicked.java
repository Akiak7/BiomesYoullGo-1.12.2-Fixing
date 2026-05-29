package net.potionstudios.byg;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Elementsbyg.ModElement.Tag
public class RudobeansOnFoodRightClicked
  extends Elementsbyg.ModElement
{
  public RudobeansOnFoodRightClicked(Elementsbyg instance) {
    super(instance, 858);
  }

  public static boolean executeProcedure(HashMap<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure RudobeansOnFoodRightClicked!");
      return false;
    }
    if (dependencies.get("hand") == null) {
      System.err.println("Failed to load dependency hand for procedure RudobeansOnFoodRightClicked!");
      return false;
    }
    if (dependencies.get("side") == null) {
      System.err.println("Failed to load dependency side for procedure RudobeansOnFoodRightClicked!");
      return false;
    }
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure RudobeansOnFoodRightClicked!");
      return false;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure RudobeansOnFoodRightClicked!");
      return false;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure RudobeansOnFoodRightClicked!");
      return false;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure RudobeansOnFoodRightClicked!");
      return false;
    }
    if (!(dependencies.get("entity") instanceof EntityPlayer))
      return false;

    EntityPlayer player = (EntityPlayer)dependencies.get("entity");
    EnumHand hand = (EnumHand)dependencies.get("hand");
    EnumFacing side = (EnumFacing)dependencies.get("side");
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    World world = (World)dependencies.get("world");
    return BYGPlantPlacementHelper.placeHeldItemRelative(world, new BlockPos(x, y, z), player, hand, side, Rudobeans.block, Blocks.FARMLAND, Rudostage0.block, EnumFacing.UP);
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
    dependencies.put("hand", event.getHand());
    dependencies.put("side", event.getFace());
    dependencies.put("event", event);
    if (executeProcedure(dependencies)) {
      event.setCanceled(true);
      event.setCancellationResult(EnumActionResult.SUCCESS);
    }
  }

  public void preInit(FMLPreInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(this);
  }
}

package net.potionstudios.byg;

import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Elementsbyg.ModElement.Tag
public class MediumpurpleglowshroomOnBlockRightClicked extends Elementsbyg.ModElement {
  public MediumpurpleglowshroomOnBlockRightClicked(Elementsbyg instance) {
    super(instance, 2412);
  }

  public static boolean executeProcedure(HashMap<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure MediumpurpleglowshroomOnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("hand") == null) {
      System.err.println("Failed to load dependency hand for procedure MediumpurpleglowshroomOnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure MediumpurpleglowshroomOnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure MediumpurpleglowshroomOnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure MediumpurpleglowshroomOnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure MediumpurpleglowshroomOnBlockRightClicked!");
      return false;
    }
    if (!(dependencies.get("entity") instanceof EntityPlayer))
      return false;

    EntityPlayer player = (EntityPlayer)dependencies.get("entity");
    EnumHand hand = (EnumHand)dependencies.get("hand");
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    World world = (World)dependencies.get("world");
    return BYGPlantPlacementHelper.growGlowshroom(world, new BlockPos(x, y, z), player, hand, Purpleglowshroomitem.block, Purple_glowshroom.block);
  }
}

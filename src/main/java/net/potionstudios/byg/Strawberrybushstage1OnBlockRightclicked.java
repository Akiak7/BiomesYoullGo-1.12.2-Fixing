 package net.potionstudios.byg;

import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

 @Elementsbyg.ModElement.Tag
 public class Strawberrybushstage1OnBlockRightclicked
   extends Elementsbyg.ModElement {
   public Strawberrybushstage1OnBlockRightclicked(Elementsbyg instance) {
     super(instance, 881);
   }

  public static boolean executeProcedure(HashMap<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure Strawberrybushstage1OnBlockRightclicked!");
      return false;
    }
    if (dependencies.get("hand") == null) {
      System.err.println("Failed to load dependency hand for procedure Strawberrybushstage1OnBlockRightclicked!");
      return false;
    }
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure Strawberrybushstage1OnBlockRightclicked!");
      return false;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure Strawberrybushstage1OnBlockRightclicked!");
      return false;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure Strawberrybushstage1OnBlockRightclicked!");
      return false;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure Strawberrybushstage1OnBlockRightclicked!");
      return false;
    }
    Entity entity = (Entity)dependencies.get("entity");
    EnumHand hand = (EnumHand)dependencies.get("hand");
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    World world = (World)dependencies.get("world");
    if (!(entity instanceof EntityPlayer))
      return false;
    return BYGBonemealGrowthHelper.growSimpleStage(world, new BlockPos(x, y, z), (EntityPlayer)entity, hand, Strawberrybush.block);
  }
}



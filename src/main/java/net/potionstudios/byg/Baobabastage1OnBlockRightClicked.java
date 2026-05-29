 package net.potionstudios.byg;

import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

 @Elementsbyg.ModElement.Tag
 public class Baobabastage1OnBlockRightClicked extends Elementsbyg.ModElement {
   public Baobabastage1OnBlockRightClicked(Elementsbyg instance) {
     super(instance, 981);
   }

  public static boolean executeProcedure(HashMap<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure Baobabastage1OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("hand") == null) {
      System.err.println("Failed to load dependency hand for procedure Baobabastage1OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure Baobabastage1OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure Baobabastage1OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure Baobabastage1OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure Baobabastage1OnBlockRightClicked!");
      return false;
    }
    Entity entity = (Entity)dependencies.get("entity");
    EnumHand hand = (EnumHand)dependencies.get("hand");
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    World world = (World)dependencies.get("world");
    if (!BYGBonemealGrowthHelper.isHeldBonemeal(entity, hand))
      return false;

    if (!world.isRemote) {
      BYGBonemealGrowthHelper.consumeHeldBonemeal(world, entity, hand);
      if (Math.random() < 0.4D) {
        BlockPos pos = new BlockPos(x, y, z);
        BYGBonemealGrowthHelper.spawnHappyParticles(world, pos);
        world.setBlockToAir(pos);
        world.setBlockState(pos, Baobabstage2.block.getDefaultState(), 3);
        world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
            .getObject(new ResourceLocation("block.chorus_flower.grow")), SoundCategory.NEUTRAL, 2.0F, 1.0F);
      }
    }

    return true;
  }
}



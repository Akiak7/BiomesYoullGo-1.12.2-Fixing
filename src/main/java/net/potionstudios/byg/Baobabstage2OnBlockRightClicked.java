 package net.potionstudios.byg;

import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

 @Elementsbyg.ModElement.Tag
 public class Baobabstage2OnBlockRightClicked extends Elementsbyg.ModElement {
   public Baobabstage2OnBlockRightClicked(Elementsbyg instance) {
     super(instance, 983);
   }

  public static boolean executeProcedure(HashMap<String, Object> dependencies) {
    if (dependencies.get("entity") == null) {
      System.err.println("Failed to load dependency entity for procedure Baobabstage2OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("hand") == null) {
      System.err.println("Failed to load dependency hand for procedure Baobabstage2OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("x") == null) {
      System.err.println("Failed to load dependency x for procedure Baobabstage2OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("y") == null) {
      System.err.println("Failed to load dependency y for procedure Baobabstage2OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("z") == null) {
      System.err.println("Failed to load dependency z for procedure Baobabstage2OnBlockRightClicked!");
      return false;
    }
    if (dependencies.get("world") == null) {
      System.err.println("Failed to load dependency world for procedure Baobabstage2OnBlockRightClicked!");
      return false;
    }
    Entity entity = (Entity)dependencies.get("entity");
    EnumHand hand = (EnumHand)dependencies.get("hand");
    int x = ((Integer)dependencies.get("x")).intValue();
    int y = ((Integer)dependencies.get("y")).intValue();
    int z = ((Integer)dependencies.get("z")).intValue();
    World world = (World)dependencies.get("world");
    BlockPos pos = new BlockPos(x, y, z);
    if (BYGBonemealGrowthHelper.isHeldBonemeal(entity, hand)) {
      if (!world.isRemote) {
        BYGBonemealGrowthHelper.consumeHeldBonemeal(world, entity, hand);
        if (Math.random() < 0.4D) {
          BYGBonemealGrowthHelper.spawnHappyParticles(world, pos);
          world.setBlockToAir(pos);
          world.setBlockState(pos, Baobabstage3.block.getDefaultState(), 3);
          world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
              .getObject(new ResourceLocation("block.chorus_flower.grow")), SoundCategory.NEUTRAL, 2.0F, 1.0F);
        }
      }
      return true;
    }

    if (BYGBonemealGrowthHelper.isOtherHandBonemeal(entity, hand))
      return false;

    if (!world.isRemote) {
      world.setBlockToAir(pos);
      world.setBlockState(pos, Baobabastage1.block.getDefaultState(), 3);
      EntityItem entityToSpawn = new EntityItem(world, x, y, z, new net.minecraft.item.ItemStack(Baobabfruit.block, 1));
      entityToSpawn.setPickupDelay(10);
      world.spawnEntity((Entity)entityToSpawn);
    }

    return true;
  }
}



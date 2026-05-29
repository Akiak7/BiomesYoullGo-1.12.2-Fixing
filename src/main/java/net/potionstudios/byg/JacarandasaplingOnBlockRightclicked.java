 package net.potionstudios.byg;

 import java.util.HashMap;
 import net.minecraft.block.Block;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
 import net.minecraft.util.EnumParticleTypes;
 import net.minecraft.util.Mirror;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.Rotation;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.util.math.ChunkPos;
 import net.minecraft.world.World;
 import net.minecraft.world.WorldServer;
 import net.minecraft.world.gen.structure.template.PlacementSettings;
 import net.minecraft.world.gen.structure.template.Template;

 @Elementsbyg.ModElement.Tag
 public class JacarandasaplingOnBlockRightclicked
   extends Elementsbyg.ModElement {
   public JacarandasaplingOnBlockRightclicked(Elementsbyg instance) {
     super(instance, 566);
   }

   public static boolean executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("entity") == null) {
       System.err.println("Failed to load dependency entity for procedure JacarandasaplingOnBlockRightclicked!");
       return false;
     }
     if (dependencies.get("hand") == null) {
      System.err.println("Failed to load dependency hand for procedure JacarandasaplingOnBlockRightclicked!");
      return false;
    }
    if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure JacarandasaplingOnBlockRightclicked!");
       return false;
     }
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure JacarandasaplingOnBlockRightclicked!");
       return false;
     }
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure JacarandasaplingOnBlockRightclicked!");
       return false;
     }
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure JacarandasaplingOnBlockRightclicked!");
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
     if (Math.random() < 0.4D && world.canSeeSky(new BlockPos(x, y, z)) && world
       .isDaytime() && ((world.getBiome(new BlockPos(x, y, z)).getTemperature(new BlockPos(x, y, z)) * 100.0F) >= 0.7D || (world
       .getBiome(new BlockPos(x, y, z)).getTemperature(new BlockPos(x, y, z)) * 100.0F) <= 0.89D)) {
       if (Math.random() < 0.5D) {
         BYGBonemealGrowthHelper.consumeHeldBonemeal(world, entity, hand);
         if (world.isRemote)
           return true;
         world.setBlockToAir(new BlockPos(x, y, z));
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "sapling_skyris1"));

         if (template == null)
          return true;
         BlockPos spawnTo = new BlockPos(x - 0, y, z - 0);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
       } else {

         BYGBonemealGrowthHelper.consumeHeldBonemeal(world, entity, hand);
         if (world.isRemote)
           return true;
         world.setBlockToAir(new BlockPos(x, y, z));
         Template template = ((WorldServer)world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(), new ResourceLocation("byg", "sapling_skyris2"));

         if (template == null)
          return true;
         BlockPos spawnTo = new BlockPos(x - 0, y, z - 0);
         IBlockState iblockstate = world.getBlockState(spawnTo);
         world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
         template.addBlocksToWorldChunk(world, spawnTo, (new PlacementSettings()).setRotation(Rotation.NONE).setMirror(Mirror.NONE)
             .setChunk((ChunkPos)null).setReplacedBlock((Block)null).setIgnoreStructureBlock(false).setIgnoreEntities(false));
       }

     } else {
       BYGBonemealGrowthHelper.consumeHeldBonemeal(world, entity, hand);
       BYGBonemealGrowthHelper.spawnHappyParticles(world, new BlockPos(x, y, z));
     }
    return true;
}
 }




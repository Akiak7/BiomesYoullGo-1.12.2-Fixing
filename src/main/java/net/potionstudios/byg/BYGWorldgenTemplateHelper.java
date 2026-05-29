package net.potionstudios.byg;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public final class BYGWorldgenTemplateHelper {
  private BYGWorldgenTemplateHelper() {}

  public static boolean placeIfAreaLoaded(World world, BlockPos origin, Template template, PlacementSettings settings) {
    if (!isTemplateAreaLoaded(world, origin, template, settings))
      return false;
    template.addBlocksToWorld(world, origin, settings);
    return true;
  }

  private static boolean isTemplateAreaLoaded(World world, BlockPos origin, Template template, PlacementSettings settings) {
    BlockPos size = template.getSize();
    if (size.getX() <= 0 || size.getY() <= 0 || size.getZ() <= 0)
      return true;
    StructureBoundingBox bounds = getTransformedBounds(origin, size, settings);
    return world.isAreaLoaded(bounds, false);
  }

  private static StructureBoundingBox getTransformedBounds(BlockPos origin, BlockPos size, PlacementSettings settings) {
    int maxX = size.getX() - 1;
    int maxY = size.getY() - 1;
    int maxZ = size.getZ() - 1;
    StructureBoundingBox bounds = null;
    for (int x : new int[] { 0, maxX }) {
      for (int y : new int[] { 0, maxY }) {
        for (int z : new int[] { 0, maxZ }) {
          BlockPos transformed = Template.transformedBlockPos(settings, new BlockPos(x, y, z)).add(origin);
          if (bounds == null) {
            bounds = new StructureBoundingBox(transformed, transformed);
          } else {
            bounds.expandTo(new StructureBoundingBox(transformed, transformed));
          }
        }
      }
    }
    return bounds;
  }
}

package net.potionstudios.byg;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import net.minecraftforge.fml.common.Loader;

public final class BYGRLFoliageCompat {
  private static final String MODID_RLFOLIAGE = "betterfoliage";
  private static final String GRASS_CLASS = "net.potionstudios.byg.BYGGrassBlock";
  private static final String GRASS_MODEL = "block/cube,up,down";

  private BYGRLFoliageCompat() {}

  public static void install() {
    if (!Loader.isModLoaded(MODID_RLFOLIAGE)) {
      return;
    }

    try {
      Class<?> configHandler = Class.forName("betterfoliage.config.ForgeConfigHandler");
      Object blockConfig = configHandler.getField("BLOCKS").get(null);
      appendString(blockConfig, "grassClassesWhitelist", GRASS_CLASS);
      appendString(blockConfig, "grassModels", GRASS_MODEL);
      Method refreshConfig = configHandler.getMethod("refreshConfig");
      refreshConfig.invoke(null);
    } catch (Throwable t) {
      System.err.println("[BYG] Failed to apply RLFoliage grass compatibility: " + t);
    }
  }

  private static void appendString(Object target, String fieldName, String value) throws IllegalAccessException, NoSuchFieldException {
    Field field = target.getClass().getField(fieldName);
    String[] values = (String[])field.get(target);
    if (contains(values, value)) {
      return;
    }

    String[] updated = values == null ? new String[] { value } : Arrays.copyOf(values, values.length + 1);
    updated[updated.length - 1] = value;
    field.set(target, updated);
  }

  private static boolean contains(String[] values, String value) {
    if (values == null) {
      return false;
    }

    for (String current : values) {
      if (value.equals(current)) {
        return true;
      }
    }
    return false;
  }
}

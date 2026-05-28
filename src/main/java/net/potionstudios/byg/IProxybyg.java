package net.potionstudios.byg;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public interface IProxybyg {
  void preInit(FMLPreInitializationEvent paramFMLPreInitializationEvent);
  
  void init(FMLInitializationEvent paramFMLInitializationEvent);
  
  void postInit(FMLPostInitializationEvent paramFMLPostInitializationEvent);
  
  void serverLoad(FMLServerStartingEvent paramFMLServerStartingEvent);
}




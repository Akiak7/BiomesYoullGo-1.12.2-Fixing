/*    */ package net.potionstudios.byg;
/*    */ 
/*    */ import net.minecraftforge.client.model.obj.OBJLoader;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*    */ 
/*    */ 
/*    */ public class ClientProxybyg
/*    */   implements IProxybyg
/*    */ {
/*    */   public void init(FMLInitializationEvent event) {}
/*    */   
/*    */   public void preInit(FMLPreInitializationEvent event) {
/* 16 */     OBJLoader.INSTANCE.addDomain("byg");
/*    */   }
/*    */   
/*    */   public void postInit(FMLPostInitializationEvent event) {}
/*    */   
/*    */   public void serverLoad(FMLServerStartingEvent event) {}
/*    */ }




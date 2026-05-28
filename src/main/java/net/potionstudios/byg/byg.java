/*     */ package net.potionstudios.byg;
/*     */ 
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraftforge.client.event.ModelRegistryEvent;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.RegistryEvent;
/*     */ import net.minecraftforge.fluids.FluidRegistry;
/*     */ import net.minecraftforge.fml.common.Mod;
/*     */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*     */ import net.minecraftforge.fml.common.Mod.Instance;
/*     */ import net.minecraftforge.fml.common.SidedProxy;
/*     */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*     */ import net.minecraftforge.fml.common.registry.EntityEntry;
/*     */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mod(modid = "byg", version = "1.8.0.1", acceptedMinecraftVersions = "[1.12.2]")
/*     */ public class byg
/*     */ {
/*     */   public static final String MODID = "byg";
/*     */   public static final String VERSION = "1.8.0.1";
/*  49 */   public static final SimpleNetworkWrapper PACKET_HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel("byg");
/*     */   @SidedProxy(clientSide = "net.potionstudios.byg.ClientProxybyg", serverSide = "net.potionstudios.byg.ServerProxybyg")
/*     */   public static IProxybyg proxy;
/*     */   @Instance("byg")
/*     */   public static byg instance;
/*  54 */   public Elementsbyg elements = new Elementsbyg();
/*     */   
/*     */   @EventHandler
/*     */   public void preInit(FMLPreInitializationEvent event) {
/*  58 */     MinecraftForge.EVENT_BUS.register(this);
/*  59 */     GameRegistry.registerWorldGenerator(this.elements, 5);
/*  60 */     GameRegistry.registerFuelHandler(this.elements);
/*  61 */     NetworkRegistry.INSTANCE.registerGuiHandler(this, new Elementsbyg.GuiHandler());
/*  62 */     this.elements.preInit(event);
/*  63 */     MinecraftForge.EVENT_BUS.register(this.elements);
/*  64 */     this.elements.getElements().forEach(element -> element.preInit(event));
/*  65 */     proxy.preInit(event);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void init(FMLInitializationEvent event) {
/*  70 */     this.elements.getElements().forEach(element -> element.init(event));
/*  71 */     proxy.init(event);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void postInit(FMLPostInitializationEvent event) {
/*  76 */     proxy.postInit(event);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void serverLoad(FMLServerStartingEvent event) {
/*  81 */     this.elements.getElements().forEach(element -> element.serverLoad(event));
/*  82 */     proxy.serverLoad(event);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void registerBlocks(RegistryEvent.Register<Block> event) {
/*  87 */     event.getRegistry().registerAll(elements.getBlocks().stream().map(Supplier::get).toArray(x$0 -> new Block[x$0]));
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void registerItems(RegistryEvent.Register<Item> event) {
/*  92 */     event.getRegistry().registerAll(elements.getItems().stream().map(Supplier::get).toArray(x$0 -> new Item[x$0]));
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void registerBiomes(RegistryEvent.Register<Biome> event) {
/*  97 */     event.getRegistry().registerAll(elements.getBiomes().stream().map(Supplier::get).toArray(x$0 -> new Biome[x$0]));
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
/* 102 */     event.getRegistry().registerAll(elements.getEntities().stream().map(Supplier::get).toArray(x$0 -> new EntityEntry[x$0]));
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void registerPotions(RegistryEvent.Register<Potion> event) {
/* 107 */     event.getRegistry().registerAll(elements.getPotions().stream().map(Supplier::get).toArray(x$0 -> new Potion[x$0]));
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
/* 112 */     this.elements.registerSounds(event);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerModels(ModelRegistryEvent event) {
/* 118 */     this.elements.getElements().forEach(element -> element.registerModels(event));
/*     */   }
/*     */   static {
/* 121 */     FluidRegistry.enableUniversalBucket();
/*     */   }
/*     */ }




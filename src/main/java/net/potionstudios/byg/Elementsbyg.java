/*     */ package net.potionstudios.byg;
/*     */ 
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.Biome;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.IChunkGenerator;
/*     */ import net.minecraft.world.storage.WorldSavedData;
/*     */ import net.minecraftforge.client.event.ModelRegistryEvent;
/*     */ import net.minecraftforge.event.RegistryEvent;
/*     */ import net.minecraftforge.fml.common.IFuelHandler;
/*     */ import net.minecraftforge.fml.common.IWorldGenerator;
/*     */ import net.minecraftforge.fml.common.discovery.ASMDataTable;
/*     */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.gameevent.PlayerEvent;
/*     */ import net.minecraftforge.fml.common.network.IGuiHandler;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import net.minecraftforge.fml.common.registry.EntityEntry;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Elementsbyg
/*     */   implements IFuelHandler, IWorldGenerator
/*     */ {
/*  46 */   protected final List<ModElement> elements = new ArrayList<>();
/*  47 */   protected final List<Supplier<Block>> blocks = new ArrayList<>();
/*  48 */   protected final List<Supplier<Item>> items = new ArrayList<>();
/*  49 */   protected final List<Supplier<Biome>> biomes = new ArrayList<>();
/*  50 */   protected final List<Supplier<EntityEntry>> entities = new ArrayList<>();
/*  51 */   protected final List<Supplier<Potion>> potions = new ArrayList<>();
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event) {
/*     */     try {
/*  55 */       for (ASMDataTable.ASMData asmData : event.getAsmData().getAll(ModElement.Tag.class.getName())) {
/*  56 */         Class<?> clazz = Class.forName(asmData.getClassName());
/*  57 */         if (clazz.getSuperclass() == ModElement.class)
/*  58 */           elements.add((Elementsbyg.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
/*     */       } 
/*  60 */     } catch (Exception e) {
/*  61 */       e.printStackTrace();
/*     */     } 
/*  63 */     Collections.sort(this.elements);
/*  64 */     this.elements.forEach(ModElement::initElements);
/*  65 */     addNetworkMessage((Class)bygVariables.WorldSavedDataSyncMessageHandler.class, bygVariables.WorldSavedDataSyncMessage.class, new Side[] { Side.SERVER, Side.CLIENT });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSounds(RegistryEvent.Register<SoundEvent> event) {}
/*     */ 
/*     */   
/*     */   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator cg, IChunkProvider cp) {
/*  74 */     this.elements.forEach(element -> element.generateWorld(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension(), cg, cp));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBurnTime(ItemStack fuel) {
/*  79 */     for (ModElement element : this.elements) {
/*  80 */       int ret = element.addFuel(fuel);
/*  81 */       if (ret != 0)
/*  82 */         return ret; 
/*     */     } 
/*  84 */     return 0;
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
/*  89 */     if (!event.player.world.isRemote) {
/*  90 */       WorldSavedData mapdata = bygVariables.MapVariables.get(event.player.world);
/*  91 */       WorldSavedData worlddata = bygVariables.WorldVariables.get(event.player.world);
/*  92 */       if (mapdata != null)
/*  93 */         byg.PACKET_HANDLER.sendTo(new bygVariables.WorldSavedDataSyncMessage(0, mapdata), (EntityPlayerMP)event.player); 
/*  94 */       if (worlddata != null)
/*  95 */         byg.PACKET_HANDLER.sendTo(new bygVariables.WorldSavedDataSyncMessage(1, worlddata), (EntityPlayerMP)event.player); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
/* 101 */     if (!event.player.world.isRemote) {
/* 102 */       WorldSavedData worlddata = bygVariables.WorldVariables.get(event.player.world);
/* 103 */       if (worlddata != null)
/* 104 */         byg.PACKET_HANDLER.sendTo(new bygVariables.WorldSavedDataSyncMessage(1, worlddata), (EntityPlayerMP)event.player); 
/*     */     } 
/*     */   }
/* 107 */   private int messageID = 0;
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Tag {}
/*     */   public <T extends net.minecraftforge.fml.common.network.simpleimpl.IMessage, V extends net.minecraftforge.fml.common.network.simpleimpl.IMessage> void addNetworkMessage(Class<? extends IMessageHandler<T, V>> handler, Class<T> messageClass, Side... sides) {
/* 111 */     for (Side side : sides)
/* 112 */       byg.PACKET_HANDLER.registerMessage(handler, messageClass, this.messageID, side); 
/* 113 */     this.messageID++;
/*     */   }
/*     */   
/*     */   public static class GuiHandler
/*     */     implements IGuiHandler {
/*     */     public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
/* 119 */       if (id == CrateGUI.GUIID)
/* 120 */         return new CrateGUI.GuiContainerMod(world, x, y, z, player); 
/* 121 */       if (id == NetherfurnaceGUI.GUIID)
/* 122 */         return new NetherfurnaceGUI.GuiContainerMod(world, x, y, z, player); 
/* 123 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
/* 128 */       if (id == CrateGUI.GUIID)
/* 129 */         return new CrateGUI.GuiWindow(world, x, y, z, player); 
/* 130 */       if (id == NetherfurnaceGUI.GUIID)
/* 131 */         return new NetherfurnaceGUI.GuiWindow(world, x, y, z, player); 
/* 132 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public List<ModElement> getElements() {
/* 137 */     return this.elements;
/*     */   }
/*     */   
/*     */   public List<Supplier<Block>> getBlocks() {
/* 141 */     return this.blocks;
/*     */   }
/*     */   
/*     */   public List<Supplier<Item>> getItems() {
/* 145 */     return this.items;
/*     */   }
/*     */   
/*     */   public List<Supplier<Biome>> getBiomes() {
/* 149 */     return this.biomes;
/*     */   }
/*     */   
/*     */   public List<Supplier<EntityEntry>> getEntities() {
/* 153 */     return this.entities;
/*     */   }
/*     */   
/*     */   public List<Supplier<Potion>> getPotions() {
/* 157 */     return this.potions;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ModElement
/*     */     implements Comparable<ModElement>
/*     */   {
/*     */     protected final Elementsbyg elements;
/*     */     protected final int sortid;
/*     */     
/*     */     public ModElement(Elementsbyg elements, int sortid) {
/* 168 */       this.elements = elements;
/* 169 */       this.sortid = sortid;
/*     */     }
/*     */ 
/*     */     
/*     */     public void initElements() {}
/*     */ 
/*     */     
/*     */     public void init(FMLInitializationEvent event) {}
/*     */ 
/*     */     
/*     */     public void preInit(FMLPreInitializationEvent event) {}
/*     */ 
/*     */     
/*     */     public void generateWorld(Random random, int posX, int posZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {}
/*     */ 
/*     */     
/*     */     public void serverLoad(FMLServerStartingEvent event) {}
/*     */ 
/*     */     
/*     */     public void registerModels(ModelRegistryEvent event) {}
/*     */     
/*     */     public int addFuel(ItemStack fuel) {
/* 191 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int compareTo(ModElement other) {
/* 196 */       return this.sortid - other.sortid;
/*     */     }
/*     */     
/*     */     @Retention(RetentionPolicy.RUNTIME)
/*     */     public static @interface Tag {}
/*     */   }
/*     */ }




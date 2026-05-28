/*     */ package net.potionstudios.byg;
/*     */ 
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.storage.WorldSavedData;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ 
/*     */ public class bygVariables {
/*  15 */   public static double OffX = 0.0D;
/*  16 */   public static double OffY = 0.0D;
/*  17 */   public static double OffZ = 0.0D;
/*     */   public static boolean Found = false;
/*     */   
/*     */   public static class MapVariables extends WorldSavedData {
/*     */     public static final String DATA_NAME = "byg_mapvars";
/*     */     
/*     */     public MapVariables() {
/*  24 */       super("byg_mapvars");
/*     */     }
/*     */     
/*     */     public MapVariables(String s) {
/*  28 */       super(s);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void readFromNBT(NBTTagCompound nbt) {}
/*     */ 
/*     */     
/*     */     public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
/*  37 */       return nbt;
/*     */     }
/*     */     
/*     */     public void syncData(World world) {
/*  41 */       markDirty();
/*  42 */       if (world.isRemote) {
/*  43 */         byg.PACKET_HANDLER.sendToServer(new bygVariables.WorldSavedDataSyncMessage(0, this));
/*     */       } else {
/*  45 */         byg.PACKET_HANDLER.sendToAll(new bygVariables.WorldSavedDataSyncMessage(0, this));
/*     */       } 
/*     */     }
/*     */     
/*     */     public static MapVariables get(World world) {
/*  50 */       MapVariables instance = (MapVariables)world.getMapStorage().getOrLoadData(MapVariables.class, "byg_mapvars");
/*  51 */       if (instance == null) {
/*  52 */         instance = new MapVariables();
/*  53 */         world.getMapStorage().setData("byg_mapvars", instance);
/*     */       } 
/*  55 */       return instance;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class WorldVariables extends WorldSavedData {
/*     */     public static final String DATA_NAME = "byg_worldvars";
/*     */     
/*     */     public WorldVariables() {
/*  63 */       super("byg_worldvars");
/*     */     }
/*     */     
/*     */     public WorldVariables(String s) {
/*  67 */       super(s);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void readFromNBT(NBTTagCompound nbt) {}
/*     */ 
/*     */     
/*     */     public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
/*  76 */       return nbt;
/*     */     }
/*     */     
/*     */     public void syncData(World world) {
/*  80 */       markDirty();
/*  81 */       if (world.isRemote) {
/*  82 */         byg.PACKET_HANDLER.sendToServer(new bygVariables.WorldSavedDataSyncMessage(1, this));
/*     */       } else {
/*  84 */         byg.PACKET_HANDLER.sendToDimension(new bygVariables.WorldSavedDataSyncMessage(1, this), world.provider.getDimension());
/*     */       } 
/*     */     }
/*     */     
/*     */     public static WorldVariables get(World world) {
/*  89 */       WorldVariables instance = (WorldVariables)world.getPerWorldStorage().getOrLoadData(WorldVariables.class, "byg_worldvars");
/*  90 */       if (instance == null) {
/*  91 */         instance = new WorldVariables();
/*  92 */         world.getPerWorldStorage().setData("byg_worldvars", instance);
/*     */       } 
/*  94 */       return instance;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class WorldSavedDataSyncMessageHandler
/*     */     implements IMessageHandler<WorldSavedDataSyncMessage, IMessage> {
/*     */     public IMessage onMessage(bygVariables.WorldSavedDataSyncMessage message, MessageContext context) {
/* 101 */       if (context.side == Side.SERVER) {
/* 102 */         (context.getServerHandler()).player.getServerWorld().addScheduledTask(() -> syncData(message, context, (context.getServerHandler()).player.world));
/*     */       } else {
/*     */         
/* 105 */         Minecraft.getMinecraft().addScheduledTask(() -> syncData(message, context, (Minecraft.getMinecraft()).player.world));
/* 106 */       }  return null;
/*     */     }
/*     */     
/*     */     private void syncData(bygVariables.WorldSavedDataSyncMessage message, MessageContext context, World world) {
/* 110 */       if (context.side == Side.SERVER)
/* 111 */         if (message.type == 0) {
/* 112 */           byg.PACKET_HANDLER.sendToAll(message);
/*     */         } else {
/* 114 */           byg.PACKET_HANDLER.sendToDimension(message, world.provider.getDimension());
/*     */         }  
/* 116 */       if (message.type == 0) {
/* 117 */         world.getMapStorage().setData("byg_mapvars", message.data);
/*     */       } else {
/* 119 */         world.getPerWorldStorage().setData("byg_worldvars", message.data);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class WorldSavedDataSyncMessage
/*     */     implements IMessage {
/*     */     public int type;
/*     */     public WorldSavedData data;
/*     */     
/*     */     public WorldSavedDataSyncMessage() {}
/*     */     
/*     */     public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
/* 132 */       this.type = type;
/* 133 */       this.data = data;
/*     */     }
/*     */ 
/*     */     
/*     */     public void toBytes(ByteBuf buf) {
/* 138 */       buf.writeInt(this.type);
/* 139 */       ByteBufUtils.writeTag(buf, this.data.writeToNBT(new NBTTagCompound()));
/*     */     }
/*     */ 
/*     */     
/*     */     public void fromBytes(ByteBuf buf) {
/* 144 */       this.type = buf.readInt();
/* 145 */       if (this.type == 0) {
/* 146 */         this.data = new bygVariables.MapVariables();
/*     */       } else {
/* 148 */         this.data = new bygVariables.WorldVariables();
/* 149 */       }  this.data.readFromNBT(ByteBufUtils.readTag(buf));
/*     */     }
/*     */   }
/*     */ }




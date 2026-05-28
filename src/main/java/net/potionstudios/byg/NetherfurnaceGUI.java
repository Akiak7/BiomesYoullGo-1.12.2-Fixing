 package net.potionstudios.byg;
 
 import io.netty.buffer.ByteBuf;
 import java.io.IOException;
 import java.util.HashMap;
 import net.minecraft.client.gui.GuiButton;
 import net.minecraft.client.gui.inventory.GuiContainer;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.player.EntityPlayerMP;
 import net.minecraft.inventory.Container;
 import net.minecraft.inventory.IInventory;
 import net.minecraft.inventory.InventoryBasic;
 import net.minecraft.inventory.Slot;
 import net.minecraft.item.ItemStack;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 import net.minecraftforge.fml.relauncher.Side;
 import org.lwjgl.input.Keyboard;
 import org.lwjgl.opengl.GL11;
 
 
 @Elementsbyg.ModElement.Tag
 public class NetherfurnaceGUI
   extends Elementsbyg.ModElement
 {
   public static int GUIID = 13;
   public static HashMap guiinventory = new HashMap<>();
   public static IInventory inherited;
   
   public NetherfurnaceGUI(Elementsbyg instance) {
     super(instance, 648);
   }
 
   
   public void preInit(FMLPreInitializationEvent event) {
     this.elements.addNetworkMessage((Class)GUIButtonPressedMessageHandler.class, GUIButtonPressedMessage.class, new Side[] { Side.SERVER });
     this.elements.addNetworkMessage((Class)GUISlotChangedMessageHandler.class, GUISlotChangedMessage.class, new Side[] { Side.SERVER });
   }
   public static class GuiContainerMod extends Container { World world;
     EntityPlayer entity;
     int x;
     int y;
     int z;
     
     public GuiContainerMod(World world, int x, int y, int z, EntityPlayer player) {
       this.world = world;
       this.entity = player;
       this.x = x;
       this.y = y;
       this.z = z;
       TileEntity ent = world.getTileEntity(new BlockPos(x, y, z));
       if (ent instanceof Netherfurnacelit.TileEntityCustom) {
         NetherfurnaceGUI.inherited = (IInventory)ent;
       } else {
         NetherfurnaceGUI.inherited = (IInventory)new InventoryBasic("", true, 9);
       }  addSlotToContainer(new Slot(NetherfurnaceGUI.inherited, 0, 56, 53) {  }
         );
       addSlotToContainer(new Slot(NetherfurnaceGUI.inherited, 1, 56, 17) {  }
         );
       addSlotToContainer(new Slot(NetherfurnaceGUI.inherited, 2, 116, 35)
           {
             public boolean isItemValid(ItemStack stack) {
               return false;
             }
           });
       
       int si;
       for (si = 0; si < 3; si++) {
         for (int sj = 0; sj < 9; sj++)
           addSlotToContainer(new Slot((IInventory)player.inventory, sj + (si + 1) * 9, 8 + sj * 18, 84 + si * 18)); 
       }  for (si = 0; si < 9; si++) {
         addSlotToContainer(new Slot((IInventory)player.inventory, si, 8 + si * 18, 142));
       }
     }
     
     public boolean canInteractWith(EntityPlayer player) {
       return true;
     }
 
     
     public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
       ItemStack itemstack = ItemStack.EMPTY;
       Slot slot = this.inventorySlots.get(index);
       if (slot != null && slot.getHasStack()) {
         ItemStack itemstack1 = slot.getStack();
         itemstack = itemstack1.copy();
         if (index < 3) {
           if (!mergeItemStack(itemstack1, 3, this.inventorySlots.size(), true)) {
             return ItemStack.EMPTY;
           }
           slot.onSlotChange(itemstack1, itemstack);
         } else if (!mergeItemStack(itemstack1, 0, 3, false)) {
           if (index < 30) {
             if (!mergeItemStack(itemstack1, 30, this.inventorySlots.size(), true)) {
               return ItemStack.EMPTY;
             }
           }
           else if (!mergeItemStack(itemstack1, 3, 30, false)) {
             return ItemStack.EMPTY;
           } 
           
           return ItemStack.EMPTY;
         } 
         if (itemstack1.getCount() == 0) {
           slot.putStack(ItemStack.EMPTY);
         } else {
           slot.onSlotChanged();
         } 
         if (itemstack1.getCount() == itemstack.getCount()) {
           return ItemStack.EMPTY;
         }
         slot.onTake(playerIn, itemstack1);
       } 
       return itemstack;
     }
 
     
     public boolean mergeItemStack(ItemStack itemstack, int from, int to, boolean reverse) {
       boolean mergeResult = false;
       int i = reverse ? (to - 1) : from;
       int order = reverse ? -1 : 1;
       if (itemstack.isStackable()) {
         while (((!reverse && i < to) || (reverse && i >= from)) && itemstack.getCount() > 0) {
           Slot slot = this.inventorySlots.get(i);
           ItemStack currstack = slot.getStack();
           if (!currstack.isEmpty()) {
             int maxsize = Math.min(slot.getSlotStackLimit(), itemstack.getMaxStackSize());
             int amount = Math.min(maxsize, itemstack.getCount());
             ItemStack reducedstack = itemstack.copy();
             reducedstack.setCount(amount);
             if (slot.isItemValid(reducedstack) && currstack.getItem().equals(itemstack.getItem()) && (
               !itemstack.getHasSubtypes() || itemstack.getItemDamage() == currstack.getItemDamage()) && 
               ItemStack.areItemStackTagsEqual(itemstack, currstack)) {
               int currsize = currstack.getCount() + itemstack.getCount();
               if (currsize <= maxsize) {
                 itemstack.setCount(0);
                 currstack.setCount(currsize);
                 slot.putStack(currstack);
                 mergeResult = true;
               } else if (currstack.getCount() < maxsize) {
                 itemstack.shrink(maxsize - currstack.getCount());
                 currstack.setCount(maxsize);
                 slot.putStack(currstack);
                 mergeResult = true;
               } 
             } 
           } 
           i += order;
         } 
       }
       if (itemstack.getCount() > 0) {
         i = reverse ? (to - 1) : from;
         while (((!reverse && i < to) || (reverse && i >= from)) && itemstack.getCount() > 0) {
           Slot slot = this.inventorySlots.get(i);
           ItemStack currstack = slot.getStack();
           if (currstack.isEmpty()) {
             int maxsize = Math.min(slot.getSlotStackLimit(), itemstack.getMaxStackSize());
             int amount = Math.min(maxsize, itemstack.getCount());
             ItemStack reducedstack = itemstack.copy();
             reducedstack.setCount(amount);
             if (slot.isItemValid(reducedstack)) {
               currstack = itemstack.splitStack(amount);
               slot.putStack(currstack);
               mergeResult = true;
             } 
           } 
           i += order;
         } 
       } 
       return mergeResult;
     }
 
     
     public void onContainerClosed(EntityPlayer playerIn) {
       super.onContainerClosed(playerIn);
     }
     
     private void slotChanged(int slotid, int ctype, int meta) {
       byg.PACKET_HANDLER.sendToServer(new NetherfurnaceGUI.GUISlotChangedMessage(slotid, this.x, this.y, this.z, ctype, meta));
     } }
   
   public static class GuiWindow extends GuiContainer { World world;
     int x;
     int y;
     int z;
     EntityPlayer entity;
     
     public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
       super(new NetherfurnaceGUI.GuiContainerMod(world, x, y, z, entity));
       this.world = world;
       this.x = x;
       this.y = y;
       this.z = z;
       this.entity = entity;
       this.xSize = 176;
       this.ySize = 166;
     }
     private static final ResourceLocation texture = new ResourceLocation("byg:textures/netherfurnacegui.png");
 
     
     public void drawScreen(int mouseX, int mouseY, float partialTicks) {
       drawDefaultBackground();
       super.drawScreen(mouseX, mouseY, partialTicks);
       renderHoveredToolTip(mouseX, mouseY);
     }
 
     
     protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
       this.mc.renderEngine.bindTexture(texture);
       int k = (this.width - this.xSize) / 2;
       int l = (this.height - this.ySize) / 2;
       drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
       this.zLevel = 100.0F;
       this.mc.renderEngine.bindTexture(new ResourceLocation("byg:textures/nether_furnacegui1.png"));
       drawTexturedModalRect(this.guiLeft + 0, this.guiTop + 0, 0, 0, 256, 256);
     }
 
     
     public void updateScreen() {
       super.updateScreen();
     }
 
     
     protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
       super.mouseClicked(mouseX, mouseY, mouseButton);
     }
 
     
     protected void keyTyped(char typedChar, int keyCode) throws IOException {
       super.keyTyped(typedChar, keyCode);
     }
 
 
     
     protected void drawGuiContainerForegroundLayer(int par1, int par2) {}
 
     
     public void onGuiClosed() {
       super.onGuiClosed();
       Keyboard.enableRepeatEvents(false);
     }
 
     
     public void initGui() {
       super.initGui();
       this.guiLeft = (this.width - 176) / 2;
       this.guiTop = (this.height - 166) / 2;
       Keyboard.enableRepeatEvents(true);
       this.buttonList.clear();
       this.buttonList.add(new GuiButton(0, this.guiLeft + 79, this.guiTop + 56, 0, 20, ""));
     }
 
     
     protected void actionPerformed(GuiButton button) {
       byg.PACKET_HANDLER.sendToServer(new NetherfurnaceGUI.GUIButtonPressedMessage(button.id, this.x, this.y, this.z));
     }
 
     
     public boolean doesGuiPauseGame() {
       return false;
     } }
 
   
   public static class GUIButtonPressedMessageHandler
     implements IMessageHandler<GUIButtonPressedMessage, IMessage> {
     public IMessage onMessage(NetherfurnaceGUI.GUIButtonPressedMessage message, MessageContext context) {
       EntityPlayerMP entity = (context.getServerHandler()).player;
       entity.getServerWorld().addScheduledTask(() -> {
             int buttonID = message.buttonID;
             
             int x = message.x;
             
             int y = message.y;
             
             int z = message.z;
             World world = entity.world;
             if (!world.isBlockLoaded(new BlockPos(x, y, z))) {
               return;
             }
             if (buttonID == 0) {
               HashMap<String, Object> $_dependencies = new HashMap<>();
               $_dependencies.put("x", Integer.valueOf(x));
               $_dependencies.put("y", Integer.valueOf(y));
               $_dependencies.put("z", Integer.valueOf(z));
               $_dependencies.put("world", world);
               NetherfurnacelitOnBlockRightclicked.executeProcedure($_dependencies);
             } 
           });
       return null;
     }
   }
   
   public static class GUISlotChangedMessageHandler
     implements IMessageHandler<GUISlotChangedMessage, IMessage> {
     public IMessage onMessage(NetherfurnaceGUI.GUISlotChangedMessage message, MessageContext context) {
       EntityPlayerMP entity = (context.getServerHandler()).player;
       entity.getServerWorld().addScheduledTask(() -> {
             int slotID = message.slotID;
             int changeType = message.changeType;
             int meta = message.meta;
             int x = message.x;
             int y = message.y;
             int z = message.z;
             World world = entity.world;
             if (!world.isBlockLoaded(new BlockPos(x, y, z))) {
               return;
             }
           });
       return null;
     } }
   
   public static class GUIButtonPressedMessage implements IMessage { int buttonID;
     int x;
     int y;
     int z;
     
     public GUIButtonPressedMessage() {}
     
     public GUIButtonPressedMessage(int buttonID, int x, int y, int z) {
       this.buttonID = buttonID;
       this.x = x;
       this.y = y;
       this.z = z;
     }
 
     
     public void toBytes(ByteBuf buf) {
       buf.writeInt(this.buttonID);
       buf.writeInt(this.x);
       buf.writeInt(this.y);
       buf.writeInt(this.z);
     }
 
     
     public void fromBytes(ByteBuf buf) {
       this.buttonID = buf.readInt();
       this.x = buf.readInt();
       this.y = buf.readInt();
       this.z = buf.readInt();
     } }
 
   
   public static class GUISlotChangedMessage
     implements IMessage {
     int slotID;
     int x;
     int y;
     
     public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
       this.slotID = slotID;
       this.x = x;
       this.y = y;
       this.z = z;
       this.changeType = changeType;
       this.meta = meta;
     }
     int z; int changeType; int meta;
     public GUISlotChangedMessage() {}
     public void toBytes(ByteBuf buf) {
       buf.writeInt(this.slotID);
       buf.writeInt(this.x);
       buf.writeInt(this.y);
       buf.writeInt(this.z);
       buf.writeInt(this.changeType);
       buf.writeInt(this.meta);
     }
 
     
     public void fromBytes(ByteBuf buf) {
       this.slotID = buf.readInt();
       this.x = buf.readInt();
       this.y = buf.readInt();
       this.z = buf.readInt();
       this.changeType = buf.readInt();
       this.meta = buf.readInt();
     }
   }
 }




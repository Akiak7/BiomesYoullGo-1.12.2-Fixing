 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Blocks;
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.tileentity.TileEntityLockableLoot;
 import net.minecraft.util.EnumParticleTypes;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.SoundCategory;
 import net.minecraft.util.SoundEvent;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraft.world.WorldServer;
 
 @Elementsbyg.ModElement.Tag
 public class NetherfurnacelitUpdateTick extends Elementsbyg.ModElement {
   public NetherfurnacelitUpdateTick(Elementsbyg instance) {
     super(instance, 646);
   }
   
   public static void executeProcedure(HashMap<String, Object> dependencies) {
     if (dependencies.get("x") == null) {
       System.err.println("Failed to load dependency x for procedure NetherfurnacelitUpdateTick!");
       return;
     } 
     if (dependencies.get("y") == null) {
       System.err.println("Failed to load dependency y for procedure NetherfurnacelitUpdateTick!");
       return;
     } 
     if (dependencies.get("z") == null) {
       System.err.println("Failed to load dependency z for procedure NetherfurnacelitUpdateTick!");
       return;
     } 
     if (dependencies.get("world") == null) {
       System.err.println("Failed to load dependency world for procedure NetherfurnacelitUpdateTick!");
       return;
     } 
     int x = ((Integer)dependencies.get("x")).intValue();
     int y = ((Integer)dependencies.get("y")).intValue();
     int z = ((Integer)dependencies.get("z")).intValue();
     final World world = (World)dependencies.get("world");
     if ((new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 1).getItem() == (new ItemStack(Kasaiore.block, 1)).getItem() && (new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 1).getMetadata() == (new ItemStack(Kasaiore.block, 1))
       .getMetadata() && (new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 0).getItem() == (new ItemStack(Items.BLAZE_POWDER, 1)).getItem() && (new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 0).getMetadata() == (new ItemStack(Items.BLAZE_POWDER, 1))
       .getMetadata() && ((new Object() {
         public int getAmount(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot) {
             ItemStack stack = ((TileEntityLockableLoot)inv).getStackInSlot(sltid);
             if (stack != null)
               return stack.getCount(); 
           } 
           return 0;
         }
       }).getAmount(new BlockPos(x, y, z), 2) == 0 || ((new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 2).getItem() == (new ItemStack(Kasaiingot.block, 1)).getItem() && (new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 2).getMetadata() == (new ItemStack(Kasaiingot.block, 1))
       .getMetadata()))) {
       
       TileEntity inv = world.getTileEntity(new BlockPos(x, y, z));
       if (inv instanceof TileEntityLockableLoot) {
         ((TileEntityLockableLoot)inv).decrStackSize(0, 1);
       }
       
       inv = world.getTileEntity(new BlockPos(x, y, z));
       if (inv instanceof TileEntityLockableLoot) {
         ((TileEntityLockableLoot)inv).decrStackSize(1, 1);
       }
       
       inv = world.getTileEntity(new BlockPos(x, y, z));
       if (inv != null && inv instanceof TileEntityLockableLoot) {
         ((TileEntityLockableLoot)inv).setInventorySlotContents(2, new ItemStack(Kasaiingot.block, (new Object() {
                 public int getAmount(BlockPos pos, int sltid) {
                   TileEntity inv = world.getTileEntity(pos);
                   if (inv instanceof TileEntityLockableLoot) {
                     ItemStack stack = ((TileEntityLockableLoot)inv).getStackInSlot(sltid);
                     if (stack != null)
                       return stack.getCount(); 
                   } 
                   return 0;
                 }
               }).getAmount(new BlockPos(x, y, z), 2) + 1));
       }
     } 
     if ((new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 1).getItem() == (new ItemStack(Blocks.OBSIDIAN, 1)).getItem() && (new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 1).getMetadata() == (new ItemStack(Blocks.OBSIDIAN, 1)).getMetadata() && (new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 0).getItem() == (new ItemStack(Items.BLAZE_POWDER, 1)).getItem() && (new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 0).getMetadata() == (new ItemStack(Items.BLAZE_POWDER, 1))
       .getMetadata() && ((new Object() {
         public int getAmount(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot) {
             ItemStack stack = ((TileEntityLockableLoot)inv).getStackInSlot(sltid);
             if (stack != null)
               return stack.getCount(); 
           } 
           return 0;
         }
       }).getAmount(new BlockPos(x, y, z), 2) == 0 || ((new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 2).getItem() == (new ItemStack(Obsidianingot.block, 1))
       .getItem() && (new Object() {
         public ItemStack getItemStack(BlockPos pos, int sltid) {
           TileEntity inv = world.getTileEntity(pos);
           if (inv instanceof TileEntityLockableLoot)
             return ((TileEntityLockableLoot)inv).getStackInSlot(sltid); 
           return ItemStack.EMPTY;
         }
       }).getItemStack(new BlockPos(x, y, z), 2).getMetadata() == (new ItemStack(Obsidianingot.block, 1))
       .getMetadata()))) {
       
       TileEntity inv = world.getTileEntity(new BlockPos(x, y, z));
       if (inv instanceof TileEntityLockableLoot) {
         ((TileEntityLockableLoot)inv).decrStackSize(0, 1);
       }
       
       inv = world.getTileEntity(new BlockPos(x, y, z));
       if (inv instanceof TileEntityLockableLoot) {
         ((TileEntityLockableLoot)inv).decrStackSize(1, 1);
       }
       
       inv = world.getTileEntity(new BlockPos(x, y, z));
       if (inv != null && inv instanceof TileEntityLockableLoot) {
         ((TileEntityLockableLoot)inv).setInventorySlotContents(2, new ItemStack(Obsidianingot.block, (new Object()
               {
                 public int getAmount(BlockPos pos, int sltid) {
                   TileEntity inv = world.getTileEntity(pos);
                   if (inv instanceof TileEntityLockableLoot) {
                     ItemStack stack = ((TileEntityLockableLoot)inv).getStackInSlot(sltid);
                     if (stack != null)
                       return stack.getCount(); 
                   } 
                   return 0;
                 }
               }).getAmount(new BlockPos(x, y, z), 2) + 1));
       }
     } 
     if (!((world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.FIRE.getDefaultState().getBlock()) ? true : false)) {
       world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
           .getObject(new ResourceLocation("block.fire.extinguish")), SoundCategory.NEUTRAL, 3.0F, 1.0F);
       
       world.setBlockToAir(new BlockPos(x, y, z));
       world.setBlockState(new BlockPos(x, y, z), Netherfurnace.block.getDefaultState(), 3);
     } 
     if (Math.random() < 0.01D) {
       if (world instanceof WorldServer)
         ((WorldServer)world).spawnParticle(EnumParticleTypes.DRAGON_BREATH, x, y, z, 5, 1.0D, 5.0D, 1.0D, 1.0D, new int[0]); 
       world.playSound((EntityPlayer)null, x, y, z, (SoundEvent)SoundEvent.REGISTRY
           .getObject(new ResourceLocation("block.furnace.fire_crackle")), SoundCategory.NEUTRAL, 3.0F, 1.0F);
     } 
   }
 }




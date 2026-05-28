 package net.potionstudios.byg;
 import java.util.HashMap;
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockHorizontal;
 import net.minecraft.block.ITileEntityProvider;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.properties.IProperty;
 import net.minecraft.block.properties.PropertyDirection;
 import net.minecraft.block.state.BlockStateContainer;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.player.InventoryPlayer;
 import net.minecraft.inventory.Container;
 import net.minecraft.inventory.ContainerChest;
 import net.minecraft.inventory.IInventory;
 import net.minecraft.inventory.InventoryHelper;
 import net.minecraft.inventory.ItemStackHelper;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.item.ItemStack;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.tileentity.TileEntityLockableLoot;
 import net.minecraft.util.EnumBlockRenderType;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.EnumHand;
 import net.minecraft.util.NonNullList;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.IBlockAccess;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Netherfurnacelit extends Elementsbyg.ModElement {
   @ObjectHolder("byg:netherfurnacelit")
   public static final Block block = null;
   
   public Netherfurnacelit(Elementsbyg instance) {
     super(instance, 644);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> new BlockCustom());
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName(block.getRegistryName()));
   }
 
   
   public void init(FMLInitializationEvent event) {
     GameRegistry.registerTileEntity(TileEntityCustom.class, "byg:tileentitynetherfurnacelit");
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("byg:netherfurnacelit", "inventory"));
   }
   
   public static class BlockCustom extends Block implements ITileEntityProvider {
     public static final PropertyDirection FACING = BlockHorizontal.FACING;
     
     public BlockCustom() {
       super(Material.ROCK);
       setRegistryName("netherfurnacelit");
       setUnlocalizedName("netherfurnacelit");
       setSoundType(SoundType.STONE);
       setHarvestLevel("pickaxe", 1);
       setHardness(5.0F);
       setResistance(14.0F);
       setLightLevel(0.8F);
       setLightOpacity(2);
       setCreativeTab(null);
       setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH));
     }
 
     
     protected BlockStateContainer createBlockState() {
       return new BlockStateContainer(this, new IProperty[] { (IProperty)FACING });
     }
 
     
     public IBlockState getStateFromMeta(int meta) {
       return getDefaultState().withProperty((IProperty)FACING, (Comparable)EnumFacing.getFront(meta));
     }
 
     
     public int getMetaFromState(IBlockState state) {
       return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
     }
 
 
     
     public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
       if (facing == EnumFacing.UP || facing == EnumFacing.DOWN)
         return getDefaultState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH); 
       return getDefaultState().withProperty((IProperty)FACING, (Comparable)facing);
     }
 
     
     public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
       return false;
     }
 
     
     public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
       drops.add(new ItemStack(Netherfurnace.block, 1));
     }
 
     
     public TileEntity createNewTileEntity(World worldIn, int meta) {
       return (TileEntity)new Netherfurnacelit.TileEntityCustom();
     }
 
     
     public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int eventID, int eventParam) {
       super.eventReceived(state, worldIn, pos, eventID, eventParam);
       TileEntity tileentity = worldIn.getTileEntity(pos);
       return (tileentity == null) ? false : tileentity.receiveClientEvent(eventID, eventParam);
     }
 
     
     public EnumBlockRenderType getRenderType(IBlockState state) {
       return EnumBlockRenderType.MODEL;
     }
 
     
     public void breakBlock(World world, BlockPos pos, IBlockState state) {
       TileEntity tileentity = world.getTileEntity(pos);
       InventoryHelper.dropInventoryItems(world, pos, (IInventory)tileentity);
       world.removeTileEntity(pos);
       super.breakBlock(world, pos, state);
     }
 
     
     public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
       super.onBlockAdded(world, pos, state);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       world.scheduleUpdate(new BlockPos(x, y, z), this, tickRate(world));
     }
 
     
     public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
       super.updateTick(world, pos, state, random);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       NetherfurnacelitUpdateTick.executeProcedure($_dependencies);
       
       world.scheduleUpdate(new BlockPos(x, y, z), this, tickRate(world));
     }
 
 
     
     public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
       super.onBlockActivated(world, pos, state, entity, hand, side, hitX, hitY, hitZ);
       int x = pos.getX();
       int y = pos.getY();
       int z = pos.getZ();
       Block block = this;
       
       HashMap<String, Object> $_dependencies = new HashMap<>();
       $_dependencies.put("entity", entity);
       $_dependencies.put("x", Integer.valueOf(x));
       $_dependencies.put("y", Integer.valueOf(y));
       $_dependencies.put("z", Integer.valueOf(z));
       $_dependencies.put("world", world);
       NetherfurnaceGUIprocedure.executeProcedure($_dependencies);
       
       return true;
     }
   }
   
   public static class TileEntityCustom extends TileEntityLockableLoot {
     private NonNullList<ItemStack> stacks = NonNullList.withSize(3, ItemStack.EMPTY);
 
     
     public int getSizeInventory() {
       return 3;
     }
 
     
     public boolean isEmpty() {
       for (ItemStack itemstack : this.stacks) {
         if (!itemstack.isEmpty())
           return false; 
       }  return true;
     }
 
     
     public boolean isItemValidForSlot(int index, ItemStack stack) {
       return true;
     }
 
     
     public ItemStack getStackInSlot(int slot) {
       return (ItemStack)this.stacks.get(slot);
     }
 
     
     public String getName() {
       return hasCustomName() ? this.customName : "container.netherfurnacelit";
     }
 
     
     public void readFromNBT(NBTTagCompound compound) {
       super.readFromNBT(compound);
       this.stacks = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
       if (!checkLootAndRead(compound))
         ItemStackHelper.loadAllItems(compound, this.stacks); 
       if (compound.hasKey("CustomName", 8)) {
         this.customName = compound.getString("CustomName");
       }
     }
     
     public NBTTagCompound writeToNBT(NBTTagCompound compound) {
       super.writeToNBT(compound);
       if (!checkLootAndWrite(compound))
         ItemStackHelper.saveAllItems(compound, this.stacks); 
       if (hasCustomName())
         compound.setString("CustomName", this.customName); 
       return compound;
     }
 
     
     public int getInventoryStackLimit() {
       return 64;
     }
 
     
     public String getGuiID() {
       return "byg:netherfurnacelit";
     }
 
     
     public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
       fillWithLoot(playerIn);
       return (Container)new ContainerChest((IInventory)playerInventory, (IInventory)this, playerIn);
     }
 
     
     protected NonNullList<ItemStack> getItems() {
       return this.stacks;
     }
   }
 }




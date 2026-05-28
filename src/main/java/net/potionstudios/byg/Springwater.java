 package net.potionstudios.byg;
 
 import java.util.HashMap;
 import java.util.Random;
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.ItemMeshDefinition;
 import net.minecraft.client.renderer.block.model.ModelBakery;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.client.renderer.block.statemap.IStateMapper;
 import net.minecraft.client.renderer.block.statemap.StateMapperBase;
 import net.minecraft.entity.Entity;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fluids.BlockFluidClassic;
 import net.minecraftforge.fluids.Fluid;
 import net.minecraftforge.fluids.FluidRegistry;
 import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 @Elementsbyg.ModElement.Tag
 public class Springwater
   extends Elementsbyg.ModElement {
   @ObjectHolder("byg:springwater")
   public static final Block block = null;
   @ObjectHolder("byg:springwater")
   public static final Item item = null;
   private Fluid fluid;
   
   public Springwater(Elementsbyg instance) {
     super(instance, 2307);
     this
       .fluid = (new Fluid("springwater", new ResourceLocation("byg:blocks/spring_water_flowing"), new ResourceLocation("byg:blocks/spring_water_stills"))).setLuminosity(10).setDensity(1000).setViscosity(1000).setGaseous(false);
   }
 
   
   public void initElements() {
     this.elements.blocks.add(() -> (Block)(new BlockFluidClassic(this.fluid, Material.WATER)
         {
           public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
             super.updateTick(world, pos, state, random);
             int x = pos.getX();
             int y = pos.getY();
             int z = pos.getZ();
             // null  = this;
             
             HashMap<Object, Object> $_dependencies = new HashMap<>();
             $_dependencies.put("x", Integer.valueOf(x));
             $_dependencies.put("y", Integer.valueOf(y));
             $_dependencies.put("z", Integer.valueOf(z));
             $_dependencies.put("world", world);
             SpringwaterUpdateTick.executeProcedure((HashMap)$_dependencies);
             
             world.scheduleUpdate(new BlockPos(x, y, z), (Block)this, tickRate(world));
           }
 
           
           public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
             super.onEntityCollidedWithBlock(world, pos, state, entity);
             int x = pos.getX();
             int y = pos.getY();
             int z = pos.getZ();
             // null  = this;
             
             HashMap<Object, Object> $_dependencies = new HashMap<>();
             $_dependencies.put("entity", entity);
             SpringwaterMobplayerCollidesBlock.executeProcedure((HashMap)$_dependencies);
           }
         }).setUnlocalizedName("springwater").setRegistryName("springwater"));
     
     this.elements.items.add(() -> (Item)(new ItemBlock(block)).setRegistryName("springwater"));
   }
 
   
   public void preInit(FMLPreInitializationEvent event) {
     FluidRegistry.registerFluid(this.fluid);
     FluidRegistry.addBucketForFluid(this.fluid);
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelBakery.registerItemVariants(item, new ResourceLocation[0]);
     ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition()
         {
           public ModelResourceLocation getModelLocation(ItemStack stack) {
             return new ModelResourceLocation("byg:springwater", "springwater");
           }
         });
     ModelLoader.setCustomStateMapper(block, (IStateMapper)new StateMapperBase()
         {
           protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
             return new ModelResourceLocation("byg:springwater", "springwater");
           }
         });
   }
 }




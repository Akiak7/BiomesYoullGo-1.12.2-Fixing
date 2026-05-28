 package net.potionstudios.byg;
 
 import com.google.common.collect.Sets;
 import java.util.HashMap;
 import java.util.Set;
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.init.Blocks;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.item.ItemTool;
 import net.minecraft.world.World;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.common.util.EnumHelper;
 import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 
 @Elementsbyg.ModElement.Tag
 public class Lathariumbattleaxe
   extends Elementsbyg.ModElement
 {
   @ObjectHolder("byg:lathariumbattleaxe")
   public static final Item block = null;
   
   public Lathariumbattleaxe(Elementsbyg instance) {
     super(instance, 941);
   }
 
   
   public void initElements() {
     this.elements.items.add(() -> ((Item)(new ItemToolCustom()
         {
           public boolean hitEntity(ItemStack itemstack, EntityLivingBase entity, EntityLivingBase entity2) {
             super.hitEntity(itemstack, entity, entity2);
             int x = (int)entity.posX;
             int y = (int)entity.posY;
             int z = (int)entity.posZ;
             World world = entity.world;
             
             HashMap<Object, Object> $_dependencies = new HashMap<>();
             $_dependencies.put("entity", entity);
             $_dependencies.put("x", Integer.valueOf(x));
             $_dependencies.put("y", Integer.valueOf(y));
             $_dependencies.put("z", Integer.valueOf(z));
             $_dependencies.put("world", world);
             LathariumswordMobIsHitWithTool.executeProcedure((HashMap)$_dependencies);
             
             return true;
           }
         }).setUnlocalizedName("lathariumbattleaxe").setRegistryName("lathariumbattleaxe")).setCreativeTab(BYGTab.tab));
   }
 
   
   @SideOnly(Side.CLIENT)
   public void registerModels(ModelRegistryEvent event) {
     ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("byg:lathariumbattleaxe", "inventory"));
   }
   
   private static class ItemToolCustom extends ItemTool {
     private static final Set<Block> effective_items_set = Sets.newHashSet(new Block[] { Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, (Block)Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE });
 
 
     
     protected ItemToolCustom() {
       super(EnumHelper.addToolMaterial("LATHARIUMBATTLEAXE", 2, 950, 9.0F, 5.0F, 8), effective_items_set);
       this.attackDamage = 5.0F;
       this.attackSpeed = -3.1F;
     }
 
     
     public float getDestroySpeed(ItemStack stack, IBlockState state) {
       Material material = state.getMaterial();
       return (material != Material.WOOD && material != Material.PLANTS && material != Material.VINE) ? super
         .getDestroySpeed(stack, state) : this.efficiency;
     }
   }
 }




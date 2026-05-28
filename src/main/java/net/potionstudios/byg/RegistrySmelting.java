 package net.potionstudios.byg;
 
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import net.minecraftforge.oredict.OreDictionary;
 
 @Elementsbyg.ModElement.Tag
public class RegistrySmelting
extends Elementsbyg.ModElement {
	 public RegistrySmelting(Elementsbyg instance) {
		  super(instance, 2420);
		}
	 
	   public void init(FMLInitializationEvent event) {
		     // Ores
		     GameRegistry.addSmelting(new ItemStack(Kasaiore.block, 1), new ItemStack(Kasaiingot.block, 1), 1.0F);
		     GameRegistry.addSmelting(new ItemStack(Lathariumore.block, 1), new ItemStack(Lathariumgem.block, 1), 1.0F);
		     GameRegistry.addSmelting(new ItemStack(Pendoriteore.block, 1), new ItemStack(Pendoritegem.block, 1), 1.0F);
		     GameRegistry.addSmelting(new ItemStack(Tamreliteore.block, 1), new ItemStack(Tamrelitegem.block, 1), 1.0F);
		     
		     // Woods to charcoal
		     GameRegistry.addSmelting(new ItemStack(Aspen_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Aspen_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Baobab_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Baobablog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Blue_enchanted_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Cherry_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Cherrylog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Cika_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Cikalog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Cypress_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Cypresslog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Ebony_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Ebonylog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Enchantedlog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Firlog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Firwood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Frozen_oak_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Frozenoaklog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Great_oak_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Greatoaklog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Green_enchanted_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Greenenchantedlog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Hawthorn_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Hawthornlog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Holly_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Hollylog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Ironwood_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Ironwoodlog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Jacaranda_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Jacarandalog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Mahogany_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Mahogany_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Mangrove_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Mangrovelog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Maple_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Maplelog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Palm_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Palm_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Palo_verde_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Paloverdelog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Pine_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Pinelog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Plant_stem.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Rainbow_eucalyptus_wood_wall.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Rainbow_eucalyptus_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Rainboweucalyptuslog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Redwood_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Redwoodlog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Rowan_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Rowanlog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Skyris_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Skyrislog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_aspen_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_aspen_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_baobab_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_baobab_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_blue_enchanted_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_blue_enchanted_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_cherry_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_cherry_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_cika_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_cika_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_cypress_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_cypress_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_ebony_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_ebony_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_great_oak_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_great_oak_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_green_enchanted_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_green_enchanted_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_hawthorn_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_hawthorn_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_holly_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_holly_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_ironwood_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_ironwood_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_jacaranda_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_jacaranda_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_mangrove_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_mangrove_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_maple_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_maple_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_palo_verde_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_palo_verde_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_pine_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_pine_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_rainbow_eucalyptus_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_rainbow_eucalyptus_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_redwood_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_redwood_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_rowan_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_rowan_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_skyris_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_skyris_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_willow_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_willow_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_witch_hazel_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_witch_hazel_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_zelkova_log.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Stripped_zelkova_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Strippedfirlog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Strippedfirwood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Willow_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Willowlog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Witch_hazel_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Witchhazellog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Zelkova_wood.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
		     GameRegistry.addSmelting(new ItemStack(Zelkovalog.block, 1), new ItemStack(Items.COAL, 1, 1), 0.15F);
	   }
}

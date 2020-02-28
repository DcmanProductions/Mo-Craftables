package net.chaselabs.Mo_Craftables;

import net.chaselabs.Mo_Craftables.Items.BlockItemBase;
import net.chaselabs.Mo_Craftables.lists.BlockList;
import net.chaselabs.Mo_Craftables.lists.ItemList;
import net.chaselabs.Mo_Craftables.utilities.References;
import net.chaselabs.Mo_Craftables.utilities.References.LogTypes;
import net.chaselabs.Mo_Craftables.world.AnvilRecipe;
import net.chaselabs.Mo_Craftables.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * The Setup Class
 * 
 * @author drew_
 *
 */
public class SideProxy {

	SideProxy() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::commonSetup);
		MinecraftForge.EVENT_BUS.addListener(this::serverStarting);
	}

	private static void commonSetup(FMLCommonSetupEvent event) {
		OreGeneration.setupOreGeneration();
		AnvilRecipe.registerItems();
		Main.Log(LogTypes.Info, "Common Setup for " + References.MOD_ID);
	}

	private void serverStarting(FMLServerStartingEvent event) {
//		RegisterEvents.registerEnchantments();
		Main.Log(LogTypes.Info, "Server Setup for " + References.MOD_ID);
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerLoot(LootTableLoadEvent event) {
		}

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {

			for (ItemList list : ItemList.values()) {
				event.getRegistry().register(list.getItem());
			}
			for (BlockList value : BlockList.values()) {
				event.getRegistry().register(new BlockItemBase(value.getBlock()));
			}

			Main.Log(LogTypes.Info, "Items Registered.");
		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			for (BlockList list : BlockList.values()) {
				event.getRegistry().register(list.getBlock());
			}
			Main.Log(LogTypes.Info, "Blocks Registered.");
		}

	}

}

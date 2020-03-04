package net.chaselabs.Mo_Craftables;

import net.chaselabs.Mo_Craftables.Blocks.BlockBase;
import net.chaselabs.Mo_Craftables.Blocks.TileEntity.UncraftingTableTile;
import net.chaselabs.Mo_Craftables.GUI.Container.UnCraftingTableContainer;
import net.chaselabs.Mo_Craftables.GUI.Screens.UnCraftingTableScreen;
import net.chaselabs.Mo_Craftables.Items.BlockItemBase;
import net.chaselabs.Mo_Craftables.commands.MoCommands;
import net.chaselabs.Mo_Craftables.lists.BlockList;
import net.chaselabs.Mo_Craftables.lists.ItemList;
import net.chaselabs.Mo_Craftables.utilities.Cache;
import net.chaselabs.Mo_Craftables.utilities.References;
import net.chaselabs.Mo_Craftables.utilities.References.LogTypes;
import net.chaselabs.Mo_Craftables.world.AnvilRecipe;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
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
		AnvilRecipe.registerItems();
		Main.Log(LogTypes.Info, "Common Setup for " + References.MOD_ID);
		ScreenManager.registerFactory(References.UNCRAFTING_TABLE_CONTAINER, UnCraftingTableScreen::new);
	}

	private void serverStarting(FMLServerStartingEvent event) {
		Main.Log(LogTypes.Info, "Server Setup for " + References.MOD_ID);
		new MoCommands().register(event.getCommandDispatcher());
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerLoot(LootTableLoadEvent event) {
		}

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			for (ItemList value : ItemList.values())
				event.getRegistry().register(value.getItem());
			for (BlockList value : BlockList.values())
				for (BlockBase block : value.getBlock())
					event.getRegistry().register(new BlockItemBase(block));

		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			for (BlockList value : BlockList.values())
				for (BlockBase block : value.getBlock())
					event.getRegistry().register(block);
		}

		@SubscribeEvent
		public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
			event.getRegistry().register(IForgeContainerType.create((windowID, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				return new UnCraftingTableContainer(windowID, Minecraft.getInstance().world, pos, inv);
			}).setRegistryName("uncrafting_table"));
		}

		@SubscribeEvent
		public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
//			event.getRegistry().register(TileEntityType.Builder.create(UncraftingTableTile::new, BlockList.uncrafting_table.getBlock().get(0)).build(null).setRegistryName("uncrafting_table"));
		}

	}

}

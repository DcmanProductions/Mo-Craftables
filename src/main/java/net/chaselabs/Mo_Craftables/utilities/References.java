package net.chaselabs.Mo_Craftables.utilities;

import net.chaselabs.Mo_Craftables.MoItemGroup;
import net.chaselabs.Mo_Craftables.Blocks.TileEntity.UncraftingTableTile;
import net.chaselabs.Mo_Craftables.GUI.Container.UnCraftingTableContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ObjectHolder;

public class References {

	/**
	 * An Enumeration of Varying Log Urgencies
	 * 
	 * @author drew_
	 *
	 */
	public static enum LogTypes {
		Error,
		Debug,
		Warn,
		Info
	}

	public static ItemGroup mo_craftables_itemgroup = new MoItemGroup();

	@ObjectHolder("mo_craftables:uncrafting_table")
	public static ContainerType<UnCraftingTableContainer> UNCRAFTING_TABLE_CONTAINER;

	@ObjectHolder("mo_craftables:uncrafting_table")
	public static TileEntityType<UncraftingTableTile> UNCRAFTING_TABLE_TILE;

	/**
	 * Gets the adjusted Resource Location
	 * 
	 * @param name
	 * @return Adjusted Resource Location
	 */
	public static ResourceLocation location(String name) {
		return new ResourceLocation(MOD_ID, name);
	}

	public static final String MOD_ID = "mo_craftables";
}

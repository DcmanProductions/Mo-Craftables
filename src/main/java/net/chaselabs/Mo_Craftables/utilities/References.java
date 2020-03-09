package net.chaselabs.Mo_Craftables.utilities;

import net.chaselabs.Mo_Craftables.MoItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

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

//	@ObjectHolder("mo_craftables:uncrafting_table")
//	public static ContainerType<UnCraftingTableContainer> UNCRAFTING_TABLE_CONTAINER;
//
//	@ObjectHolder("mo_craftables:uncrafting_table")
//	public static TileEntityType<UncraftingTableTile> UNCRAFTING_TABLE_TILE;

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

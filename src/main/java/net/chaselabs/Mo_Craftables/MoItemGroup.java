package net.chaselabs.Mo_Craftables;

import net.chaselabs.Mo_Craftables.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MoItemGroup extends ItemGroup {

	public MoItemGroup() {
		super("mo_craftables_itemgroup");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.elytra_wing_item.getItem());
	}

}

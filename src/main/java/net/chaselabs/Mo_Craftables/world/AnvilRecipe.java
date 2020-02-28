package net.chaselabs.Mo_Craftables.world;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.INBT;
import net.minecraftforge.event.AnvilUpdateEvent;

public class AnvilRecipe extends AnvilUpdateEvent {

	public AnvilRecipe(ItemStack left, ItemStack right, String name, int cost) {
		super(left, right, name, cost);
	}

	public static void registerItems() {
		ItemStack left = new ItemStack(Items.ENCHANTED_BOOK);
		ItemStack right = new ItemStack(Items.BOOK);
		for (INBT nbt : left.getEnchantmentTagList()) {
			right.getEnchantmentTagList().add(nbt);
		}
		String name = left.getDisplayName().getString();
		int cost = 0;
		new AnvilRecipe(left, right, name, cost);
	}

}
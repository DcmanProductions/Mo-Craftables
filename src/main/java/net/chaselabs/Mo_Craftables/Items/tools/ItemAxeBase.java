package net.chaselabs.Mo_Craftables.Items.tools;

import java.util.Map;

import net.chaselabs.Mo_Craftables.Main;
import net.chaselabs.Mo_Craftables.utilities.References;
import net.chaselabs.Mo_Craftables.utilities.References.LogTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

/**
 * Creates a Basic Axe
 * 
 * @author drew_
 *
 */
public class ItemAxeBase extends AxeItem {
	String displayName;

	/**
	 * 
	 * @param tier - The Item Tier Type
	 * @param name - The Resource Name
	 */
	public ItemAxeBase(IItemTier tier, String name, String displayName) {
		super(tier, 2.f, 4.f, new Item.Properties().group(References.mo_craftables_itemgroup));
		this.displayName = displayName;
		setRegistryName(References.location(name));
	}

	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		if (displayName == "")
			return super.getDisplayName(stack);
		return new StringTextComponent(displayName);
	}

	/**
	 * Adds Enchantments to a Specific Item
	 * 
	 * @param item - Item to which to add the enchantments
	 * @param map  - A Map with both enchantment and level
	 */
	@SuppressWarnings("unchecked")
	public void addEnchanements(Item item, Map<Enchantment, Integer>... map) {
		ItemStack stack = item.getDefaultInstance();

		for (int i = 0; i < map.length; i++) {
			for (Enchantment e : map[i].keySet()) {
				int level = map[i].get(e);
				Main.Log(LogTypes.Warn, "Adding " + e.getDisplayName(map[i].get(e)).getFormattedText() + " Level " + level + " to " + stack.getDisplayName().getFormattedText());
				stack.addEnchantment(e, level);
			}
//			EnchantmentHelper.setEnchantments(map[i], stack);
		}
	}

}

package net.chaselabs.Mo_Craftables.Items.tools;

import java.util.Map;
import java.util.Map.Entry;

import net.chaselabs.Mo_Craftables.Main;
import net.chaselabs.Mo_Craftables.utilities.References;
import net.chaselabs.Mo_Craftables.utilities.References.LogTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

/**
 * Creates a Basic Shovel
 * 
 * @author drew_
 *
 */
public class ItemShovelBase extends ShovelItem {
	String displayName;

	/**
	 * 
	 * @param tier - The Item Tier Type
	 * @param name - The Resource Name
	 */
	public ItemShovelBase(IItemTier tier, String name, String displayName) {
		super(tier, -2, 6.f, new Item.Properties().group(References.mo_craftables_itemgroup));
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
	@SuppressWarnings("deprecation")
	public void addEnchanements(Item item, Map<Enchantment, Integer> map) {
		ItemStack stack = item.getDefaultInstance();

		for (Enchantment e : map.keySet()) {
			Main.Log(LogTypes.Warn, "Adding " + e.getDisplayName(map.get(e)).getFormattedText() + " Level " + map.get(e) + " to " + stack.getDisplayName().getFormattedText());
		}
		EnchantmentHelper.setEnchantments(map, stack);
		CompoundNBT root = new CompoundNBT();
		ListNBT listnbt = new ListNBT();

		for (Entry<Enchantment, Integer> entry : map.entrySet()) {
			Enchantment enchantment = entry.getKey();
			if (enchantment != null) {
				int level = entry.getValue();
				Main.Log(LogTypes.Debug, "Attempting to Add Enchantment " + enchantment.getName() + " Level " + level + " to " + stack.getDisplayName().getString());
				try {
					CompoundNBT compoundnbt = new CompoundNBT();
					compoundnbt.putString("id", String.valueOf((Object) Registry.ENCHANTMENT.getKey(enchantment)));
					compoundnbt.putShort("lvl", (short) level);
					listnbt.add(compoundnbt);

					if (stack.getItem() == Items.ENCHANTED_BOOK) {
						EnchantedBookItem.addEnchantment(stack, new EnchantmentData(enchantment, level));
					}
				} catch (Exception e) {
					e.printStackTrace();
					Main.Log(LogTypes.Error, "ERROR: " + e.getStackTrace());
				}
			} else
				Main.Log(LogTypes.Error, "Enchantment = null");
		}
		root.put("Enchantments", listnbt);
		root.putInt("RepairCost", 1);

		CompoundNBT wrote = stack.write(root);
		Main.Log(LogTypes.Debug, "NBT List was written: \n{\n  " + wrote.toFormattedComponent().getString() + "  \n}\n");
		stack.setTag(root);
//		if (listnbt.isEmpty()) {
//			Main.Log(LogTypes.Debug, "NBT List was empty");
//			stack.removeChildTag("Enchantments");
//		} else if (stack.getItem() != Items.ENCHANTED_BOOK) {
//		}

	}

}

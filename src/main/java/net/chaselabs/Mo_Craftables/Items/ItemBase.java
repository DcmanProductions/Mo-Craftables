package net.chaselabs.Mo_Craftables.Items;

import net.chaselabs.Mo_Craftables.utilities.References;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

/**
 * Creates a Generic Item
 * 
 * @author drew_
 *
 */
public class ItemBase extends Item {

	String displayName = "";

	protected static Item.Properties properties = new Item.Properties().group(References.mo_craftables_itemgroup);

	public ItemBase(String name, String displayName) {
		super(properties);
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
	 * 
	 * @param location - The Resource Location
	 */
	public ItemBase(ResourceLocation location) {
		super(properties);
		setRegistryName(location);
	}

	/**
	 * Returns an Object of type Item of the current Object.
	 */
	public Item getItem() {
		return this.asItem();
	}

	/**
	 * Returns an Object of type ItemStack of the current Object.
	 */
	public ItemStack getStack() {
		return this.asItem().getDefaultInstance();
	}

}

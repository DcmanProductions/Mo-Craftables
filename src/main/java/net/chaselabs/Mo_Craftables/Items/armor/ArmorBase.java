package net.chaselabs.Mo_Craftables.Items.armor;

import net.chaselabs.Mo_Craftables.utilities.References;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class ArmorBase extends ArmorItem {

	public static Properties property = new Item.Properties().group(References.mo_craftables_itemgroup);

	String displayName;

	public ArmorBase(String name, String displayName, IArmorMaterial materialIn, EquipmentSlotType slot) {
		super(materialIn, slot, property);
		this.displayName = displayName;
		setRegistryName(References.location(name));
	}

	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		if (displayName == "")
			return super.getDisplayName(stack);
		return new StringTextComponent(displayName);
	}

}

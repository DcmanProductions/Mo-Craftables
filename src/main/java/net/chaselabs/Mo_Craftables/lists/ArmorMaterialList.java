package net.chaselabs.Mo_Craftables.lists;

import net.chaselabs.Mo_Craftables.utilities.References;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ArmorMaterialList implements IArmorMaterial {
	ender("ender", 30, new int[] { 4, 7, 9, 4 }, 5, 2.f, ItemList.ender_ingot.getItem(), SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND);

	int durability, damage_reduction[], enchantability;
	float toughness;
	String name;
	Item repairItem;
	SoundEvent sound;
	final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };

	private ArmorMaterialList(String name, int durability, int[] damage_reduction, int enchantability, float toughness, Item repairItem, SoundEvent sound) {
		this.durability = durability;
		this.damage_reduction = damage_reduction;
		this.enchantability = enchantability;
		this.toughness = toughness;
		this.name = name;
		this.repairItem = repairItem;
		this.sound = sound;
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * durability;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return damage_reduction[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return sound;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromStacks(repairItem.getDefaultInstance());
	}

	@Override
	public String getName() {
		return References.MOD_ID + ":" + name;
	}

	@Override
	public float getToughness() {
		return toughness;
	}
}

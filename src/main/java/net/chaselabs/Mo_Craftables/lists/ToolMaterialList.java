package net.chaselabs.Mo_Craftables.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier {

	ender(6.f, 7.f, 1500, 3, 25, ItemList.ender_ingot.getItem()),
	plastic(1.f, 2.f, 8000, 0, 0, ItemList.plastic_item.getItem()),
	reusable_pearl(0, 0, 500, 0, 0, ItemList.ender_ingot.getItem());

	private float attackDamage, efficency;
	private int durability, harvestLevel, enchantability;
	Item repairMaterial;

	/**
	 * 
	 * @param attackDamage   = Damage Registered on Attack
	 * @param efficency      = Mining Speed
	 * @param durability     = Number Of Uses
	 * @param harvestLevel   = What Blocks it can Harvest
	 * @param enchantability = The Ease of Receiving Good Enchants for Low Cost
	 * @param repairMaterial = The Material Required to Repair
	 */
	private ToolMaterialList(float attackDamage, float efficency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
		this.attackDamage = attackDamage;
		this.efficency = efficency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public float getAttackDamage() {
		return attackDamage;
	}

	@Override
	public float getEfficiency() {
		return efficency;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public int getHarvestLevel() {
		return harvestLevel;
	}

	@Override
	public int getMaxUses() {
		return durability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(repairMaterial);
	}

}

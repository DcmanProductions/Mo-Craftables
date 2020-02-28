package net.chaselabs.Mo_Craftables.lists;

import net.chaselabs.Mo_Craftables.Items.ItemBase;
import net.chaselabs.Mo_Craftables.Items.ReusableEnderPearlItem;
import net.chaselabs.Mo_Craftables.Items.armor.EnderArmor;
import net.chaselabs.Mo_Craftables.Items.tools.ender.ItemAxeEnder;
import net.chaselabs.Mo_Craftables.Items.tools.ender.ItemHoeEnder;
import net.chaselabs.Mo_Craftables.Items.tools.ender.ItemPickaxeEnder;
import net.chaselabs.Mo_Craftables.Items.tools.ender.ItemShovelEnder;
import net.chaselabs.Mo_Craftables.Items.tools.ender.ItemSwordEnder;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.util.ResourceLocation;

public enum ItemList {
	// Items ~ Start
	elytra_wing_item(new ItemBase("elytra_wing_item", "Elytra Wing")),
	phantom_paste_item(new ItemBase("phantom_paste_item", "Phantom Paste")),
	plastic_item(new ItemBase("plastic_item", "Plastic")),
	ender_shard_item(new ItemBase("ender_shard_item", "Ender Shard")),
	ender_ingot(new ItemBase("ender_ingot", "Ender Ingot")),
	silicon_item(new ItemBase("silicon_item", "Silicon")),
	glass_shard_item(new ItemBase("glass_shard_item", "Glass Shard")),
	plastic_resine_item(new ItemBase("plastic_resine_item", "Plastic Resine")),
	obsidian_rod(new ItemBase("obsidian_rod", "Obsidian Rod")),
	reusable_ender_pearl(new ReusableEnderPearlItem("reusable_ender_pearl")),
	packed_ender_pearl(new ItemBase("packed_ender_pearl", "Packed Ender Pearl")),

	// Items ~ End

	// Tools ~ Start
	ender_axe(new ItemAxeEnder(ToolMaterialList.ender, "ender_axe", "Ender Axe")),

	ender_sword(new ItemSwordEnder(ToolMaterialList.ender, "ender_sword", "Ender Sword")),
	ender_pickaxe(new ItemPickaxeEnder(ToolMaterialList.ender, "ender_pickaxe", "Ender Pickaxe")),
	ender_shovel(new ItemShovelEnder(ToolMaterialList.ender, "ender_shovel", "Ender Shovel")),
	ender_hoe(new ItemHoeEnder(ToolMaterialList.ender, "ender_hoe", "Ender Hoe")),

//	plastic_axe(new ItemAxePlastic(ToolMaterialList.plastic, "plastic_axe")),
//	plastic_sword(new ItemSwordPlastic(ToolMaterialList.plastic, "plastic_sword")),
//	plastic_pickaxe(new ItemPickaxePlastic(ToolMaterialList.plastic, "plastic_pickaxe")),
//	plastic_shovel(new ItemShovelPlastic(ToolMaterialList.plastic, "plastic_shovel")),
//	plastic_hoe(new ItemHoePlastic(ToolMaterialList.plastic, "plastic_hoe")),

	// Tools ~ End

	// Armor ~ Start
	ender_helm(new EnderArmor("ender_helm", "Ender Helmet", EquipmentSlotType.HEAD)),
	ender_chest(new EnderArmor("ender_chest", "Ender Chestplate", EquipmentSlotType.CHEST)),
	ender_pants(new EnderArmor("ender_pants", "Ender Leggings", EquipmentSlotType.LEGS)),
	ender_boots(new EnderArmor("ender_boots", "Ender Boots", EquipmentSlotType.FEET))
	// Armor ~ End

	;

	Item item;
	Properties properties;

	ItemList(Item item) {
		this.item = item;
		properties = new Properties();
	}

	ItemList(Item item, Item.Properties properties) {
		this.item = item;
		this.properties = properties;
	}

	public Item getItem() {
		return item;
	}

	public Properties getProperties() {
		return properties;
	}

	public String getItemDisplayName() {
		return item.getName().getString();
	}

	public ResourceLocation getItemResourceLocation() {
		return item.getRegistryName();
	}

	public String getItemResourceString() {
		return item.getRegistryName().toString();
	}

}

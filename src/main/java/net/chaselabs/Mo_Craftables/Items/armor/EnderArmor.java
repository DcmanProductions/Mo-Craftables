package net.chaselabs.Mo_Craftables.Items.armor;

import net.chaselabs.Mo_Craftables.Main;
import net.chaselabs.Mo_Craftables.lists.ArmorMaterialList;
import net.chaselabs.Mo_Craftables.utilities.References.LogTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class EnderArmor extends ArmorBase {

	public EnderArmor(String name, String displayName, EquipmentSlotType slot) {
		super(name, displayName, ArmorMaterialList.ender, slot);
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		Main.Log(LogTypes.Warn, attacker.getDisplayName().getString() + " hit " + target.getDisplayName().getString());
//		Teleport.random(target, 100);
		return super.hitEntity(stack, target, attacker);
	}

}

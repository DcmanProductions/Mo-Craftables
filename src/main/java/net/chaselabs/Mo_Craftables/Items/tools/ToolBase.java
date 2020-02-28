package net.chaselabs.Mo_Craftables.Items.tools;

import java.util.Set;

import net.chaselabs.Mo_Craftables.utilities.References;
import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ToolItem;

public class ToolBase extends ToolItem {
	private static Properties properties;

	public ToolBase(String name, float attackDamageIn, float attackSpeedIn, IItemTier tier, Set<Block> effectiveBlocksIn) {
		super(attackDamageIn, attackSpeedIn, tier, effectiveBlocksIn, properties.group(References.mo_craftables_itemgroup));
		setRegistryName(References.location(name));
	}

}

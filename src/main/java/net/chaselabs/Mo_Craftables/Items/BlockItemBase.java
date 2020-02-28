package net.chaselabs.Mo_Craftables.Items;

import net.chaselabs.Mo_Craftables.Blocks.BlockBase;
import net.chaselabs.Mo_Craftables.utilities.References;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class BlockItemBase extends BlockItem {

	String displayName = "";

	public BlockItemBase(BlockBase block) {
		super(block, new Item.Properties().group(References.mo_craftables_itemgroup));
		setRegistryName(block.getRegistryName());
		displayName = block.getDisplayName();
	}

	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		if (displayName != "")
			return new StringTextComponent(displayName);
		return super.getDisplayName(stack);
	}
}

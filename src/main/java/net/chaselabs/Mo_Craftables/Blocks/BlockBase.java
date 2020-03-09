package net.chaselabs.Mo_Craftables.Blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;

public class BlockBase extends Block {
	String displayName = "";
	String[] flavor;

	public BlockBase(String name, Properties properties, String displayName, String... flavor) {
		super(properties);
		setRegistryName(name);
		this.displayName = displayName;
		if (flavor.length != 0 && flavor != null)
			this.flavor = flavor;
		else
			this.flavor = new String[0];
	}
	
	@Override
	public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		for (String value : getFlavorText()) {
			tooltip.add(new StringTextComponent(value));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	public String getDisplayName() {
		return displayName;
	}

	public String[] getFlavorText() {
		return flavor;
	}

}

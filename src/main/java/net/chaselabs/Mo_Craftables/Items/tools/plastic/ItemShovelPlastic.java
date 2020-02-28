package net.chaselabs.Mo_Craftables.Items.tools.plastic;

import java.util.List;

import net.chaselabs.Mo_Craftables.Items.tools.ItemShovelBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

@SuppressWarnings("all")
public class ItemShovelPlastic extends ItemShovelBase {

	public ItemShovelPlastic(IItemTier tier, String name, String displayName) {
		super(tier, name, displayName);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> toolTip, ITooltipFlag flag) {
		super.addInformation(stack, world, toolTip, flag);
//		toolTip.add(new StringTextComponent("Has SilkTouch by Default"));
	}

}

package net.chaselabs.Mo_Craftables.Items.tools.plastic;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.chaselabs.Mo_Craftables.Items.tools.ItemSwordBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

@SuppressWarnings("all")
public class ItemSwordPlastic extends ItemSwordBase {

	public ItemSwordPlastic(IItemTier tier, String name, String displayName) {
		super(tier, name, displayName);
//		addEnchanements(this, Stream.of(new AbstractMap.SimpleEntry<Enchantment, Integer>(Enchantments.SILK_TOUCH, 1)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> toolTip, ITooltipFlag flag) {
		super.addInformation(stack, world, toolTip, flag);
		toolTip.add(new StringTextComponent("Is A Bad Weapon"));
	}

}

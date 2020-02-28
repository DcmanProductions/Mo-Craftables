package net.chaselabs.Mo_Craftables.Items.tools.ender;

import java.util.List;

import net.chaselabs.Mo_Craftables.Items.tools.ItemHoeBase;
import net.chaselabs.Mo_Craftables.utilities.Teleport;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class ItemHoeEnder extends ItemHoeBase {

	public ItemHoeEnder(IItemTier tier, String name, String displayName) {
		super(tier, name,displayName);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> toolTip, ITooltipFlag flag) {
		super.addInformation(stack, world, toolTip, flag);
//		toolTip.add(new StringTextComponent("Blocks Broken with this will be DELETED!"));
		toolTip.add(new StringTextComponent("Entities Hit with this will be Teleported Randomly"));
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity attackedEntity, LivingEntity attackingEntity) {
		Teleport.random(attackedEntity, 10);
		return super.hitEntity(stack, attackedEntity, attackingEntity);
	}

}

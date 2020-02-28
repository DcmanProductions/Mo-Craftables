package net.chaselabs.Mo_Craftables.Items;

import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * Creates an Item that Launches EnderPearls
 * 
 * @author drew_
 *
 */
public class ReusableEnderPearlItem extends ProjectileToolBase {

	public ReusableEnderPearlItem(String name) {
		super(name, "ReUsable Ender Pearl", 500);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		launchProjectile(player, new EnderPearlEntity(world, player));
		return super.onItemRightClick(world, player, hand);
	}

}

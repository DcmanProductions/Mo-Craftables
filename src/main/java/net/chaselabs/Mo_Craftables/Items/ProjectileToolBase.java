package net.chaselabs.Mo_Craftables.Items;

import net.chaselabs.Mo_Craftables.Main;
import net.chaselabs.Mo_Craftables.utilities.References.LogTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

/**
 * Creates a Tool that launches projectiles
 * 
 * @author drew_
 *
 */
public class ProjectileToolBase extends ItemBase {

	/**
	 * 
	 * @param name      - The Resource Name
	 * @param maxDamage - Sets the Tools Max Damage
	 */
	public ProjectileToolBase(String name, String displayName, int maxDamage) {
		super(name, displayName);
	}

	public boolean launchProjectile(Entity entity, ProjectileItemEntity projectile) {
		try {
			if (entity instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity) entity;
				World world = player.world;
				if (!world.isRemote()) {
					setDamage(getStack(), getStack().getDamage() - 1);
					showDurabilityBar(getStack());
					projectile.setMotion(player.getLookVec());
					if (world.addEntity(projectile)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			PlayerEntity player = null;
			if (entity instanceof PlayerEntity)
				player = (PlayerEntity) entity;
			if (player != null) {
				player.sendMessage(new StringTextComponent(TextFormatting.RED + "ERROR: " + e.getMessage() + "\n" + e.getStackTrace()));
			} else {
				Main.Log(LogTypes.Error, "ERROR: Player Equals NULL!\nMessage: " + e.getMessage() + "\nStackTrace: \n" + e.getStackTrace());
			}
			return false;
		}

		return false;
	}

}

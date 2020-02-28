package net.chaselabs.Mo_Craftables.utilities;

import java.util.Random;

import net.chaselabs.Mo_Craftables.Main;
import net.chaselabs.Mo_Craftables.utilities.References.LogTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.server.ServerWorld;

/**
 * A Custom interdimensional teleporting class
 * 
 * @author Drew Chase
 *
 */
@SuppressWarnings("all")
public class Teleport extends Teleporter {
	private final ServerWorld world;
	private double x, y, z;
	private float yaw, pitch;

	/**
	 * Gathers information for teleportation
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param yaw
	 * @param pitch
	 * @author Drew Chase
	 */
	public Teleport(ServerWorld world, double x, double y, double z, float yaw, float pitch) {
		super(world);
		this.world = world;
		this.y = y;
		this.x = x;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}

//	public void placeInPortal(Entity entity, float rotationYaw) {
//		this.world.getBlockState(new BlockPos((int) this.x, (int) this.y, (int) this.z));
//		// entity.setPosition(this.x, this.y, this.z);
//		entity.setPositionAndRotation(this.x, this.y, this.z, this.yaw, this.pitch);
//		entity.motionX = 0.0f;
//		entity.motionY = 0.0f;
//		entity.motionZ = 0.0f;
//	}

	/**
	 * Teleports a player to a specific position in a specific dimension
	 * 
	 * @param entity
	 * @param dimension
	 * @param x
	 * @param y
	 * @param z
	 * @param yaw
	 * @param pitch
	 * @author Drew Chase
	 */
	public static void teleport(Entity entity, double x, double y, double z, float yaw, float pitch) {
		entity.setPositionAndUpdate(x, y, z);
		entity.setPositionAndRotation(x, y, z, yaw, pitch);
	}

	public static void random(Entity entity, int range) {
		random(entity, range, 0);
	}

	private static void random(Entity entity, int range, int attempts) {
		if (attempts >= 2)
			return;

		Random ran = new Random();
		int var = ran.nextInt(range);
		double x, y, z;
		x = entity.getPosition().getX() + var;
		y = entity.getPosition().getY() + 7;
		z = entity.getPosition().getZ() + var;
		BlockPos pos = new BlockPos(x, y, z);

		// Makes sure that the player is on solid ground
		while (!isSafeToLand(entity, pos) && y > 4) {
			y--;
			pos = new BlockPos(x, y, z);
		}

		if (!isSafeToLand(entity, pos)) {
			//random(entity, range--, attempts++);
		}

		// Increases the players y so that they are above ground
		y += 1;

		float yaw = 0.f;
		float pitch = 0.f;
		if (entity instanceof PlayerEntity) {
			yaw = ((PlayerEntity) entity).cameraYaw;
			pitch = ((PlayerEntity) entity).prevRotationPitch;
		}
		teleport(entity, x, y, z, yaw, pitch);
	}

	private static boolean isSafeToLand(Entity entity, BlockPos pos) {
		Block land = entity.world.getBlockState(pos).getBlock();
		Block air = entity.world.getBlockState(pos.add(0, 2, 0)).getBlock();
		if (!(land.equals(Blocks.AIR) || land.equals(Blocks.LAVA) || land.equals(Blocks.VOID_AIR)) && air.equals(Blocks.AIR)) {
			return true;
		}
		return false;
	}

}

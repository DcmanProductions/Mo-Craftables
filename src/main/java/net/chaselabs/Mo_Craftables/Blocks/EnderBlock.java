package net.chaselabs.Mo_Craftables.Blocks;

import net.chaselabs.Mo_Craftables.utilities.Teleport;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnderBlock extends BlockBase {

	public EnderBlock(String name, String displayName, Properties prop) {
		super(name, prop, displayName);
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		super.onBlockHarvested(world, pos, state, player);
		if (world.isRemote)
			Teleport.random(player, 5);
	}

}

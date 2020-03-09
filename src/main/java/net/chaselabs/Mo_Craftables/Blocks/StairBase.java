package net.chaselabs.Mo_Craftables.Blocks;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class StairBase extends StairsBlock {

	public StairBase(Supplier<BlockState> state, BlockBase block) {
		super(state, Properties.from(block));
		setRegistryName(block.getRegistryName() + "_stair");
	}

}

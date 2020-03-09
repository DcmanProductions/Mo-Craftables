package net.chaselabs.Mo_Craftables.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;

public class WallBase extends WallBlock {

	public WallBase(BlockBase block) {
		super(Block.Properties.from(block));
		setRegistryName(block.getRegistryName() + "_wall");
	}

}

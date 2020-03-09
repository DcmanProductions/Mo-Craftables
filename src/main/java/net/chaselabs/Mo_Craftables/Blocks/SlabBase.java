package net.chaselabs.Mo_Craftables.Blocks;

import net.minecraft.block.SlabBlock;

public class SlabBase extends SlabBlock {

	public SlabBase(BlockBase block) {
		super(Properties.from(block));
		setRegistryName(block.getRegistryName() + "_slab");
	}
	

}

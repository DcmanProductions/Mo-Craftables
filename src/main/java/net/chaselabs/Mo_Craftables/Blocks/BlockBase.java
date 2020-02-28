package net.chaselabs.Mo_Craftables.Blocks;

import net.minecraft.block.Block;

public class BlockBase extends Block {
	String displayName = "";

	public BlockBase(String name, String displayName, Properties properties) {
		super(properties);
		setRegistryName(name);
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}

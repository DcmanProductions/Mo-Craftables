package net.chaselabs.Mo_Craftables.lists;

import net.chaselabs.Mo_Craftables.Blocks.BlockBase;
import net.chaselabs.Mo_Craftables.Blocks.EnderBlock;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;

public enum BlockList {

	ender_ore_overworld(new EnderBlock("ender_ore_overworld", "Ender Ore Overworld", Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f))),
	ender_ore_nether(new EnderBlock("ender_ore_nether", "Ender Ore Nether", Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f))),

	silicon_ore_overworld(new BlockBase("silicon_ore_overworld", "Silicon Ore Overworld", Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f))),
	silicon_ore_nether(new BlockBase("silicon_ore_nether", "Silicon Ore Overworld", Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f))),

	marble(new BlockBase("marble", "Marble", Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f))),
	marble_bricks(new BlockBase("marble_bricks", "Marble Bricks", Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5.f)))

	;

	BlockBase block;
	Properties properties;

	BlockList(BlockBase block) {
		this.block = block;
		properties = Properties.from(Blocks.STONE);
	}

	BlockList(BlockBase block, Properties properties) {
		this.block = block;
		this.properties = properties;
	}

	public BlockBase getBlock() {
		return block;
	}

	public String getDisplayName() {
		return block.getDisplayName();
	}

	public ResourceLocation getResourceName() {
		return block.getRegistryName();
	}

	public String getResourceLocationString() {
		return block.getRegistryName().toString();
	}

}

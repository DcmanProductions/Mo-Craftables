package net.chaselabs.Mo_Craftables.lists;

import java.util.Arrays;
import java.util.List;

import net.chaselabs.Mo_Craftables.Blocks.BlockBase;
import net.chaselabs.Mo_Craftables.Blocks.OreBlockBase;
import net.chaselabs.Mo_Craftables.Blocks.OreBlockBase.OreGenDimension;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;

public enum BlockList {

	ender_ore(new OreBlockBase("ender_ore", Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f), OreGenDimension.BOTH, 3, 10, 0, 30, "Ender Ore").getBlocks()),

	silicon_ore(new OreBlockBase("silicon_ore", Properties.create(Material.ROCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f), OreGenDimension.BOTH, 8, 6, 0, 50, "Silicon Ore").getBlocks()),

	marble(new OreBlockBase("marble", Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f), OreGenDimension.Overworld, 16, 20, 0, 100, "Marble").getBlocks()),
	marble_bricks_thin(new BlockBase("marble_bricks_thin", Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5.f), "Marble Bricks", "Thin")),
	marble_bricks_thick(new BlockBase("marble_bricks_thick", Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5.f), "Marble Bricks", "Thick")),

	basalt(new OreBlockBase("basalt", Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f), OreGenDimension.Nether, 16, 20, 0, 100, "Basalt").getBlocks()),
	basalt_bricks_thin(new BlockBase("basalt_bricks_thin", Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5.f), "Basalt Bricks", "Thin")),
	basalt_bricks_thick(new BlockBase("basalt_bricks_thick", Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5.f), "Basalt Bricks", "Thick"))

//	uncrafting_table(new UnCraftingTable());

	;

	List<BlockBase> block;
	Properties properties;

	BlockList(BlockBase block) {
		this.block = Arrays.asList(block);
		this.properties = Properties.from(block);
	}

	BlockList(BlockBase block, Properties properties) {
		this.block = Arrays.asList(block);
		this.properties = properties;
	}

	BlockList(List<BlockBase> blocks) {
		this.block = blocks;
	}

	public List<BlockBase> getBlock() {
		return block;
	}

	public String getDisplayName(int index) {
		return block.get(index).getNameTextComponent().getString();
	}

	public ResourceLocation getResourceName(int index) {
		return block.get(index).getRegistryName();
	}

	public String getResourceLocationString(int index) {
		return block.get(index).getRegistryName().toString();
	}

	public Properties getProperties() {
		return properties;
	}

}

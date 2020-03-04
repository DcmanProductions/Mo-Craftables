package net.chaselabs.Mo_Craftables.Blocks;

import java.util.List;

import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ForgeRegistries;

public class BasaltOreBlock extends OreBlockBase {

	public BasaltOreBlock() {
		super("basalt", Properties.create(Material.ROCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.f), OreGenDimension.BOTH, 16, 20, 0, 100, "Basalt");
	}

	@Override
	protected void OreGeneration(List<BlockBase> blocks, OreGenDimension dimension, int chance, int blocks_in_vein, int min_height, int max_height) {
		if (dimension == OreGenDimension.NONE || blocks == null)
			return;
		int index = 0;
		for (FillerBlockType filler : dimension.getFillerBlock()) {
			for (Biome biome : ForgeRegistries.BIOMES) {
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(filler, blocks.get(index).getDefaultState(), chance), Placement.COUNT_RANGE, new CountRangeConfig(blocks_in_vein, min_height, 0, max_height)));
			}
			index++;
		}
	}

}

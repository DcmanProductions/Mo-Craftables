package net.chaselabs.Mo_Craftables.world;

import net.chaselabs.Mo_Craftables.lists.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {

	public static void setupOreGeneration() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			// Ender Ores
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.ender_ore_overworld.getBlock().getDefaultState(), 3/* Chance */), Placement.COUNT_RANGE, new CountRangeConfig(10/* Ores in One Vein */, 2/* MinHeight */, 0/* Adjusted from Min */, 35/* Max Height */)));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, BlockList.ender_ore_nether.getBlock().getDefaultState(), 10/* Chance */), Placement.COUNT_RANGE, new CountRangeConfig(16/* Ores in One Vein */, 2/* MinHeight */, 0/* Adjusted from Min */, 75/* Max Height */)));

			// Silicon
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.silicon_ore_overworld.getBlock().getDefaultState(), 8/* Chance */), Placement.COUNT_RANGE, new CountRangeConfig(7/* Ores in One Vein */, 2/* MinHeight */, 0/* Adjusted from Min */, 45/* Max Height */)));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK, BlockList.silicon_ore_nether.getBlock().getDefaultState(), 10/* Chance */), Placement.COUNT_RANGE, new CountRangeConfig(9/* Ores in One Vein */, 2/* MinHeight */, 0/* Adjusted from Min */, 75/* Max Height */)));

			// Marble
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.marble.getBlock().getDefaultState(), 15/* Chance */), Placement.COUNT_RANGE, new CountRangeConfig(16/* Ores in One Vein */, 2/* MinHeight */, 0/* Adjusted from Min */, 65/* Max Height */)));
		}
	}

}

package me.Alien.mod.world.gen;

import me.Alien.mod.setup.ModBlock;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.Tags.Blocks;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {
	public static void generateOrs(final BiomeLoadingEvent event) {
		//Main.LOGGER.error("ORE GEN START");
		if(event.getCategory().equals(Biome.Category.THEEND)) {
			//Main.LOGGER.error("ORE GEN IN END");
			GenerateOre(event.getGeneration(), new TagMatchRuleTest(Blocks.END_STONES), ModBlock.ENDER_DEBRI.get().getDefaultState(), 2, 40, 70, 1);
		}
	}

	private static void GenerateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType,
			BlockState state, int veinSize, int minHight, int maxHight, int veinPerChunk) {
		//Main.LOGGER.error("MAKING ORE");
		if(veinSize <= 6)
			veinSize = 6;
		settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
					.withPlacement(Placement.RANGE.configure(
						new TopSolidRangeConfig(minHight, 0, maxHight)))
							.square()
							.func_242731_b(veinPerChunk));
	}
	
}

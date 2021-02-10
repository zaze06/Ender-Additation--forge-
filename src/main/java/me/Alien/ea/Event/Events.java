package me.Alien.ea.Event;

import me.Alien.ea.Main;
import me.Alien.ea.enchants.KillCounter;
import me.Alien.ea.setup.ModBlock;
import me.Alien.ea.setup.ModEnchants;
import me.Alien.ea.setup.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class Events {

    @SubscribeEvent
    public static void generateOrs(final BiomeLoadingEvent event) {
        //Main.LOGGER.error("ORE GEN START");
        if(event.getCategory().equals(Biome.Category.THEEND)) {
            //Main.LOGGER.error("ORE GEN IN END");
            GenerateOre(event.getGeneration(), new TagMatchRuleTest(Tags.Blocks.END_STONES), ModBlock.ENDER_DEBRI.get().getDefaultState(), 2, 40, 70, 1);
        }
    }

    @SubscribeEvent
    public static void GenToolTip(final ItemTooltipEvent event){
        ItemStack stack = event.getItemStack();
        CompoundNBT Tag = stack.getOrCreateChildTag(Main.ModId);
        if(Tag.contains("Kills", 3)){
            int Level = EnchantmentHelper.getEnchantmentLevel(ModEnchants.KillCounter.get(), stack);
            if(Level == 0)
                return;
            List<ITextComponent> Tip = event.getToolTip();
            String Data = "Kiils "+Tag.getInt("Kills")+"/"+ KillCounter.Max[Level];
            Tip.add(ITextComponent.getTextComponentOrEmpty(Data));
            event.setResult(Event.Result.ALLOW);
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

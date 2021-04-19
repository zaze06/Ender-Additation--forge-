package me.Alien.ea.Event;

import me.Alien.ea.Main;
import me.Alien.ea.enchants.KillCounter;
import me.Alien.ea.setup.ModBlock;
import me.Alien.ea.setup.ModEnchants;
import me.Alien.ea.setup.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
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
        List<ITextComponent> Tip = event.getToolTip();
        if(Tag.contains("Kills", 3)){
            int Level = EnchantmentHelper.getEnchantmentLevel(ModEnchants.KillCounter.get(), stack);
            if(Level == 0)
                return;
            String Data = "Kills "+Tag.getInt("Kills")+"/"+ KillCounter.Max[Level];
            Tip.add(1, ITextComponent.getTextComponentOrEmpty(Data));
            event.setResult(Event.Result.ALLOW);
        }
        if(Tag.contains("Uses", 3)){
            Tip.add(2, new StringTextComponent("\u00A78" + "Teleport charges left: " + stack.getOrCreateChildTag(Main.ModId).getInt("Uses")));
        }
    }

    @SubscribeEvent
    public static void RightClickItemEvent(RightClickItem event){
        ItemStack stack = event.getItemStack();
        boolean IsEnderiteTools = false;
        if(stack.equals(new ItemStack(ModItems.ENDERITE_PICKAXE.get()), false)) IsEnderiteTools = true;
        if(stack.equals(new ItemStack(ModItems.ENDERITE_SWORD.get()), false)) IsEnderiteTools = true;
        if(stack.equals(new ItemStack(ModItems.ENDERITE_HOE.get()), false)) IsEnderiteTools = true;
        if(stack.equals(new ItemStack(ModItems.ENDERITE_SHOVEL.get()), false)) IsEnderiteTools = true;
        if(stack.equals(new ItemStack(ModItems.ENDERITE_AXE.get()), false)) IsEnderiteTools = true;


        if(IsEnderiteTools){
            PlayerEntity Player = event.getPlayer();

            ItemStack OffHand = Player.getHeldItemOffhand();

            CompoundNBT NBTTAGS = Player.getHeldItemMainhand().getOrCreateChildTag(Main.ModId);

            if(OffHand.equals(Items.ENDER_PEARL)){
                for(int i = 0; i < 5; i++){
                    if(OffHand.getCount()>0){
                        OffHand.setCount(OffHand.getCount()-1);
                        NBTTAGS.putInt("Uses", NBTTAGS.getInt("Uses")+1);
                    }
                }
            }
        }
    }

    /*@SubscribeEvent
    public static void onLootTablesLoaded(LootTableLoadEvent event){
        if(event.getName().equals(LootTables.GAMEPLAY_FISHING_TREASURE)){
            final LootPool main = event.getTable().getPool("main");
            if(main != null){
                main.
            }
        }
    }*/

    @SubscribeEvent
    public static void LivingExperienceDropEvent(LivingExperienceDropEvent event){
        ItemStack MainStack = event.getAttackingPlayer().getHeldItemMainhand();
        ItemStack OffStack = event.getAttackingPlayer().getHeldItemOffhand();
        int enchantLevel = 0;
        if(EnchantmentHelper.getEnchantmentLevel(ModEnchants.XPBoost.get(), MainStack)>enchantLevel){
            enchantLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchants.XPBoost.get(), MainStack);
        }
        if(EnchantmentHelper.getEnchantmentLevel(ModEnchants.XPBoost.get(), OffStack)>enchantLevel){
            enchantLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchants.XPBoost.get(), OffStack);
        }
        int Exp = (int) (Math.random() * (((event.getDroppedExperience()*3)*enchantLevel)-(20*enchantLevel)+1)+(20*enchantLevel));
        int MaxExp = (int) ((event.getDroppedExperience())*enchantLevel);
        event.setDroppedExperience(Exp);
        System.out.println("Droped xp from " + event.getEntity().getDisplayName().getString() + " is " + Exp + " out of " + MaxExp);
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

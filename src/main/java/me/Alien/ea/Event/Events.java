package me.Alien.ea.Event;

import me.Alien.ea.Main;
import me.Alien.ea.enchants.KillCounter;
import me.Alien.ea.enchants.Teleport;
import me.Alien.ea.setup.ModBlock;
import me.Alien.ea.setup.ModEnchants;
import me.Alien.ea.setup.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.IRuleTestType;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.List;
import java.util.Random;
import java.util.UUID;

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
    //@OnlyIn(Dist.CLIENT)
    public static void giveGuid(EntityJoinWorldEvent event){

        if (!(event.getEntity() instanceof PlayerEntity))
            return;

        /*event.getEntity().sendMessage(,
                UUID.fromString("40b7dc92-3562-4ffd-9848-86d5327f4b08"));*/
        //((PlayerEntity) event.getEntity()).get
        //((PlayerEntity) event.getEntity()).sendStatusMessage(ITextComponent.getTextComponentOrEmpty
        //        ("This mod has no ingame wiki yet so the wiki exist on the github page link: https://github.com/zaze06/Ender-Additation--forge-/wiki"), false);
        String book = " minecraft:written_book{display:{Name:'{\"text\":\"Ender addition guid\"}',Lore:['{\"text\":\"a guide to ender addition\"}']},title:\"\",author:\"\",pages:['[{\"text\":\"Ender addition is a mod insperid by the nether update\\\\nSo how an item can be use is liked below\\\\n\"},{\"text\":\"Ender debris\",\"color\":\"dark_purple\",\"clickEvent\":{\"action\":\"change_page\",\"value\":\"1\"}},{\"text\":\"\\\\n\"},{\"text\":\" Enderite scrap\",\"color\":\"dark_purple\",\"clickEvent\":{\"action\":\"change_page\",\"value\":\"2\"}},{\"text\":\"\\\\nEnderite ingot\",\"color\":\"dark_purple\",\"clickEvent\":{\"action\":\"change_page\",\"value\":\"3\"}},{\"text\":\"\\\\nTool abilitys\",\"color\":\"dark_purple\",\"clickEvent\":{\"action\":\"change_page\",\"value\":\"4\"}}]','[{\"text\":\"Enderite scrap\\\\nHow to optain\\\\nPut \"},{\"text\":\"ender debris\",\"color\":\"dark_purple\",\"clickEvent\":{\"action\":\"change_page\",\"value\":\"1\"}},{\"text\":\" in a furnace\\\\nUsage\\\\n Combine 4 enderite scrap, 4 diamonds and one netherite scrap to get \"},{\"text\":\"enderite ingot\",\"color\":\"dark_purple\",\"clickEvent\":{\"action\":\"change_page\",\"value\":\"3\"}}]','[{\"text\":\"Enderite ingot\\\\nHow to optain\\\\nCombine 4 \"},{\"text\":\"enderite scrap\",\"color\":\"dark_purple\",\"clickEvent\":{\"action\":\"change_page\",\"value\":\"2\"}},{\"text\":\", 4 diamonds and one netherite scrap\\\\nUsage\\\\nCombine one enderite ingot and a netherite item to get the enderite item\"}]','{\"text\":\"Item abilitys\\\\n Tools\\\\nAll the enderite tools has the ability to teleport the mob or player that is geting damage by an enderite tool\"}']} 1";
        try {
            event.getWorld().getServer().getCommandManager().getDispatcher().execute("give " + event.getEntity().getName().toString() + book, event.getWorld().getServer().getCommandSource());
            
        }catch (Exception e){

        }

        /*ItemStack book = Items.WRITABLE_BOOK.getDefaultInstance();
        CompoundNBT data = book.getOrCreateChildTag("");
        data.putString("title", "Ender Addition");
        data.putString("author", "Alien");
        event.getWorld().addBlockEvent();


        ((PlayerEntity) event.getEntity()).inventory.add(1, book);*/
    }

    @SubscribeEvent
    public static void modifier(ItemAttributeModifierEvent event){
        ItemStack item = event.getItemStack();
        if(EnchantmentHelper.getEnchantmentLevel(ModEnchants.KillCounter.get(), item) > 0){
            if(!event.getSlotType().equals(EquipmentSlotType.MAINHAND)) return;
            CompoundNBT nbt = item.getOrCreateChildTag(Main.ModId);
            if(!nbt.contains("Kills", Constants.NBT.TAG_INT)){
                nbt.putInt("Kills", 0);
            }
            AttributeModifier dmg = new AttributeModifier(EquipmentSlotType.MAINHAND.getName(), nbt.getInt("Kills"), AttributeModifier.Operation.ADDITION);
            if(event.getModifiers().containsValue(dmg)) return;
            event.addModifier(Attributes.ATTACK_DAMAGE, dmg);
        }
    }

    /*@SubscribeEvent
    public static void TickEvent(final ServerPlayerEntity event){
        PlayerInventory inv = event.inventory;
        for(int i = 0; i < inv.getSizeInventory(); i++){
            ItemStack stack = inv.getStackInSlot(i);
            if (!(stack.getItem().equals(new ItemStack(ModItems.ENDERITE_PICKAXE.get())) || stack.getItem().equals(new ItemStack(ModItems.ENDERITE_SWORD.get()))
                    || stack.getItem().equals(new ItemStack(ModItems.ENDERITE_AXE.get())) || stack.getItem().equals(new ItemStack(ModItems.ENDERITE_SHOVEL.get()))
                    || stack.getItem().equals(new ItemStack(ModItems.ENDERITE_HOE.get()))) && (EnchantmentHelper.getEnchantmentLevel(ModEnchants.KillCounter.get(), stack) == 0)){

                if(stack.getChildTag(Main.ModId) != null){
                    stack.removeChildTag(Main.ModId);
                }
                return;
            }
        }
    }*/

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void GenToolTip(final ItemTooltipEvent event){
        ItemStack stack = event.getItemStack();
        if (!(stack.getItem().equals(new ItemStack(ModItems.ENDERITE_PICKAXE.get())) || stack.getItem().equals(new ItemStack(ModItems.ENDERITE_SWORD.get()))
            || stack.getItem().equals(new ItemStack(ModItems.ENDERITE_AXE.get())) || stack.getItem().equals(new ItemStack(ModItems.ENDERITE_SHOVEL.get()))
            || stack.getItem().equals(new ItemStack(ModItems.ENDERITE_HOE.get()))) && (EnchantmentHelper.getEnchantmentLevel(ModEnchants.KillCounter.get(), stack) == 0)){

            if(stack.getChildTag(Main.ModId) != null){
                stack.removeChildTag(Main.ModId);
            }
            return;
        }

        CompoundNBT tag = stack.getOrCreateChildTag(Main.ModId);
        if(tag == null) return;
        List<ITextComponent> Tip = event.getToolTip();
        if(tag.contains("Kills", 3)){
            int Level = EnchantmentHelper.getEnchantmentLevel(ModEnchants.KillCounter.get(), stack);
            if(Level == 0)
                return;
            String Data = "Kills "+tag.getInt("Kills")+"/"+ KillCounter.Max[Level];
            Tip.add(1, new StringTextComponent(Data));
            event.setResult(Event.Result.ALLOW);
        }

        int maxUses = Teleport.getMax(EnchantmentHelper.getEnchantmentLevel(ModEnchants.Teleport.get(), stack));
        if(tag.contains("Uses", 3)){
            Tip.add(2, new StringTextComponent("\u00A78" + "Teleport charges left: " + stack.getOrCreateChildTag(Main.ModId).getInt("Uses") + "/" + maxUses));
        }
    }

    /*@SubscribeEvent
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
    }*/

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
        if(event.getEntity() instanceof PlayerEntity)
            return;
        ItemStack MainStack = event.getAttackingPlayer().getHeldItemMainhand();
        ItemStack OffStack = event.getAttackingPlayer().getHeldItemOffhand();
        int enchantLevel = 0;
        if(EnchantmentHelper.getEnchantmentLevel(ModEnchants.XPBoost.get(), MainStack)>enchantLevel){
            enchantLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchants.XPBoost.get(), MainStack);
        }
        if(EnchantmentHelper.getEnchantmentLevel(ModEnchants.XPBoost.get(), OffStack)>enchantLevel){
            enchantLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchants.XPBoost.get(), OffStack);
        }
        if(enchantLevel == 0)
            return;
        int Exp = (int) (Math.random() * (((event.getDroppedExperience()*3)*enchantLevel)-(20*enchantLevel)+1)+(20*enchantLevel));
        int MaxExp = (int) ((event.getDroppedExperience()*3)*enchantLevel);
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

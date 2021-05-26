package me.Alien.ea.enchants;

import me.Alien.ea.Main;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class KillCounter extends Enchantment {
    public KillCounter() {
        super(Rarity.RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    public static int[] Max = {
            0,
            250,
            500,
            750,
            1000,
            1500
    };

    @Override
    public boolean canVillagerTrade() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity targetE, int level) {
        if(targetE instanceof LivingEntity){
            ItemStack item = user.getHeldItemMainhand();
            CompoundNBT Tag = item.getOrCreateChildTag(Main.ModId);
            if(((LivingEntity) targetE).getHealth() > 0)
                return;
            if(!Tag.contains("Kills", Constants.NBT.TAG_INT)){
                Tag.putInt("Kills", 0);
            }
            Tag.putInt("Kills", (Tag.getInt("Kills")+1));
        }
    }
}

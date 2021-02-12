package me.Alien.ea.enchants;

import me.Alien.ea.lib;
import net.minecraft.block.FenceBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.text.ITextComponent;

public class XPBoost extends Enchantment {

    public XPBoost() {
        super(Rarity.VERY_RARE, EnchantmentType.BREAKABLE, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }

    @Override
    public boolean canGenerateInLoot() {
        return false;
    }

    @Override
    public boolean canVillagerTrade() {
        return false;
    }

    @Override
    public int getMaxLevel() {
        return 7;
    }

    @Override
    public ITextComponent getDisplayName(int level) {
        return ITextComponent.getTextComponentOrEmpty("XP Boost " + lib.IntegerToRomanNumeral(level));
    }

    /*@Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity){
            if(target.isAlive())
                return;
            int explevel = (int) (Math.random() * ((150*level)-(20*level)+1)+(20*level));
            ExperienceOrbEntity ORB = new ExperienceOrbEntity(target.getEntityWorld(), target.getPosX(), target.getPosY(), target.getPosZ(), explevel);
        }
    }*/
}

package me.Alien.ea.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class KillCounter extends Enchantment {
    public KillCounter() {
        super(Rarity.RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean canVillagerTrade() {
        return true;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return super.canApply(stack);
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity targetE, int level) {
        if(targetE instanceof LivingEntity){

        }
    }
}

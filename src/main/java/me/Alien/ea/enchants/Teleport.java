package me.Alien.ea.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class Teleport extends Enchantment {
    protected Teleport() {
        super(Rarity.UNCOMMON, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    public static int[] Max = {
            8,
            14,
            16,
            24
    };
}

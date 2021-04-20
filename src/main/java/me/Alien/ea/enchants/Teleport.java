package me.Alien.ea.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class Teleport extends Enchantment {
    public Teleport() {
        super(Rarity.UNCOMMON, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    static int[] max = {
            5,
            8,
            14,
            16,
            24
    };

    public static int getMax(int in) {
        if((in > max.length)){
            return 5;
        }
        return max[in];
    }
}

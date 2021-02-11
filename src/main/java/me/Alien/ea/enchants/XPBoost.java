package me.Alien.ea.enchants;

import net.minecraft.block.FenceBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class XPBoost extends Enchantment {

    protected XPBoost(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
        super(Rarity.UNCOMMON, EnchantmentType.BREAKABLE, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity){
            if(target.isAlive())
                return;
            //int level = ((LivingEntity) target).getType().getClass().get
            ExperienceOrbEntity ORB = new ExperienceOrbEntity(target.getEntityWorld(), target.getPosX(), target.getPosY(), target.getPosZ(), target.);
        }
    }
}

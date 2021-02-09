package me.Alien.mod.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class TntRain extends Enchantment{

	public TntRain() {
		super(Rarity.COMMON, EnchantmentType.WEAPON, new EquipmentSlotType[] {EquipmentSlotType.MAINHAND});
	}

	@Override
	public void onEntityDamaged(LivingEntity User, Entity TargetE, int Level) {
		if(TargetE instanceof LivingEntity) {
			
			LivingEntity Target = (LivingEntity) TargetE;
			User.addPotionEffect(new EffectInstance(null, Level, Level, true, false));
			TNTEntity TNT = new TNTEntity(EntityType.TNT, Target.getEntityWorld());
			TNT.setFuse(0);
			TNT.setCustomName(User.getDisplayName());
			for(int i = 0; i < (Level*3); i++) {
				for(int j = 0; j < (Level*3); j++) {
					TNT.createSpawnPacket();
				}
			}
		}
	}
	
}

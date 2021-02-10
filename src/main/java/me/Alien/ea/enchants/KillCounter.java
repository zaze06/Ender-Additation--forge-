package me.Alien.ea.enchants;

import me.Alien.ea.Main;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;

public class KillCounter extends Enchantment {
    public KillCounter() {
        super(Rarity.RARE, EnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
    }

    int[] Max = {
            0,
            250,
            500,
            750,
            1000
    };

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
    public ITextComponent getDisplayName(int level) {
        String Name = "Killed 0/"+Max[level];
        return ITextComponent.getTextComponentOrEmpty(Name);
    }

    @Override
    public void onEntityDamaged(LivingEntity user, Entity targetE, int level) {
        if(targetE instanceof LivingEntity){
            ItemStack Item = user.getHeldItemMainhand();
            CompoundNBT Tag = Item.getOrCreateChildTag(Main.ModId);
            if(!Tag.contains("Kills", 3)){
                Tag.putInt("Kills", 0);
            }
            Tag.putInt("Kills", Tag.getInt("Kills")+1);
        }
    }
}

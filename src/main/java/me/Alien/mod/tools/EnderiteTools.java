package me.Alien.mod.tools;

import java.util.List;

import me.Alien.mod.Main;
import me.Alien.mod.setup.ModItemGroup;
import me.Alien.mod.setup.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class EnderiteTools extends Item {
	
	public EnderiteTools(Properties Type) {
		super(Type);
		(new ItemStack(this)).getOrCreateChildTag(Main.ModId).putInt("Uses", 5);;
	}
	
	public static Properties prop = new Item.Properties().group(ModItemGroup.ENDER_ADDITION).isImmuneToFire().maxStackSize(1);

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return 3045;
	}
	
	@Override
	public boolean isDamageable() {
		return true;
	}
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if(!stack.getOrCreateChildTag(Main.ModId).contains("Uses", Constants.NBT.TAG_INT)) {
			
		}
		tooltip.add(new StringTextComponent("Teleport charges left: " + (new ItemStack(this)).getOrCreateChildTag(Main.ModId).getInt("Uses")));
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity targetE) {
		
		if(targetE instanceof LivingEntity) {
			LivingEntity target = (LivingEntity) targetE;
			double minX = target.getPosX()-14;
			double minY = target.getPosX()-14;
			double minZ = target.getPosX()-14;
			
			double maxX = target.getPosX()+14;
			double maxY = target.getPosX()+14;
			double maxZ = target.getPosX()+14;
			
			double X = (Math.random() * (maxX - minX) + minX);
			double Y = (Math.random() * (maxX - minX) + minX);
			double Z = (Math.random() * (maxX - minX) + minX);
			
			if(target.getEntityWorld().isAirBlock(new BlockPos.Mutable(X, Y, Z)))
				target.attemptTeleport(X, Y, Z, true);
		}
		
		return true;
	}

	public class Sword extends SwordItem{

		public Sword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
			super(tier, attackDamageIn, attackSpeedIn, builderIn);
		}

		@Override
		public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
			if(repair.isItemEqual(new ItemStack(ModItems.ENDERITE_INGOT)))
		}
	}

	public class Pickaxe extends PickaxeItem{

		public Pickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
			super(tier, attackDamageIn, attackSpeedIn, builder);
		}


	}
}

package me.Alien.ea.tools;

import java.util.List;

import me.Alien.ea.Main;
import me.Alien.ea.setup.ModItemGroup;
import me.Alien.ea.setup.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class EnderiteTools {

	public static IItemTier ItemTiers = new IItemTier() {

		@Override
		public int getMaxUses() {
			return 3054;
		}

		@Override
		public float getEfficiency() {
			return 10;
		}

		@Override
		public float getAttackDamage() {
			return 10;
		}

		@Override
		public int getHarvestLevel() {
			return 5;
		}

		@Override
		public int getEnchantability() {
			return 6;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return  Ingredient.fromItems(ModItems.ENDERITE_INGOT.get());
		}
	};
	
	public static Item.Properties prop = new Item.Properties().group(ModItemGroup.ENDER_ADDITION).isImmuneToFire();

	public static boolean damage(ItemStack stack, LivingEntity player, LivingEntity targetE){
		CompoundNBT Tag = stack.getOrCreateChildTag(Main.ModId);

		if(Tag.contains("Uses", Constants.NBT.TAG_FLOAT)){
			Tag.putInt("Uses", 5);
		}

		if(!(Tag.getFloat("Uses")>0))
			return true;

		LivingEntity target = targetE;
		double minX = target.getPosX() - 14;
		double minY = target.getPosY() - 14;
		double minZ = target.getPosZ() - 14;

		double maxX = target.getPosX() + 14;
		double maxY = target.getPosY() + 14;
		double maxZ = target.getPosZ() + 14;

		int trays = 0;

		while(trays < 30){
			double X = (Math.random() * (maxX-minX+1)+minZ);
			double Y = (Math.random() * (maxY-minY+1)+minY);
			double Z = (Math.random() * (maxZ-minZ+1)+minZ);

			Vector2f PitchYaw = target.getPitchYaw();

			if (target.getEntityWorld().isAirBlock(new BlockPos.Mutable(X, Y, Z)) && (Y > 0)){
				Vector3d Start = target.getPositionVec();
				target.setLocationAndAngles(X, Y, Z, PitchYaw.x, PitchYaw.y);
				Vector3d End = target.getPositionVec();
				System.out.println("Try no: " + trays + " completed: move to : " + X + " : " + Y + " : " + Z + " : Distance: " + Start.distanceTo(End) + " : Maximum distance: 24");

				//Tag.remove("Uses");
				Tag.putFloat("Uses", Tag.getFloat("Uses")-1);
				break;
			}
			System.out.println("Try no: " + trays + " failed: try to move to : " + X + " : " + Y + " : " + Z);
			trays++;
		}
		return true;
	}


	public static void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (!stack.getOrCreateChildTag(Main.ModId).contains("Uses", Constants.NBT.TAG_FLOAT)) {
			stack.getOrCreateChildTag(Main.ModId).putFloat("Uses", 5);
		}
		//tooltip.add(new StringTextComponent("\u00A78" + "Teleport charges left: " + stack.getOrCreateChildTag(Main.ModId).getInt("Uses")));
	}

	public static class Sword extends SwordItem {

		public Sword() {
			super(EnderiteTools.ItemTiers, 1, 1, EnderiteTools.prop);
			CompoundNBT Tag = (new ItemStack(this)).getOrCreateTag();
			Tag.putFloat("Uses", 5);

		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			return EnderiteTools.damage(stack, attacker, target);
		}

		@Override
		public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			EnderiteTools.addInformation(stack, worldIn, tooltip, flagIn);
		}
	}

	public static class Pickaxe extends PickaxeItem{

		public Pickaxe() {
			super(EnderiteTools.ItemTiers, 1, 1, EnderiteTools.prop);
		}

		@Override
		public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			EnderiteTools.addInformation(stack, worldIn, tooltip, flagIn);
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			return EnderiteTools.damage(stack, attacker, target);
		}
	}

	public static class Axe extends AxeItem{
		public Axe() {
			super(EnderiteTools.ItemTiers, 1, 1, EnderiteTools.prop);
		}

		@Override
		public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			EnderiteTools.addInformation(stack, worldIn, tooltip, flagIn);
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			return EnderiteTools.damage(stack, attacker, target);
		}
	}

	public static class Shovel extends SwordItem{
		public Shovel() {
			super(EnderiteTools.ItemTiers, 1, 1, EnderiteTools.prop);
		}

		@Override
		public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			EnderiteTools.addInformation(stack, worldIn, tooltip, flagIn);
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			return EnderiteTools.damage(stack, attacker, target);
		}
	}

	public static class Hoe extends HoeItem{
		public Hoe() {
			super(EnderiteTools.ItemTiers, 1, 1, EnderiteTools.prop);
		}

		@Override
		public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			EnderiteTools.addInformation(stack, worldIn, tooltip, flagIn);
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			return EnderiteTools.damage(stack, attacker, target);
		}

		public float intToFloat(int in){
			final float in1 = in;
			return in1;}
	}
}

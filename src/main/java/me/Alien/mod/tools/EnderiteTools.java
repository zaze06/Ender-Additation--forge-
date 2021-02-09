package me.Alien.mod.tools;

import java.util.List;
import java.util.Vector;

import me.Alien.mod.Main;
import me.Alien.mod.setup.ModItemGroup;
import me.Alien.mod.setup.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import org.lwjgl.system.CallbackI;

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
		LivingEntity target = targetE;
		double minX = target.getPosX() - 14;
		double minY = target.getPosY() - 14;
		double minZ = target.getPosZ() - 14;

		double maxX = target.getPosX() + 14;
		double maxY = target.getPosY() + 14;
		double maxZ = target.getPosZ() + 14;

		int trays = 0;

		while(trays < 30){//i här bler det fel
			double X = minX + (Math.random() * maxX);
			double Y = minY + (Math.random() * maxY);
			double Z = minZ + (Math.random() * maxZ);

			Vector2f PitchYaw = target.getPitchYaw();

			if (target.getEntityWorld().isAirBlock(new BlockPos.Mutable(X, Y, Z)) && (Y > 0)){
				Vector3d Start = target.getPositionVec();
				target.setLocationAndAngles(X, Y, Z, PitchYaw.x, PitchYaw.y);
				Vector3d End = target.getPositionVec();
				System.out.println("Try no: " + trays + " completed: move to : " + X + " : " + Y + " : " + Z + " : Distance: " + Start.distanceTo(End) + " : Maximum distance: " + );
				break;
			}
			System.out.println("Try no: " + trays + " failed: try to move to : " + X + " : " + Y + " : " + Z);
			trays++;
		}




		return true;
	}

	public static class Sword extends SwordItem {

		public Sword() {
			super(EnderiteTools.ItemTiers, 1, 1, EnderiteTools.prop);
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			return EnderiteTools.damage(stack, attacker, target);
		}

		@Override
		public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
			super.addInformation(stack, worldIn, tooltip, flagIn);
			if (!stack.getOrCreateChildTag(Main.ModId).contains("Uses", Constants.NBT.TAG_INT)) {
				stack.getOrCreateChildTag(Main.ModId).putInt("Uses", 5);
			}
			tooltip.add(new StringTextComponent("Teleport charges left: " + stack.getOrCreateChildTag(Main.ModId).getInt("Uses")));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
			PlayerEntity Player = playerIn;

			ItemStack OffHand = Player.getHeldItem(hand.OFF_HAND);

			CompoundNBT NBTTAGS = Player.getHeldItem(hand.MAIN_HAND).getOrCreateChildTag(Main.ModId);

			if(OffHand.equals(Items.ENDER_PEARL)){
				for(int i = 0; i < 5; i++){
					if(OffHand.getCount()>0){
						OffHand.setCount(OffHand.getCount()-1);
						NBTTAGS.putInt("Uses", NBTTAGS.getInt("Uses")+1);
					}
				}
			}


			return ActionResult.resultSuccess(Player.getHeldItem(hand));
		}
	}

	public class Pickaxe extends PickaxeItem{

		public Pickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
			super(tier, attackDamageIn, attackSpeedIn, builder);
		}


	}
}

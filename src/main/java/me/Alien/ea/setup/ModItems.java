package me.Alien.ea.setup;

import me.Alien.ea.Arrmor.Enderite.ArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fml.RegistryObject;
import me.Alien.ea.tools.EnderiteTools;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
	public static final RegistryObject<Item> ENDERITE_INGOT = Registration.ITEMS.register("enderite_ingot", () -> 
			new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.ENDER_ADDITION).isImmuneToFire()));
	public static final RegistryObject<Item> ENDER_SCRAP = Registration.ITEMS.register("enderite_scrap", () ->
			new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.ENDER_ADDITION).isImmuneToFire()));
	// Tools
	
	public static final RegistryObject<Item> ENDERITE_SWORD = Registration.ITEMS.register("enderite_sword", () ->
			new EnderiteTools.Sword());
	public static final RegistryObject<Item> ENDERITE_PICKAXE = Registration.ITEMS.register("enderite_pickaxe", () ->
			new EnderiteTools.Pickaxe());
	public static final RegistryObject<Item> ENDERITE_AXE = Registration.ITEMS.register("enderite_axe", () ->
			new EnderiteTools.Axe());
	public static final RegistryObject<Item> ENDERITE_SHOVEL = Registration.ITEMS.register("enderite_shovel", () ->
			new EnderiteTools.Shovel());
	public static final RegistryObject<Item> ENDERITE_HOE = Registration.ITEMS.register("enderite_hoe", () ->
			new EnderiteTools.Hoe());

	// Armor

	public static final RegistryObject<ArmorItem> ENDERITE_HELMET = Registration.ITEMS.register("enderite_helmet", () ->
			new ArmorItem(ArmorMaterial.ARMOR_MATERIAL, EquipmentSlotType.HEAD, new Item.Properties().group(ModItemGroup.ENDER_ADDITION)));
	public static final RegistryObject<ArmorItem> ENDERITE_CHESTPLATE = Registration.ITEMS.register("enderite_chestplate", () ->
			new ArmorItem(ArmorMaterial.ARMOR_MATERIAL, EquipmentSlotType.CHEST, new Item.Properties().group(ModItemGroup.ENDER_ADDITION)));
	public static final RegistryObject<ArmorItem> ENDERITE_LEGGINGS = Registration.ITEMS.register("enderite_leggings", () ->
			new ArmorItem(ArmorMaterial.ARMOR_MATERIAL, EquipmentSlotType.LEGS, new Item.Properties().group(ModItemGroup.ENDER_ADDITION)));
	public static final RegistryObject<ArmorItem> ENDERITE_BOOTS = Registration.ITEMS.register("enderite_boots", () ->
			new ArmorItem(ArmorMaterial.ARMOR_MATERIAL, EquipmentSlotType.FEET, new Item.Properties().group(ModItemGroup.ENDER_ADDITION)));

	static void register() {
	}
}

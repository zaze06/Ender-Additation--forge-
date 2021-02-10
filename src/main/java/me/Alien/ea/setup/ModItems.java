package me.Alien.ea.setup;

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

	static void register() {
	}
}

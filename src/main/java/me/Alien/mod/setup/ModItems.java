package me.Alien.mod.setup;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import me.Alien.mod.tools.EnderiteTools;

public class ModItems {
	public static final RegistryObject<Item> ENDERITE_INGOT = Registration.ITEMS.register("enderite_ingot", () -> 
			new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.ENDER_ADDITION).isImmuneToFire()));
	public static final RegistryObject<Item> ENDER_SCRAP = Registration.ITEMS.register("enderite_scrap", () ->
			new Item(new Item.Properties().maxStackSize(64).group(ModItemGroup.ENDER_ADDITION).isImmuneToFire()));
	// Tools
	
	public static final RegistryObject<Item> ENDERITE_SWORD = Registration.ITEMS.register("enderite_sword", () ->
			new EnderiteTools(null));
	
	
	static void register() {}
}

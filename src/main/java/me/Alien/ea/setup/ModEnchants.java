package me.Alien.ea.setup;

import me.Alien.ea.enchants.KillCounter;
import me.Alien.ea.enchants.Teleport;
import me.Alien.ea.enchants.TntRain;
import me.Alien.ea.enchants.XPBoost;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;

public class ModEnchants {
	
	//public static final RegistryObject<Enchantment> TNTRain = Registration.ENCHANT.register("tnt_rain", () ->
	//		new TntRain());
	public static final RegistryObject<Enchantment> KillCounter = Registration.ENCHANT.register("kill_counter", () ->
			new KillCounter());
	public static final RegistryObject<Enchantment> XPBoost = Registration.ENCHANT.register("xp_boost", () ->
			new XPBoost());
	public static final RegistryObject<Enchantment> Teleport = Registration.ENCHANT.register("teleport", () ->
			new Teleport());
	
	public static void register() {}
}

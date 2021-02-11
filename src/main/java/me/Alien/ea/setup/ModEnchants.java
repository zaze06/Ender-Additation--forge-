package me.Alien.ea.setup;

import me.Alien.ea.enchants.KillCounter;
import me.Alien.ea.enchants.TntRain;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;

public class ModEnchants {
	
	//public static final RegistryObject<Enchantment> TNTRain = Registration.ENCHANT.register("tnt_rain", () ->
	//		new TntRain());
	public static final RegistryObject<Enchantment> KillCounter = Registration.ENCHANT.register("kill_counter", () ->
			new KillCounter());
	
	public static void register() {}
}

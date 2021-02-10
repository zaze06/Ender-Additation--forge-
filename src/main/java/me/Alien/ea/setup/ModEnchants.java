package me.Alien.ea.setup;

import me.Alien.ea.enchants.TntRain;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;

public class ModEnchants {
	
	public static final RegistryObject<Enchantment> TNTRain = Registration.ENCHANT.register("tnt_rain", () -> 
			new TntRain());
	
	public static void register() {}
}

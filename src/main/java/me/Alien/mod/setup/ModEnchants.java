package me.Alien.mod.setup;

import me.Alien.mod.enchants.TntRain;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.RegistryObject;

public class ModEnchants {
	
	public static final RegistryObject<Enchantment> TNTRain = Registration.ENCHANT.register("tnt_rain", () -> 
			new TntRain());
	
	public static void register() {}
}

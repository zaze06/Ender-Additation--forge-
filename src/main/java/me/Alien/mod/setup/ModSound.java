package me.Alien.mod.setup;

import java.util.function.Supplier;

import me.Alien.mod.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class ModSound {

	public static final RegistryObject<SoundEvent> ENDER_DEBRI_BREAK = Registration.SOUND.register("ender_debri_break", () -> new SoundEvent(new ResourceLocation(Main.ModId, "block.mine.ender_debri")));
	public static final RegistryObject<SoundEvent> ENDER_DEBRI_HIT = Registration.SOUND.register("ender_debri_hit", () -> new SoundEvent(new ResourceLocation(Main.ModId, "block.mine.ender_debri")));
	public static final RegistryObject<SoundEvent> ENDER_DEBRI_PLACE = Registration.SOUND.register("ender_debri_place", () -> new SoundEvent(new ResourceLocation(Main.ModId, "block.mine.ender_debri")));
	public static final RegistryObject<SoundEvent> ENDER_DEBRI_STEP = Registration.SOUND.register("ender_debri_step", () -> new SoundEvent(new ResourceLocation(Main.ModId, "block.mine.ender_debri")));
	public static final RegistryObject<SoundEvent> ENDER_DEBRI_FALL = Registration.SOUND.register("ender_debri_fall", () -> new SoundEvent(new ResourceLocation(Main.ModId, "block.mine.ender_debri")));
	
	public static void register() {}
	
}

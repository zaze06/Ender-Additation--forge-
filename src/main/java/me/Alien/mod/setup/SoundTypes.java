package me.Alien.mod.setup;

import net.minecraft.block.SoundType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;

public class SoundTypes extends SoundType{

	public SoundTypes(float p_i46679_1_, float p_i46679_2_, SoundEvent p_i46679_3_, SoundEvent p_i46679_4_,
			SoundEvent p_i46679_5_, SoundEvent p_i46679_6_, SoundEvent p_i46679_7_) {
		super(p_i46679_1_, p_i46679_2_, p_i46679_3_, p_i46679_4_, p_i46679_5_, p_i46679_6_, p_i46679_7_);
	}
	
	public static final SoundType ENDER_DEBRI = new ForgeSoundType(1, 1, ModSound.ENDER_DEBRI_BREAK, ModSound.ENDER_DEBRI_STEP, ModSound.ENDER_DEBRI_PLACE, ModSound.ENDER_DEBRI_HIT, ModSound.ENDER_DEBRI_FALL);
}

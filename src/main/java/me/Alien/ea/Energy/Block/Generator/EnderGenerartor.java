package me.Alien.ea.Energy.Block.Generator;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnderGenerartor extends Block {

    public EnderGenerartor(Properties properties) {
        super(Properties.create(Material.IRON)
                .sound(SoundType.ANVIL)
                .hardnessAndResistance(7, 5));
    }
}

package me.Alien.mod.setup;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModBlock {
	public static final RegistryObject<Block> ENDER_DEBRI = register("ender_debri", () ->
		new Block(AbstractBlock.Properties
				.create(Material.ROCK)
				.hardnessAndResistance(30, 1200)
				.harvestLevel(4)
				.sound(SoundTypes.ENDER_DEBRI)),
		new Item.Properties()
			.isImmuneToFire()
			.group(ItemGroup.BUILDING_BLOCKS)
	);
	//public static 
	
	public static void register() {}
	
	private static <T extends Block> RegistryObject<T> registerNoItem(String Name, Supplier<T> Block) {
		
		return Registration.BLOCKS.register(Name, Block);
	}
	
	private static <T extends Block> RegistryObject<T> register(String Name, Supplier<T> Block, Properties ItemProperties){
		RegistryObject<T> ret = registerNoItem(Name, Block);
		Registration.ITEMS.register(Name, () -> new BlockItem(ret.get(), ItemProperties));
		return ret;
	}
}

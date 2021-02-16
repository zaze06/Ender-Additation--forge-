package me.Alien.ea.setup;

import me.Alien.ea.Energy.Block.BlockReg;
import me.Alien.ea.Main;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.ModId);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.ModId);
	public static final DeferredRegister<SoundEvent> SOUND = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.ModId);
	public static final DeferredRegister<Enchantment> ENCHANT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Main.ModId);
	
	public static void register() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		SOUND.register(modEventBus);
		ENCHANT.register(modEventBus);
		
		ModItems.register();
		ModBlock.register();
		ModSound.register();
		ModEnchants.register();
		BlockReg.register();
	}
	
	
}

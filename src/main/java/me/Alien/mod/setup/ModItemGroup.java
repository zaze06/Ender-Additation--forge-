package me.Alien.mod.setup;

import com.google.common.base.Supplier;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup extends ItemGroup{
	
	private Supplier<ItemStack> displayStack;
	
	private ModItemGroup(String label, Supplier<ItemStack> displayStack) {
        super(label);
        this.displayStack = displayStack;
    }
	
	public static final ModItemGroup ENDER_ADDITION = new ModItemGroup("Ender addition", () -> new ItemStack(ModItems.ENDERITE_INGOT.get()));
	
	@Override
    public ItemStack createIcon() { return displayStack.get(); }
}

package com.example.testmod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static class ModCreativeTab extends CreativeModeTab {


        private ModCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ENDER_INGOT.get());
        }
    }
    public static final ModCreativeTab tab = new ModCreativeTab(CreativeModeTab.TABS.length, "testmod");

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestModMain.MODID);

    public static final RegistryObject<Item> ENDER_INGOT = ITEMS.register("ender_ingot", ()->new Item(new Item.Properties().tab(tab)));



}

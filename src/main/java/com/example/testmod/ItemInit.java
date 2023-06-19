package com.example.testmod;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

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
    public enum ModItemTier implements Tier{

        ENDER_INGOT(4,1600, 8.5F, 5F, 15,  ()->{
            return Ingredient.of(ItemInit.ENDER_INGOT.get());
        });

        private final int level;
        private final int uses;
        private final float speed;
        private final float damage;
        private final int enchantmentValue;
        private final LazyLoadedValue<Ingredient> repairIngredient;

        ModItemTier(int level, int durability, float miningSpeed, float damage, int enchantability, Supplier<Ingredient> repairIngredient) {
            this.level = level;
            this.uses = durability;
            this.speed = miningSpeed;
            this.damage = damage;
            this.enchantmentValue = enchantability;
            this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
        }

        @Override
        public int getUses() {
            return this.uses;
        }

        @Override
        public float getSpeed() {
            return this.speed;
        }

        @Override
        public float getAttackDamageBonus() {
            return this.damage;
        }

        @Override
        public int getLevel() {
            return this.level;
        }

        @Override
        public int getEnchantmentValue() {
            return this.enchantmentValue;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return this.repairIngredient.get();
        }
    }
    public static final ModCreativeTab tab = new ModCreativeTab(CreativeModeTab.TABS.length, "testmod");

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestModMain.MODID);
    public static final RegistryObject<Item> ENDER_INGOT = ITEMS.register("ender_ingot", ()->new Item(new Item.Properties().tab(tab)));
    public static final RegistryObject<Item> ENDER_PICK = ITEMS.register("ender_pickaxe",
            () -> new PickaxeItem(ModItemTier.ENDER_INGOT,1, -1.0F, new Item.Properties().tab(tab)));



}

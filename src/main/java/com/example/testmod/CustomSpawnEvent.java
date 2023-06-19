package com.example.testmod;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.Random;

import static com.example.testmod.TestModMain.LOGGER;
import static com.example.testmod.TestModMain.RAND;

public class CustomSpawnEvent {

    @SubscribeEvent
    public void OnStickClick(PlayerInteractEvent.RightClickBlock e){
        Level world = (Level)e.getLevel();

        if(world.isClientSide()){
            return;
        }
        if(e.getHand() == InteractionHand.OFF_HAND){
            return;
        }

        if(e.getItemStack().getItem() == Items.STICK){
            BlockPos pos = e.getPos();
            pos = pos.offset(0,2,0);

            Skeleton bob = new Skeleton(EntityType.SKELETON, world);
            bob.setCustomName(Component.literal("Bob The Skeleton"));
            bob.setPos(pos.getX(), pos.getY(), pos.getZ());

            world.addFreshEntity(bob);

        }

    }
    @SubscribeEvent
    public void onBobSpawn(EntityJoinLevelEvent e){
        if(e.getLevel().isClientSide()){
            return;
        }

        if(!(e.getEntity() instanceof Skeleton skele)){
            return;
        }
        Component name =  skele.getCustomName();
        if(name == null){
            return;
        }
        if(name.equals(Component.literal("Bob The Skeleton"))){
            skele.canPickUpLoot();


            ArrayList<ItemStack> helmets = new ArrayList<>();
            helmets.add(new ItemStack(Items.DIAMOND_HELMET));
            helmets.add(new ItemStack(Items.LEATHER_HELMET));
            helmets.add(new ItemStack(Items.IRON_HELMET));
            LOGGER.info(helmets.toString());


            skele.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
            Integer num = RAND.nextInt(3);
            skele.setItemSlot(EquipmentSlot.HEAD, helmets.get(num));
            LOGGER.info(num.toString());
            skele.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
            skele.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
        }

    }
}

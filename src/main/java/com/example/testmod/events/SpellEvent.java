package com.example.testmod.events;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class SpellEvent {
    @SubscribeEvent
    public void spellCast(ServerChatEvent.Submitted e){

        if(e.getRawText().equalsIgnoreCase("lol")){
            ItemStack it = new ItemStack(Items.BUCKET, 1);

            e.getPlayer().getInventory().add(it);
        }
    }

    @SubscribeEvent
    public void smash(BlockEvent.BreakEvent e){
        if(e.getPlayer().getItemInHand(InteractionHand.MAIN_HAND).getItem() == Items.BEEF){
            e.getPlayer().sendSystemMessage(Component.literal("ME SMASH PUNY BLOCK ").append( e.getState().getBlock().getName()));

            Level world = (Level)e.getLevel();
            BlockPos pos = e.getPos();

            Random ran = new Random();

            world.explode( e.getPlayer(), pos.getX(),pos.getY(), pos.getZ(), ran.nextInt(16),Explosion.BlockInteraction.BREAK);
        }


    }

}

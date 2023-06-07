package com.example.testmod;


import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//@Mod.EventBusSubscriber(modid=TestModMain.MODID)
public class JumpEvent {
    /*
    @SubscribeEvent
    public static void onLivingJump(LivingEvent.LivingJumpEvent e){

        if(e.getEntity() instanceof Player player){

            player.sendSystemMessage(Component.literal(player.getName().getString() + "Jumped!"));

        }

    }*/
    @SubscribeEvent
    public void onLivingJump(LivingEvent.LivingJumpEvent e){

        if(e.getEntity() instanceof Player player){

            player.sendSystemMessage(Component.literal(player.getName().getString() + " Jumped!"));

        }

    }
}

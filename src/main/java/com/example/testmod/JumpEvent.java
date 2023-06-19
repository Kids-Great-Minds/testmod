package com.example.testmod;


import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class JumpEvent {

    @SubscribeEvent
    public void onLivingJump(LivingEvent.LivingJumpEvent e){

        if(e.getEntity() instanceof Player player){
            if(!player.getLevel().isClientSide()){
                
                player.sendSystemMessage(Component.literal(player.getName().getString() + " Jumped!"));


            }


        }

    }

}

package com.example.testmod.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static com.example.testmod.TestModMain.LOGGER;

public class SuperJump {
    @SubscribeEvent
    public void superJumpEvent(LivingEvent.LivingJumpEvent e){
        if(!(e.getEntity() instanceof Player player)){
            return;

        }
        Vec3 temp = player.getDeltaMovement();
        player.setDeltaMovement(temp.x, temp.y*5, temp.z);


    }

    @SubscribeEvent
    public void slowFall(LivingEvent e){
        if(!(e.getEntity() instanceof Player player)){
            return;
        }
        if(player.isOnGround()){
            return;
        }
        if(player.isShiftKeyDown()){
            Vec3 temp = player.getDeltaMovement();
            player.setDeltaMovement(temp.x, -.5, temp.z);
            player.fallDistance = 0;
        }

    }
}

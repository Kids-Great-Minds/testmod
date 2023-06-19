package com.example.testmod.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DragonEggBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class DragonEvent {
    @SubscribeEvent
    public void dragonSpawn(BlockEvent.EntityPlaceEvent e){
        if(! (e.getEntity() instanceof Player)){
            return;
        }

        BlockState placed = e.getPlacedBlock();
        Block block = placed.getBlock();


        if(block instanceof DragonEggBlock){
            EnderDragon dragon = new EnderDragon(EntityType.ENDER_DRAGON, e.getEntity().level);
            BlockPos bp = e.getPos();
            dragon.setPos(bp.getX(), bp.getY()+5, bp.getZ());

            e.getEntity().level.addFreshEntity(dragon);

            e.getEntity().level.setBlock(bp, Blocks.AIR.defaultBlockState(), 0);

        }

    }
}

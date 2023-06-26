package com.example.testmod.blocks;

import com.example.testmod.TestModMain;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class EnderBlock extends Block {
    public EnderBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE).lightLevel((temp)->{return 15;}));
    }

    @Override
    public void setPlacedBy(Level p_49847_, BlockPos p_49848_, BlockState p_49849_, @Nullable LivingEntity p_49850_, ItemStack p_49851_) {
        super.setPlacedBy(p_49847_, p_49848_, p_49849_, p_49850_, p_49851_);
    }

    @Override
    public InteractionResult use(BlockState p_60503_, Level world, BlockPos pos, Player player, InteractionHand p_60507_, BlockHitResult p_60508_) {

        LightningBolt lb = EntityType.LIGHTNING_BOLT.create(world);
        lb.moveTo(Vec3.atBottomCenterOf(pos));
        lb.setCause(null);
        world.addFreshEntity(lb);
        
        return super.use(p_60503_, world, pos, player, p_60507_, p_60508_);
    }
}

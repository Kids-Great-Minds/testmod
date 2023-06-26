package com.example.testmod.items;

import com.example.testmod.TestModMain;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import static com.example.testmod.ItemInit.TAB;

public class EnderIngot extends Item {

    public EnderIngot() {
        super(new Item.Properties().tab(TAB));
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand p_41434_) {



        LightningBolt lb = EntityType .LIGHTNING_BOLT.create(world);
        lb.moveTo(player.position());
        lb.setCause(null);
        world.addFreshEntity(lb);
        return super.use(world, player, p_41434_);
    }

}

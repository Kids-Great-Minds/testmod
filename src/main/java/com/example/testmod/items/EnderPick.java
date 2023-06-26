package com.example.testmod.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class EnderPick extends PickaxeItem {
    public EnderPick(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        HitResult hit = player.pick(20,0,false);
        Vec3 pos = hit.getLocation();

        LightningBolt lb = EntityType.LIGHTNING_BOLT.create(world);
        lb.moveTo(pos);
        lb.setCause(null);
        world.addFreshEntity(lb);


        return super.use(world, player, hand);
    }
}

package com.cimdy.lesshurtparticle.event;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class LivingEntityEvent {
    public static void LivingHurtEvent(LivingDamageEvent event){
        LivingEntity livingEntity = event.getEntity();
        if(event.getSource().getEntity() instanceof Player){
            if(!livingEntity.level().isClientSide){
                float damage = Math.min(event.getAmount(), livingEntity.getMaxHealth());
                //玩家造成伤害使其每损失20%最大生命的血量产生一个红心
                int f = (int) (damage / livingEntity.getMaxHealth() * 5);
                f = Math.max(f, 1);
                ServerLevel serverLevel = (ServerLevel) livingEntity.level();
                serverLevel.sendParticles(
                        ParticleTypes.DAMAGE_INDICATOR,
                        livingEntity.getX(), livingEntity.getY(0.5), livingEntity.getZ(),
                        f, 0.1, 0.0, 0.1, 0.2);
            }
        }
    }
}

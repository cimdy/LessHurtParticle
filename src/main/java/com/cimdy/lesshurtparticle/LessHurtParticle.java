package com.cimdy.lesshurtparticle;

import com.cimdy.lesshurtparticle.event.LivingEntityEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(LessHurtParticle.MODID)
public class LessHurtParticle
{
    public static final String MODID = "less_hurt_particle";

    public LessHurtParticle(IEventBus modEventBus, ModContainer modContainer)
    {
        NeoForge.EVENT_BUS.addListener(LivingEntityEvent::LivingHurtEvent);
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

}

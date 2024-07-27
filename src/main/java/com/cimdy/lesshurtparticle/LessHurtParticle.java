package com.cimdy.lesshurtparticle;

import com.cimdy.lesshurtparticle.event.LivingEntityEvent;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

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

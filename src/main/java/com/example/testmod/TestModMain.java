package com.example.testmod;

import com.example.testmod.events.*;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Random;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestModMain.MODID)
public class TestModMain
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "testmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public static final Random RAND = new Random();
    public TestModMain()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        modEventBus.addListener(this::commonSetup);
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(new JumpEvent());
        MinecraftForge.EVENT_BUS.register(new DragonEvent());
        MinecraftForge.EVENT_BUS.register(new SpellEvent());
        MinecraftForge.EVENT_BUS.register(new CustomSpawnEvent());
        MinecraftForge.EVENT_BUS.register(new SuperJump());


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


}

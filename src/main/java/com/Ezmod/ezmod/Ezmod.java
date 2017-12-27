package com.Ezmod.ezmod;

import com.Ezmod.ezmod.init.ModItems;
import com.Ezmod.ezmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = References.MODID, version = References.VERSION, name = References.NAME, acceptedMinecraftVersions = References.ACCEPTED_VERSION)
public class Ezmod {

    @Mod.Instance
    public static Ezmod Instance;


    public String getVersion() {
        return References.VERSION;
    }

    public void load() {

    }

    @SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS, modId = References.MODID)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preinit(FMLPreInitializationEvent event) {
        System.out.println("-- Starting Ezmod Pre-Initialisation");
        ModItems.init();
        System.out.println("-- Ending   Ezmod Pre-Initialisation");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        System.out.println("-- Starting Ezmod Initialisation");
        proxy.init();
        System.out.println("-- Ending   Ezmod Initialisation");

    }

    @Mod.EventHandler
    public static void postinit(FMLPostInitializationEvent event) {
        System.out.println("-- Starting Ezmod Post-Initialisation");
        System.out.println("-- Ending   Ezmod Post-Initialisation");
    }
}

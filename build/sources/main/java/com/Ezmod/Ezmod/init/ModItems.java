package com.Ezmod.Ezmod.init;

import com.Ezmod.Ezmod.Items.ItemCheese;
import com.Ezmod.Ezmod.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;


@GameRegistry.ObjectHolder(References.MODID)
@Mod.EventBusSubscriber
public class ModItems {

    //#Members
    //Item Instance

    private static ItemCheese cheese = new ItemCheese();

    //Item List
    public static List<Item> Items;




    //#Member Functions
    //@
    @SubscribeEvent
    public static void register(final RegistryEvent.Register<Item> event) {
        //_addInItemsList();
        final IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(cheese);
    }


    //#public
    public static void init() {
    }


    public static void RegisterRenders() {
        _addInItemsList();
        for (Item itm : Items) {
            _registerRender(itm);
        }
    }

    //#Private

    private static void _addInItemsList() {
        init();
        Items.clear();
        Items.add(cheese);
    }

    private static void _registerRender(Item item) {
        System.out.println("---->[" + References.MODID + ":" + item.getUnlocalizedName().substring(5));
        ModelResourceLocation Rloc = new ModelResourceLocation(References.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, Rloc);
    }
}

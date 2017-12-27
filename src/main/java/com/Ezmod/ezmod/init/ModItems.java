package com.Ezmod.ezmod.init;

import com.Ezmod.ezmod.Items.ItemCheese;
import com.Ezmod.ezmod.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;


@GameRegistry.ObjectHolder(References.MODID)
@Mod.EventBusSubscriber
public class ModItems {

    //#Members
    //Item Instance

    private static ItemCheese cheese;

    //Item List
    public static List<Item> Items = new ArrayList<>();

    //Members
    static Boolean InitItemFlag = false;
    static Boolean InitListItemFlag = false;



    //#Member Functions
    //@
    @SubscribeEvent
    public static void register(final RegistryEvent.Register<Item> event) {
        _addInItemsList();
        final IForgeRegistry<Item> registry = event.getRegistry();
        for (Item itm : Items) {
            registry.register(itm);
        }
    }


    //#public
    public static void init() {
        _initItems();
        _addInItemsList();
        Items = new ArrayList<>();
    }


    @SubscribeEvent
    public static void RegisterRenders(ModelRegistryEvent event) {
        for (Item itm : Items) {
            ModelLoader.setCustomModelResourceLocation(itm, 0, new ModelResourceLocation(itm.getRegistryName(), "inventory"));
            //_registerRender(itm);
        }
    }

    //#Private

    private static void _initItems() {
        if (InitItemFlag == false) {
            InitItemFlag = true;

            cheese = new ItemCheese();
        }
    }

    private static void _addInItemsList() {
        if (InitListItemFlag == false) {
            Items.add(cheese);
        }
    }

    private static void _registerRender(Item item) {
        ModelResourceLocation Rloc = new ModelResourceLocation(item.getRegistryName(), "inventory");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, Rloc);
    }
}

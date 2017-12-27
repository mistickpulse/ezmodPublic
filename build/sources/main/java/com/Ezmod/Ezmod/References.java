package com.Ezmod.Ezmod;

public class References {
    //Confs
    public static final String MODID = "ezmod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Ezmod";
    public static final String ACCEPTED_VERSION = "[1.12]";

    //Proxy
    public static final String CLIENT_PROXY_CLASS = "com.Ezmod.Ezmod.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.Ezmod.Ezmod.proxy.ServerProxy";


    //Enum Items
    public static enum EzmodItems {
        CHEESE("Cheese", "ItemCheese");

        private String unlocalizedName;
        private String registryName;

        EzmodItems(String uName, String rName) {
            unlocalizedName = uName;
            registryName = rName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }

        public String getRegistryName() {
            return registryName;
        }
    }
}

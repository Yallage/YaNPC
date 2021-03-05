package com.nanokylin.mc.yanpc;

import com.nanokylin.mc.yanpc.config.ConfigHandler;
import com.nanokylin.mc.yanpc.controller.NPCController;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main Class
 *
 * @author Hanbings
 */
public final class YaNPC extends JavaPlugin {

    // 获取实例
    static YaNPC instance;

    public YaNPC() {
        instance = this;
    }

    public static YaNPC getInstance() {
        return instance;
    }

    // 版本号 获取NMS用
    static String version = "v1_16_R4";

    /**
     * -----------
     * onEnable -> ConfigHandler Read Config To Memory
     * ConfigHandler Push Config To NPCController (Main Controller)
     * Main Controller Boot Config Load To NPCLoader Class
     * NPCLoader Loaded Will Return Controller Add To Loader Map (Mao<String name,NPCLoader npcLoader>)
     * NPCController (Main Controller) Push Task To Task Controller
     * Task Will Load AI && Animation From Config Or Script
     * -----------
     */
    @Override
    public void onEnable() {
        // 加载配置文件
        ConfigHandler configHandler = new ConfigHandler(this);
        // 传入控制器
        NPCController npcController = new NPCController(configHandler.getConfig());
        // 干翻NMS
        version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        this.getLogger().info(ChatColor.GREEN + "Loaded Done. Hello World !");
    }

    // 关门造车
    @Override
    public void onDisable() {
        this.getLogger().info(ChatColor.GREEN + "Disable Now , Bye~");
    }

    // 获取nms类
    public static Class getNmsClass(String name) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + version + "." + name);
    }

    // 获取craftbukkit类
    public static Class getCbClass(String name) throws ClassNotFoundException {
        return Class.forName("org.bukkit.craftbukkit." + version + "." + name);
    }
}

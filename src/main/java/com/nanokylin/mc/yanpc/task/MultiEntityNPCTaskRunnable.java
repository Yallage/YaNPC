package com.nanokylin.mc.yanpc.task;

import com.nanokylin.mc.yanpc.controller.MultiEntityNPCLoader;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Map;

public class MultiEntityNPCTaskRunnable extends Thread {
    Map<String, MultiEntityNPCLoader> multiEntityNPCLoaderMap;

    public MultiEntityNPCTaskRunnable(Map<String, MultiEntityNPCLoader> multiEntityNPCLoaderMap) {
        this.multiEntityNPCLoaderMap = multiEntityNPCLoaderMap;
    }

    @Override
    public void run() {
        Bukkit.getServer().getLogger().info(ChatColor.GREEN + "还没写");
    }
}

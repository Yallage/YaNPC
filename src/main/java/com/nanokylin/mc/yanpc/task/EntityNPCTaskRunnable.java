package com.nanokylin.mc.yanpc.task;

import com.nanokylin.mc.yanpc.common.model.NPC;
import com.nanokylin.mc.yanpc.controller.EntityNPCLoader;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 临时的设计
 * 暂用于加载NPC到具体的地图中
 */
public class EntityNPCTaskRunnable extends Thread {
    Map<String, EntityNPCLoader> entityNPCLoaderMap;

    public EntityNPCTaskRunnable(Map<String, EntityNPCLoader> entityNPCLoaderMap) {
        this.entityNPCLoaderMap = entityNPCLoaderMap;
    }

    @Override
    public void run() {
        for (Map.Entry<String, EntityNPCLoader> entry : entityNPCLoaderMap.entrySet()) {
            NPC npc = entry.getValue().getNPC();
            ArmorStand stand = Objects.requireNonNull(npc.getLocation().getWorld()).spawn(npc.getLocation(), ArmorStand.class);
            stand.setCustomName(npc.getDisplay());
            stand.setCustomNameVisible(true);
            stand.setHelmet(npc.getItemStack());
            stand.setVisible(true);
        }
    }
}

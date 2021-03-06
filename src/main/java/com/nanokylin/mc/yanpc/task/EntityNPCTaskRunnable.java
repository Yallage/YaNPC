package com.nanokylin.mc.yanpc.task;

import com.nanokylin.mc.yanpc.common.model.NPC;
import com.nanokylin.mc.yanpc.controller.EntityNPCLoader;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 临时的设计
 * 暂用于加载NPC到具体的地图中
 */
public class EntityNPCTaskRunnable extends BukkitRunnable {
    List<EntityNPCLoader> entityNPCLoaderTasks = new ArrayList<>();

    public EntityNPCTaskRunnable() {
    }

    public void addEntityLoaderTask(EntityNPCLoader entityNPCLoader) {
        entityNPCLoaderTasks.add(entityNPCLoader);
    }

    public EntityNPCTaskRunnable(List<EntityNPCLoader> entityNPCLoaderTasks) {
        this.entityNPCLoaderTasks = entityNPCLoaderTasks;
    }

    @SuppressWarnings("ALL")
    @Override
    public void run() {
        // 大家都喜欢的rbq
        NPC npc = new NPC();
        for (int i = 0; i < entityNPCLoaderTasks.size(); i++) {
            npc = entityNPCLoaderTasks.get(i).getNPC();
            ArmorStand stand = Objects.requireNonNull(npc.getLocation().getWorld()).spawn(npc.getLocation(), ArmorStand.class);
            stand.setCustomName(npc.getDisplay());
            stand.setCustomNameVisible(true);
            stand.setHelmet(npc.getItemStack());
            stand.setVisible(true);
            entityNPCLoaderTasks.remove(i);
        }
    }
}

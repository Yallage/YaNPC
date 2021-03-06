package com.nanokylin.mc.yanpc.task;

import com.nanokylin.mc.yanpc.common.model.NPC;
import com.nanokylin.mc.yanpc.controller.MultiEntityNPCLoader;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MultiEntityNPCTaskRunnable extends BukkitRunnable {
    List<MultiEntityNPCLoader> multiEntityNPCLoaderTasks = new ArrayList<>();

    public MultiEntityNPCTaskRunnable(MultiEntityNPCLoader multiEntityNPCLoader) {
        this.multiEntityNPCLoaderTasks.add(multiEntityNPCLoader);
    }

    public MultiEntityNPCTaskRunnable(List<MultiEntityNPCLoader> multiEntityNPCLoaderTasks) {
        this.multiEntityNPCLoaderTasks = multiEntityNPCLoaderTasks;
    }

    @SuppressWarnings("ALL")
    @Override
    public void run() {
        // 大家都喜欢的肉便器
        List<NPC> rbq = new ArrayList<>();
        NPC npc = new NPC();
        // RUA 就用for好啦 要计数用增强还是蛮麻烦的
        for (int i = 0; i < multiEntityNPCLoaderTasks.size(); i++) {
            npc = multiEntityNPCLoaderTasks.get(i).getNPC();
            ArmorStand stand = Objects.requireNonNull(npc.getLocation().getWorld()).spawn(npc.getLocation(), ArmorStand.class);
            stand.setCustomName(npc.getDisplay());
            stand.setCustomNameVisible(true);
            stand.setHelmet(npc.getItemStack());
            stand.setVisible(true);
            rbq = multiEntityNPCLoaderTasks.get(i).getAdditionNPC();
            for (int j = 0; j < rbq.size(); j++) {
                stand = Objects.requireNonNull(npc.getLocation().getWorld()).spawn(npc.getLocation(), ArmorStand.class);
                stand.setCustomName(npc.getDisplay());
                stand.setCustomNameVisible(true);
                stand.setHelmet(npc.getItemStack());
                stand.setVisible(true);
            }
            multiEntityNPCLoaderTasks.remove(i);
        }
    }
}

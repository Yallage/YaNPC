package com.nanokylin.mc.yanpc.controller;

import com.nanokylin.mc.yanpc.common.model.NPC;
import com.nanokylin.mc.yanpc.controller.interfaces.IMultiEntityNPCLoader;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

//TODO: 转换坐标
public class MultiEntityNPCLoader implements IMultiEntityNPCLoader {
    NPC npc;
    List<NPC> additions = new ArrayList<>();

    @Override
    public void addAdditionNPC(NPC npc) {
        // 处理相对坐标
        this.npc.getLocation().getY();
        this.npc.getLocation().getZ();
        Location location = npc.getLocation();
        location.setWorld(this.npc.getLocation().getWorld());
        location.setX(location.getX() + this.npc.getLocation().getX());
        location.setY(location.getY() + this.npc.getLocation().getY());
        location.setZ(location.getZ() + this.npc.getLocation().getZ());
        // 添加到列表
        additions.add(npc);
    }

    @Override
    public List<NPC> getAdditionNPC() {
        return additions;
    }

    @Override
    public void setNPC(NPC npc) {
        this.npc = npc;
    }

    @Override
    public NPC getNPC() {
        return this.npc;
    }
}

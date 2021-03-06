package com.nanokylin.mc.yanpc.controller;

import com.nanokylin.mc.yanpc.common.model.NPC;
import com.nanokylin.mc.yanpc.controller.interfaces.IMultiEntityNPCLoader;

import java.util.ArrayList;
import java.util.List;

//TODO: 转换坐标
public class MultiEntityNPCLoader implements IMultiEntityNPCLoader {
    NPC npc;
    List<NPC> additions = new ArrayList<>();

    @Override
    public void addAdditionNPC(NPC npc) {
        additions.add(npc);
        // 转换坐标TODO
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

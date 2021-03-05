package com.nanokylin.mc.yanpc.controller;

import com.nanokylin.mc.yanpc.common.model.NPC;
import com.nanokylin.mc.yanpc.controller.interfaces.IEntityNPCLoader;

public class EntityNPCLoader implements IEntityNPCLoader {
    NPC npc;

    @Override
    public void setNPC(NPC npc) {
        this.npc = npc;
    }

    @Override
    public NPC getNPC() {
        return this.npc;
    }

}

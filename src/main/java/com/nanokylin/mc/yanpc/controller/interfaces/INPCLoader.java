package com.nanokylin.mc.yanpc.controller.interfaces;

import com.nanokylin.mc.yanpc.common.model.NPC;

import java.util.Map;

/**
 * 为加载NPC提供的最终接口 但通常 这个接口是其他更高级的接口的基本接口
 * The final interface provided for loading NPC,
 * but usually this interface is the basic interface of
 * other higher-level interfaces
 *
 * @author Hanbings
 */
public interface INPCLoader {
    /**
     * 为内部提供一个加载的NPC
     * Provide a loaded NPC internally
     *
     * @param npc NPC
     */
    void setNPC(NPC npc);

    /**
     * 获取内部的NPC Map
     * Get the internal NPC
     *
     * @return NPC
     */
    NPC getNPC();
}

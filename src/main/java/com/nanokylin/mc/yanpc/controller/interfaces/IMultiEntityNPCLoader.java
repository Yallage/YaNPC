package com.nanokylin.mc.yanpc.controller.interfaces;

import com.nanokylin.mc.yanpc.common.model.NPC;

import java.util.List;
import java.util.Map;

/**
 * 继承于基础的NPCLoader
 * 此接口为多实体NPC设计
 * 需要再为类传入多个NPC BEAN对象
 * 警告：如果是单实体的NPC为什么不使用INPCLoader呢 ？ : )
 * Inherited from the basic NPCLoader
 * This interface is designed for multi-entity NPC
 * Need to pass in multiple NPC BEAN objects for the class
 * Warning: If it is a single entity NPC, why not use INPCLoader? :)
 *
 * @author Hanbings
 */
public interface IMultiEntityNPCLoader extends INPCLoader{
    /**
     * 为多实体NPC添加一个NPC
     * Add an NPC for multi-entity NPC
     *
     * @param npc 需要添加NPC
     */
    void addAdditionNPC(NPC npc);

    /**
     * 获取所有额外添加的NPC
     * 警告：仅仅是获取额外添加的NPC 主NPC仍需要继承于父接口的 getNPC()
     * Get all additional NPCs
     * Warning: just to get additional NPCs,
     * the main NPC still needs to inherit from the parent interface's getNPC()
     *
     * @return Addition NPC
     */
    List<NPC> getAdditionNPC();
}

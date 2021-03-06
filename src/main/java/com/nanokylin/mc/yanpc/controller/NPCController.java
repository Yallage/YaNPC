package com.nanokylin.mc.yanpc.controller;

import com.nanokylin.mc.yanpc.common.content.NPCType;
import com.nanokylin.mc.yanpc.common.model.NPC;
import com.nanokylin.mc.yanpc.task.EntityNPCTaskRunnable;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主控制器 接收BEAN对象并处理它们
 * The main controller receives BEAN objects and processes them
 *
 * @author Hanbings
 * @version 1.1 fast update
 */
public class NPCController {
    Map<String, NPC> entityNPC = new HashMap<>();
    Map<String, NPC> multiEntityNPCMain = new HashMap<>();
    Map<String, NPC> multiEntityNPCAddition = new HashMap<>();
    Map<String, EntityNPCLoader> entityNPCLoaderMap = new HashMap<>();
    Map<String, MultiEntityNPCLoader> multiEntityNPCLoaderMap = new HashMap<>();
    EntityNPCTaskRunnable taskRunnable = new EntityNPCTaskRunnable();

    /**
     * 此方法将承担大部分关于分配资源的工作
     * 耦合好高！ qwq
     * This method will take on most of the work on allocating resources
     * The coupling is so high! qwq
     *
     * @param config NPC List
     */
    public NPCController(List<NPC> config) {
        // 遍历传入的List 分类NPC
        for (NPC npc : config) {
            if (npc.getType().equals(NPCType.ENTITY)) {
                entityNPC.put(npc.getKey(), npc);
            }
            if (npc.getType().equals(NPCType.MULTIENTITES_MAIN)) {
                multiEntityNPCMain.put(npc.getKey(), npc);
            }
            if (npc.getType().equals(NPCType.MULTIENTITES_ADDITION)) {
                multiEntityNPCAddition.put(npc.getKey(), npc);
            }
        }
        // 将分类好的NPC一一遍历传入Loader中进行加载
        // 先是单实体的
        for (Map.Entry<String, NPC> entry : entityNPC.entrySet()) {
            EntityNPCLoader entityNPCLoader = new EntityNPCLoader();
            entityNPCLoader.setNPC(entry.getValue());
            entityNPCLoaderMap.put(entry.getKey(), entityNPCLoader);
        }
        // 多实体的
        for (Map.Entry<String, NPC> entry : entityNPC.entrySet()) {
            MultiEntityNPCLoader multiEntityNPCLoader = new MultiEntityNPCLoader();
            multiEntityNPCLoader.setNPC(entry.getValue());
            // 多实体需要读取附加的NPC列表
            for (int i = 0; i < entry.getValue().getAddition().size(); i++) {
                if (multiEntityNPCAddition.containsKey(entry.getValue().getAddition().get(i))) {
                    multiEntityNPCLoader.addAdditionNPC(multiEntityNPCAddition.get(entry.getValue().getAddition().get(i)));
                } else {
                    Bukkit.getServer().getLogger().info(ChatColor.RED + "[YaNPC] 加载到不合法NPC 请检查配置文件 不合法的配置文件：" + entry.getKey());
                }
            }
            multiEntityNPCLoaderMap.put(entry.getKey(), multiEntityNPCLoader);
        }
        // 加载后放入实现队列 放置到游戏中
        for (Map.Entry<String, EntityNPCLoader> entry : entityNPCLoaderMap.entrySet()) {
            taskRunnable.addEntityLoaderTask(entry.getValue());
        }
        taskRunnable.start();
    }
}

package com.nanokylin.mc.yanpc.config;

import com.nanokylin.mc.yanpc.YaNPC;
import com.nanokylin.mc.yanpc.common.content.NPCType;
import com.nanokylin.mc.yanpc.common.model.AI;
import com.nanokylin.mc.yanpc.common.model.Animation;
import com.nanokylin.mc.yanpc.common.model.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.*;

/**
 * 此类专注于加载配置文件
 * 但仅仅如此 将配置文件加载然后加载到Controller内
 * This class focuses on loading configuration files
 * But it’s just that. Load the configuration file and then load it into the Controller package.
 *
 * @author Hanbings
 * @version 1.1 fast update
 */
public class ConfigHandler {

    YaNPC plugin;
    List<NPC> config;

    @SuppressWarnings("ALL")
    public ConfigHandler(YaNPC plugin) {
        this.plugin = plugin;
        // 检查配置文件夹是否存在
        File dir = new File("./plugins/YaNPC/npc/");
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }

        // 输出废话
        plugin.getLogger().info("准备加载配置文件 !");

        // 获取配置文件表 生成JavaBean 推送至控制器
        // pushToController(generateNPCObject(getFiles(dir)));
        // 脑袋被门夹了 什么高耦合设计 我裂开来
        this.config = generateNPCObject(getFiles(dir));
    }

    /**
     * 生成JavaBean文件
     * 只是最简单的加载 具体处理过程在Controller完成
     * Generate JavaBean file
     * It’s just the simplest loading.
     * The specific processing is done in the Controller.
     *
     * @param files 文件列表
     * @return List的NPC Bean列表
     */
    private List<NPC> generateNPCObject(List<File> files) {
        FileConfiguration configuration;
        List<NPC> config = new ArrayList<>();
        for (File file : files) {
            configuration = YamlConfiguration.loadConfiguration(file);
            NPC npc = new NPC();
            npc.setKey(configuration.getString("key"));
            npc.setType(NPCType.valueOf(configuration.getString("type")));
            npc.setDisplay(configuration.getString("display"));
            npc.setAnimation(new Animation());
            npc.setAddition(new ArrayList<>());
            npc.setAi(new AI());
            npc.setLocation(new Location(Bukkit.getWorld(Objects.requireNonNull(configuration.getString("location.world"))),
                    configuration.getDouble("location.x"),
                    configuration.getDouble("location.y"),
                    configuration.getDouble("location.z")));
            npc.setLazyLoad(configuration.getBoolean("lazy-load"));
            // new新的ItemStack
            ItemStack itemStack = new ItemStack(Material.valueOf(Objects.requireNonNull(configuration.getString("item")).toUpperCase(Locale.ROOT)));
            npc.setItemStack(itemStack);
            npc.setCustomModelData(configuration.getInt("custommodeldata"));
            config.add(npc);
        }
        return config;
    }

    /**
     * 递归获取所有配置文件
     * Get all configuration files recursively
     *
     * @param path 路径文件对象
     */
    @SuppressWarnings("ALL")
    private List<File> getFiles(File path) {
        List<File> files = new ArrayList<>();
        File[] tempList = path.listFiles();
        for (int i = 0; i < Objects.requireNonNull(tempList).length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i]);
            }
            if (tempList[i].isDirectory()) {
                getFiles(tempList[i]);
            }
        }
        return files;
    }

    public List<NPC> getConfig() {
        return config;
    }
}

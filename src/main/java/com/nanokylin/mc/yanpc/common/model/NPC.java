package com.nanokylin.mc.yanpc.common.model;

import com.nanokylin.mc.yanpc.common.content.NPCType;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class NPC {
    private String Key;
    private NPCType type;
    private String display;
    private Animation animation;
    private List<String> addition;
    private AI ai;
    private Location location;
    private Boolean lazyLoad;
    private ItemStack itemStack;
    private int customModelData;
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public NPCType getType() {
        return type;
    }

    public void setType(NPCType type) {
        this.type = type;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public List<String> getAddition() {
        return addition;
    }

    public void setAddition(List<String> addition) {
        this.addition = addition;
    }

    public AI getAi() {
        return ai;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Boolean getLazyLoad() {
        return lazyLoad;
    }

    public void setLazyLoad(Boolean lazyLoad) {
        this.lazyLoad = lazyLoad;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public int getCustomModelData() {
        return customModelData;
    }

    public void setCustomModelData(int customModelData) {
        this.customModelData = customModelData;
    }
}

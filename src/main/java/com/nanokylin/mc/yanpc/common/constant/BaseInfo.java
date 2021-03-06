package com.nanokylin.mc.yanpc.common.constant;

import java.util.Properties;

@SuppressWarnings("ALL")
public class BaseInfo {
    // 获取系统信息
    static Properties props = System.getProperties();
    //系统名称
    public static final String SYSTEM_NAME = props.getProperty("os.name");
    //构架类型
    public static final String SYSTEM_ARCH = props.getProperty("os.arch");
    //系统版本
    public static final String SYSTEM_VERSION = props.getProperty("os.version");
    //Java版本
    public static final String JAVA_VM_VERSION = props.getProperty("java.vm.version");
    //Java供应商
    public static final String JAVA_VM_VENDOR = props.getProperty("java.vm.vendor");
    //Java虚拟机实现名称
    public static final String JAVA_VM_NAME = props.getProperty("java.vm.name");
    //Java类格式版本号
    public static final String JAVA_CLASS_VERSION = props.getProperty("java.class.version");
    //Java类路径
    public static final String JAVA_CLASS_PATH = props.getProperty("java.class.path");
    //CatPawServer版本号
    public static final String YA_NPC_VERSION = "YaNPC CAT (Bate)";
    //CatPawServer构建时间
    public static final String YA_NPC_BUILD_TIME = "BUILD 2021/03/06 SAT Hanbings 3219065882@qq.com";
    //LOGO
    public static final String YA_NPC_LOGO = "" +
            "__  __      _____   __________________\n" +
            "_ \\/ /_____ ___  | / /__  __ \\_  ____/\n" +
            "__  /_  __ `/_   |/ /__  /_/ /  /     \n" +
            "_  / / /_/ /_  /|  / _  ____// /___   \n" +
            "/_/  \\__,_/ /_/ |_/  /_/     \\____/   ";

    public static String getProperties(String key) {
        return props.getProperty(key);
    }
}

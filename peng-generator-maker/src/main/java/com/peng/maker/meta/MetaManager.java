package com.peng.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * 读取json配置信息
 */
public class MetaManager {

    /**
     * volatile 并发编程，用于确保多线程环境下的内存可见性
     *          保证meta对象不被多次初始化
     */
    private static volatile Meta meta;

    /**
     * 饿汉式 单例模式
     */
    // private final static Meta meta = initMeta();

    /**
     * 双检锁 单例设计模式
     * @return
     */
    public static Meta getMeteObject(){
        if (meta == null){
            // 锁 限制多线程同时初始化
            synchronized (MetaManager.class){
                if (meta == null){
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta(){
        // 读取 json 文件信息
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        // todo 校验配置文件信息，处理默认值

        return newMeta;
    }

}

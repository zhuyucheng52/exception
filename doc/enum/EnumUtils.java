package com.netease.ad.b.nex.util;

import com.netease.ad.b.nex.constant.AbstractEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举工具类
 * Created by bjzhuyucheng on 2016/9/20.
 */
public class EnumUtils {

    /**
     * 获取枚举的键值对，key为Byte类型
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends AbstractEnum<Byte>> Map<Byte, String> getValueDescMap(Class<T> enumClass) {
        T[] enums = enumClass.getEnumConstants();
        Map<Byte, String> map = new HashMap<Byte, String>(enums.length);
        for (T e : enums) {
            map.put(e.getValue(), e.getDesc());
        }

        return map;
    }

    public static <T extends AbstractEnum<Byte>> Map<String, Byte> getDescValueMap(Class<T> enumClass) {
        T[] enums = enumClass.getEnumConstants();
        Map<String, Byte> map = new HashMap<String, Byte>(enums.length);
        for (T e : enums) {
            map.put(e.getDesc(), e.getValue());
        }

        return map;
    }
}

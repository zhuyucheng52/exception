package com.netease.ad.b.nex.constant;

/**
 * 抽象枚举接口，统一用户自定义枚举
 * Created by bjzhuyucheng on 2016/9/19.
 */
public interface AbstractEnum<T> {
    /**
     *  获取枚举值
     **/
    T getValue();

    /**
     *  获取枚举描述
     **/
    String getDesc();
}

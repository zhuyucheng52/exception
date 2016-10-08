package com.netease.ad.b.nex.util;

import com.netease.ad.b.nex.platform.exception.NexException;

import java.util.Collection;

/**
 * 断言工具类，断言参数结果，如果不符合就抛出NexException异常
 *
 * Created by bjzhuyucheng on 2016/9/23.
 */
public class AssertUtils {
    /**
     * 判定obj对象为null，否则抛出NexException异常
     * @param obj
     * @param message
     */
    public static void assertNull(Object obj, String message) {
        if (null != obj) {
            throw new NexException(message);
        }
    }

    /**
     * 判定obj对象不为null，否则抛出NexException异常
     * @param obj
     * @param message   抛出异常的提示消息
     * @return
     */
    public static void assertNotNull(Object obj, String message) {
        if (null == obj) {
            throw new NexException(message);
        }
    }

    /**
     * 计算两个对象是否相等
     * @param obj1
     * @param obj2
     * @return
     */
    private static boolean ifEquals(Object obj1, Object obj2) {
        if ((obj1 == obj2)
                || (null != obj1 && obj1.equals(obj2))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判定obj1和obj2相等，否则抛出NexException异常
     * @param obj1
     * @param obj2
     * @param message   抛出异常的提示消息
     * @return
     */
    public static void assertEquals(Object obj1, Object obj2, String message) {
        if (!ifEquals(obj1, obj2)) {
            throw new NexException(message);
        }
    }

    /**
     * 判定obj1和obj2不相等，否则抛出NexException异常
     * @param obj1
     * @param obj2
     * @param message   抛出异常的提示信息
     */
    public static void assertNotEquals(Object obj1, Object obj2, String message) {
        if (ifEquals(obj1, obj2)) {
            throw new NexException(message);
        }
    }

    /**
     * 判定collection为空或为null，否则抛出NexException异常
     * @param collection
     * @param message
     */
    public static void assertIsEmpty(Collection collection, String message) {
        if (null != collection && !collection.isEmpty()) {
            throw new NexException(message);
        }
    }

    /**
     * 判定collection不为空或不为null，否则抛出NexException异常
     * @param collection
     * @param message
     */
    public static void assertIsNotEmpty(Collection collection, String message) {
        if (null == collection || collection.isEmpty()) {
            throw new NexException(message);
        }
    }

    /**
     * 判定result为true，否则抛出NexException异常
     * @param result
     * @param message
     */
    public static void assertTrue(boolean result, String message) {
        if (!result) {
            throw new NexException(message);
        }
    }

    /**
     * 判定result为false，否则抛出NexException异常
     * @param result
     * @param message
     */
    public static void assertFalse(boolean result, String message) {
        if (result) {
            throw new NexException(message);
        }
    }
}

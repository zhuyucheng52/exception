package com.netease.ad.b.nex.util;

import com.netease.ad.b.nex.platform.exception.NexException;

import java.util.Collection;

/**
 * 断言工具类，断言参数结果，如果不符合就抛出NexException异常
 *
 * Created by bjzhuyucheng on 2016/9/23.
 */
public class AssertUtils {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    /**
     * 判定obj对象为null，否则抛出NexException异常
     * @param obj
     * @param message
     */
    public static void assertNull(Object obj, String message) {
        assertNull(obj, message, EMPTY_ARRAY);
    }

    /**
     * 判定obj对象为null，否则抛出NexException异常
     * @param obj
     * @param template
     * @param args
     */
    public static void assertNull(Object obj, String template, Object... args) {
        if (null != obj) {
            throw new NexException(format(template, args));
        }
    }

    /**
     * 判定obj对象不为null，否则抛出NexException异常
     * @param obj
     * @param message   抛出异常的提示消息
     * @return
     */
    public static void assertNotNull(Object obj, String message) {
        assertNotNull(obj, message, EMPTY_ARRAY);
    }

    /**
     * 判定obj对象不为null，否则抛出NexException异常
     * @param obj
     * @param template
     * @param args
     */
    public static void assertNotNull(Object obj, String template, Object... args) {
        if (null == obj) {
            throw new NexException(format(template, args));
        }
    }
    /**
     * 计算两个对象是否相等
     * @param obj1
     * @param obj2
     * @return
     */
    private static boolean isEquals(Object obj1, Object obj2) {
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
        assertEquals(obj1, obj2, message, EMPTY_ARRAY);
    }

    /**
     * 判定obj1和obj2相等，否则抛出NexException异常
     * @param obj1
     * @param obj2
     * @param template
     * @param args
     */
    public static void assertEquals(Object obj1, Object obj2, String template, Object... args) {
        if (!isEquals(obj1, obj2)) {
            throw new NexException(format(template, args));
        }
    }

    /**
     * 判定obj1和obj2不相等，否则抛出NexException异常
     * @param obj1
     * @param obj2
     * @param message   抛出异常的提示信息
     */
    public static void assertNotEquals(Object obj1, Object obj2, String message) {
        assertNotEquals(obj1, obj2, message, EMPTY_ARRAY);
    }

    /**
     * 判定obj1和obj2不相等，否则抛出NexException异常
     * @param obj1
     * @param obj2
     * @param template
     * @param args
     */
    public static void assertNotEquals(Object obj1, Object obj2, String template, Object... args) {
        if (isEquals(obj1, obj2)) {
            throw new NexException(format(template, args));
        }
    }

    /**
     * 判定collection为空或为null，否则抛出NexException异常
     * @param collection
     * @param message
     */
    public static void assertIsEmpty(Collection collection, String message) {
        assertIsEmpty(collection, message, EMPTY_ARRAY);
    }

    /**
     * 判定collection为空或为null，否则抛出NexException异常
     * @param collection
     * @param template
     * @param args
     */
    public static void assertIsEmpty(Collection collection, String template, Object... args) {
        if (null != collection && !collection.isEmpty()) {
            throw new NexException(format(template, args));
        }
    }

    /**
     * 判定collection不为空或不为null，否则抛出NexException异常
     * @param collection
     * @param message
     */
    public static void assertIsNotEmpty(Collection collection, String message) {
        assertIsNotEmpty(collection, message, EMPTY_ARRAY);
    }

    /**
     * 判定collection不为空或不为null，否则抛出NexException异常
     * @param collection
     * @param template
     * @param args
     */
    public static void assertIsNotEmpty(Collection collection, String template, Object... args) {
        if (null == collection || collection.isEmpty()) {
            throw new NexException(format(template, args));
        }
    }

    /**
     * 判定result为true，否则抛出NexException异常
     * @param result
     * @param message
     */
    public static void assertTrue(boolean result, String message) {
        assertTrue(result, message, EMPTY_ARRAY);
    }

    /**
     * 判定result为true，否则抛出NexException异常
     * @param result
     * @param template
     * @param args
     */
    public static void assertTrue(boolean result, String template, Object... args) {
        if (!result) {
            throw new NexException(format(template, args));
        }
    }

    /**
     * 判定result为false，否则抛出NexException异常
     * @param result
     * @param message
     */
    public static void assertFalse(boolean result, String message) {
        assertFalse(result, message, EMPTY_ARRAY);
    }

    /**
     * 判定result为false，否则抛出NexException异常
     * @param result
     * @param template
     * @param args
     */
    public static void assertFalse(boolean result, String template, Object... args) {
        if (result) {
            throw new NexException(format(template, args));
        }
    }

    static String format(String template, Object... args) {
        template = String.valueOf(template); // null -> "null"

        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("{}", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template.substring(templateStart, placeholderStart));
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template.substring(templateStart));

        // if we run out of placeholders, append the extra args in square braces
//        if (i < args.length) {
//            builder.append(" [");
//            builder.append(args[i++]);
//            while (i < args.length) {
//                builder.append(", ");
//                builder.append(args[i++]);
//            }
//            builder.append(']');
//        }

        return builder.toString();
    }
}

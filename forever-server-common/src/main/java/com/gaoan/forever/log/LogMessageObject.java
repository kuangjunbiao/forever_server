package com.gaoan.forever.log;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.gaoan.forever.log.em.LogTypeEm;
import com.gaoan.forever.log.em.UserLogTypeEm;

/**
 * 日志消息对象
 *
 * @author longshengtang
 * @since 20170417
 */

public class LogMessageObject {
    // 是否写入log，默认为true
    private boolean isWritten = true;

    //此次操作是否成功:此次业务逻辑操作是否成功，默认都是成功。用户标记记了日志，但日志的结果相反时候
    //比如，添加用户时候，记录“成功添加了admin_test用户！”，但库里实际并不存在，此种情况可以不记录日志的，但添加此标记就可以记录失败的情况，何乐不为呢
    private boolean resultFlg = true;

    // message对象参数
    private Object[] objects;

    // 消息格式
    private String message;

    /**
     * 日志类型：如果填写，会覆盖 日志类型
     */
    private LogTypeEm logTypeEm;

    /**
     * 用户类型枚举:用于判定记录后台还是前台日志，默认只记录后台日志。如果指定，会覆盖Log注解上的值
     */
    private UserLogTypeEm userLogTypeEm;

    /**
     * 其它属性
     */
    final private Map<String, Object> otherAttr = new HashMap<>();

    /**
     * 构造函数
     */
    public LogMessageObject() {
    }

    /**
     * 构造函数
     *
     * @param isWritten
     */
    public LogMessageObject(boolean isWritten) {
        super();
        this.isWritten = isWritten;
    }

    /**
     * 构造函数
     *
     * @param isWritten
     * @param objects
     */
    public LogMessageObject(boolean isWritten, Object[] objects) {
        super();
        this.isWritten = isWritten;
        this.objects = objects;
    }


    /**
     * 设定覆盖日志，且业务操作结果成功
     *
     * @return
     */
    public static LogMessageObject newWrite() {
        return new LogMessageObject(true);
    }

    /**
     * 设定覆盖日志，但业务操作结果为失败
     *
     * @param resultFlg
     * @return
     */
    public static LogMessageObject newWrite(boolean resultFlg) {
        return newWrite().setResultFlg(resultFlg);
    }

    public static LogMessageObject newIgnore() {
        return new LogMessageObject(false);
    }

    /**
     * 返回 isWritten 的值
     *
     * @return isWritten
     */
    public boolean isWritten() {
        return isWritten;
    }

    /**
     * 设置 isWritten 的值
     *
     * @param isWritten
     */
    public LogMessageObject setWritten(boolean isWritten) {
        this.isWritten = isWritten;
        return this;
    }

    /**
     * 返回 objects 的值
     *
     * @return objects
     */
    public Object[] getObjects() {
        return objects;
    }

    /**
     * 设置 objects 的值
     *
     * @param objects
     */
    public LogMessageObject setObjects(Object... objects) {
        this.objects = objects;
        return this;
    }

    /**
     * 设置 objects 的值
     *
     * @param values
     */
    public LogMessageObject setObjects4TreeMap(TreeMap<?, Object> values) {
        if (values == null || values.values().size() < 1) {
            return this;
        }
        this.objects = new Object[values.size()];
        int i = 0;
        for (Object obj : values.values()) {
            this.objects[i++] = obj;
        }
        return this;
    }

    public String getMessage() {
        return message;
    }

    public LogMessageObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public LogTypeEm getLogTypeEm() {
        return logTypeEm;
    }

    public LogMessageObject setLogTypeEm(LogTypeEm logTypeEm) {
        this.logTypeEm = logTypeEm;
        return this;
    }

    public boolean isResultFlg() {
        return resultFlg;
    }

    public UserLogTypeEm getUserLogTypeEm() {
        return userLogTypeEm;
    }

    public LogMessageObject setUserLogTypeEm(UserLogTypeEm userLogTypeEm) {
        this.userLogTypeEm = userLogTypeEm;
        return this;
    }

    public LogMessageObject setResultFlg(boolean resultFlg) {
        this.resultFlg = resultFlg;
        return this;
    }

    /**
     * 添加其它属性进来
     *
     * @param key
     * @param value
     * @return
     */
    public LogMessageObject addAttr(String key, Object value) {
        otherAttr.put(key, value);
        return this;
    }

    /**
     * 获取额外属性
     *
     * @param key
     * @return
     */
    public Object getAttr(String key) {
        return otherAttr.get(key);
    }
}

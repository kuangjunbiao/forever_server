
package com.gaoan.forever.log.adpter;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaoan.forever.log.LogAPI;
import com.gaoan.forever.log.LogLevel;
import com.gaoan.forever.log.LogMessageObject;

/**
 * 日志的默认实现
 *
 * @author longshengtang
 * @since 20170417
 */

public class LogAdapter implements LogAPI {

    private static final Logger logger = LoggerFactory.getLogger(LogAdapter.class);

    /**
     * @param message
     * @param logLevel
     * @see LogAPI#log(String, LogLevel)
     */
    @Override
    public void log(String message, LogLevel logLevel) {
        log(message, null, logLevel);
    }

    /**
     * @param message
     * @param objects
     * @param logLevel
     * @see LogAPI#log(String, Object[], LogLevel)
     */
    @Override
    public void log(String message, Object[] objects, LogLevel logLevel) {
        MessageFormat mFormat = new MessageFormat(message);
        String result = mFormat.format(objects);

        if (!StringUtils.isNotBlank(result)) {
            return;
        }
        logger.info("使用系统默认实现打印日志：" + result);
    }

    @Override
    public void log(LogMessageObject logMessageObject, LogLevel logLevel) {
        MessageFormat mFormat = new MessageFormat(logMessageObject.getMessage());
        String result = mFormat.format(logMessageObject.getObjects());

        if (!StringUtils.isNotBlank(result)) {
            return;
        }
        logger.info("使用系统默认实现打印日志：" + result);
    }

    /**
     * @return
     * @see LogAPI#getRootLogLevel()
     */
    @Override
    public LogLevel getRootLogLevel() {
        return LogLevel.ERROR;
    }

    /**
     * @return
     * @see LogAPI#getCustomLogLevel()
     */
    @Override
    public Map<String, LogLevel> getCustomLogLevel() {
        return stringLogLevelHashMap;
    }

    private HashMap<String, LogLevel> stringLogLevelHashMap = new HashMap<String, LogLevel>();
}

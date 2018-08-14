package com.gaoan.forever.shiro.exception;


import org.apache.shiro.authc.AuthenticationException;

/**
 * 超过密码错误次数
 */
public class StatusLockedException extends AuthenticationException {
    /**
     *
     */
    private static final long serialVersionUID = -6657337418551792161L;

    public StatusLockedException() {
        super();
    }

    public StatusLockedException(String message) {
        super(message);
    }

    public StatusLockedException(Throwable cause) {
        super(cause);
    }

    public StatusLockedException(String message, Throwable cause) {
        super(message, cause);
    }
}
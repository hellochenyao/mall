package com.pro.member.exception;

/**
 * @author chenyao
 * date 2021-03-18
 */
public class UsernameExistException extends RuntimeException {
    public UsernameExistException() {
        super("用户名存在");
    }
}

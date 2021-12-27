package com.pro.member.exception;

/**
 * @author chenyao
 * date 2021-03-18
 */
public class PhoneExistException extends RuntimeException {
    public PhoneExistException() {
        super("手机号存在");
    }
}

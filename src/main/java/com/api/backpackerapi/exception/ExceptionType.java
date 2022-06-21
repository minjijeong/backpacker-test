package com.api.backpackerapi.exception;

import lombok.Getter;

@Getter
public enum ExceptionType {
    Exception("exception.code", "exception.msg"),
    MEMBER_EMAIL_ALREADY_EXISTS_EXCEPTION("memberEmailAlreadyExistsException.code", "memberEmailAlreadyExistsException.msg"),
    MEMBER_NICKNAME_ALREADY_EXISTS_EXCEPTION("memberNicknameAlreadyExistsException.code", "memberNicknameAlreadyExistsException.msg"),
    MEMBER_NOT_FOUND_EXCEPTION("memberNotFoundException.code", "memberNotFoundException.msg"),
    ORDER_DETAIL_NOT_FOUND_EXCEPTION("orderDtNotFoundException.code", "orderDtNotFoundException.msg");

    private final String code;
    private final String message;
    ExceptionType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

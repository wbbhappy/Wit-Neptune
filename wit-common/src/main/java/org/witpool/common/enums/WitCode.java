package org.witpool.common.enums;

public enum WitCode {
    WIT_OK(0, "success"),
    WIT_ERR_BASE(1000, "error"),
    WIT_ERR_DB_BASE(1001, "The operation of db occurs error"),
    WIT_ERR_DB_ADD(1002, "Insert record into db failed"),
    WIT_ERR_DB_DEL(1003, "Delete record from db failed"),
    WIT_ERR_DB_GET(1004, "Get record from db failed"),
    WIT_ERR_DB_UPDATE(1005, "Update record to db failed"),
    WIT_ERR_INNER(1006, "System inner error"),
    WIT_ERR_NULL_PARAM(1007, "Null parameter"),
    WIT_ERR_INVALID_PARAM(1008, "Invalid parameter"),
    WIT_ERR_AUTH_FAILED(1009, "Invalid user name or password"),
    WIT_ERR_NOT_LOGON(1010, "This user is not logon"),
    WIT_ERR_USER_EXIST(1011, "This user is exist"),
    WIT_ERR_USER_NOT_EXIST(1012, "This user is not exist"),
    WIT_ERR_EMPTY_USER(1013, "Please input user name or password");

    private Integer code;
    private String msg;

    WitCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode()
    {
        return code;
    }
    public void setCode(int code)
    {
        this.code = code;
    }
    public String getMsg()
    {
        return msg;
    }
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}

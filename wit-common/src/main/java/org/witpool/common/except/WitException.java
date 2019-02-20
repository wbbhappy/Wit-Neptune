package org.witpool.common.except;

import org.witpool.common.enums.WitCode;

public class WitException extends RuntimeException {
    private static final long serialVersionUID = -2094740268698793827L;

    private Integer code;

    public WitException(WitCode wc) {
        super(wc.getMsg());
        this.code = wc.getCode();
    }

    public Integer getCode()
    {
        return code;
    }
    public void setCode(Integer code)
    {
        this.code = code;
    }
}

package org.witpool.common.model.bean;

import org.witpool.common.enums.WitCode;
import java.io.Serializable;
import java.util.List;

public class WitResult<T> implements Serializable {
    private static final long serialVersionUID = -6313651335351889170L;

    /** Instance */
    private T instance;
    /** Instances */
    private List<T> instances;
    /** Error code */
    private Integer code;
    /** Error message */
    private String msg;

    public WitResult()
    {
        this.setErrCode(WitCode.WIT_OK);
    }
    public WitResult(WitCode code)
    {
        this.setErrCode(code);
    }

    public WitResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public WitResult(T instance)
    {
        this.instance = instance;
    }
    public WitResult(List<T> instances)
    {
        this.instances = instances;
    }
    public T getInstance()
    {
        return instance;
    }
    public void setInstance(T instance)
    {
        this.instance = instance;
    }
    public List<T> getInstances()
    {
        return instances;
    }
    public void setInstances(List<T> instances)
    {
        this.instances = instances;
    }
    public String getMsg()
    {
        return msg;
    }
    public void setMessage(String msg)
    {
        this.msg = msg;
    }
    public Integer getCode()
    {
        return code;
    }
    public void setCode(Integer code)
    {
        this.code = code;
    }

    public void setErrCode(WitCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WitResult [instance=");
        builder.append(instance);
        builder.append(", instances=");
        builder.append(instances);
        builder.append(", code=");
        builder.append(code);
        builder.append(", msg=");
        builder.append(msg);
        builder.append("]");
        return builder.toString();
    }
}

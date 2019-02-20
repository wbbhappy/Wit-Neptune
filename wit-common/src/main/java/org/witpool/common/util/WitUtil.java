package org.witpool.common.util;

import org.witpool.common.enums.WitCode;
import org.witpool.common.model.bean.WitResult;
import java.util.List;

public class WitUtil {

    public static <T> WitResult<T> success(T instance) {
        WitResult<T> rst = new WitResult<T>(instance);
        rst.setErrCode(WitCode.WIT_OK);
        return rst;
    }

    public static <T> WitResult<T> success(List<T> instances) {
        WitResult<T> rst = new WitResult<T>(instances);
        rst.setErrCode(WitCode.WIT_OK);
        return rst;
    }

    public static <T> WitResult<T> success() {
        WitResult<T> rst = new WitResult<T>();
        rst.setErrCode(WitCode.WIT_OK);
        return rst;
    }

    public static <T> WitResult<T> failure(WitCode code) {
        WitResult<T> rst = new WitResult<T>();
        rst.setErrCode(code);
        return rst;
    }
}

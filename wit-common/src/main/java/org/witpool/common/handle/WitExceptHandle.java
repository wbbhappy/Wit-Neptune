package org.witpool.common.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.witpool.common.enums.WitCode;
import org.witpool.common.except.WitException;
import org.witpool.common.model.bean.WitResult;

@ControllerAdvice
public class WitExceptHandle {
    private final static Logger logger = LoggerFactory.getLogger(WitExceptHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public WitResult handle(Exception e) {
        if (e instanceof WitException) {
            WitException we = (WitException) e;
            return new WitResult(we.getCode(), we.getMessage());
        }
        else {
            logger.error(WitCode.WIT_ERR_INNER.getMsg() + "{}", e);
            return new WitResult(WitCode.WIT_ERR_INNER.getCode(), e.getMessage());
        }
    }
}

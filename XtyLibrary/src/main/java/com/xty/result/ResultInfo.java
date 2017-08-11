package com.xty.result;

import org.springframework.context.MessageSource;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by eugene on 16/3/21.
 */
public class ResultInfo {
    public static final String RESULT_OK = "OK";

    public static final String RESULT_ERROR = "ERROR";

    private Date time;

    private String result = RESULT_OK;

    private ExceptionInfo exception;

    private String[] resultFields;

    private Object[] resultValues;

    public ResultInfo() {
        this.setResult(RESULT_OK);
    }

    public ResultInfo(Date time, String result, ExceptionInfo exception,
                      String[] resultFields, Object[] resultValues) {
        super();
        this.time = time;
        this.result = result;
        this.exception = exception;
        this.resultFields = resultFields;
        this.resultValues = resultValues;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ExceptionInfo getException() {
        return exception;
    }

    public void setException(ExceptionInfo exception) {
        this.exception = exception;
    }

    public String[] getResultFields() {
        return resultFields;
    }

    public void setResultFields(String[] resultFields) {
        this.resultFields = resultFields;
    }

    public Object[] getResultValues() {
        return resultValues;
    }

    public void setResultValues(Object[] resultValues) {
        this.resultValues = resultValues;
    }

    public void buildExceptionInfo(Exception e, String service, String method,
                                   MessageSource messageSource, Locale locale) {
        ExceptionInfo info = null;
        Date time = Calendar.getInstance().getTime();
        e.printStackTrace();
        if (e instanceof BaseException) {
            BaseException be = (BaseException) e;

            info = new ExceptionInfo(time, messageSource.getMessage(be.getId(), be
                    .getParams(), locale), service, method);
        } else {
            info = new ExceptionInfo(time, e.getClass().getName() + ":" + e.getMessage(), service, method);
        }

        this.resultFields = null;
        this.resultValues = null;
        this.result = RESULT_ERROR;

        setException(info);
    }
}

package com.xty.result;

/**
 * Created by eugene on 16/3/21.
 */
public abstract class BaseException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -6738383613823677130L;

    protected String id;

    protected Object[] params;

    public BaseException(String id, Object[] params) {
        super();

        this.id = id;
        this.params = params;
    }

    public BaseException(String id, Object[] params, Throwable cause) {
        super(cause);

        this.id = id;
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public Object[] getParams() {
        return params;
    }

    public Throwable getRootCause() {
        Throwable rootCause = null;
        Throwable cause = getCause();
        while (cause != null && cause != rootCause) {
            rootCause = cause;
            cause = cause.getCause();
        }
        return rootCause;
    }

    public String getRootService() {
        StackTraceElement[] traces = super.getStackTrace();
        return traces[traces.length - 1].getClassName();
    }

    public String getRootMethod() {
        StackTraceElement[] traces = super.getStackTrace();
        return traces[traces.length - 1].getMethodName();
    }

    public String[] getStringParams() {
        String[] sArray = null;

        if (this.params != null) {
            sArray = new String[this.params.length];

            for (int i = 0; i < this.params.length; i++) {
                Object o = this.params[i];
                sArray[i] = String.valueOf(o);
            }
        }

        return sArray;
    }
}

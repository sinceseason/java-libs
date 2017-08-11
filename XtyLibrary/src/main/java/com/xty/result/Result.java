package com.xty.result;

import com.xty.common.BaseUtil;
import com.xty.common.JsonOpera;
import com.xty.define.BaseDefinition;

/**
 * Created by eugene on 16/3/21.
 */
public class Result {
    public Result(){
        this.setResult(BaseDefinition.SUCCESS);
    }
    private String result;
    private Object data;
    private Object decodeData;
    private int errorCode;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
//        this.data = new JsonOpera().generateJsonString(data);
        this.data = BaseUtil.Base64Encode(new JsonOpera().generateJsonString(data));
    }

    public Object getDecodeData() {
        return decodeData;
    }

    public void setDecodeData(Object decodeData) {
        this.decodeData = decodeData;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}

package com.xty.common;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.JavaType;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by eugene on 16/3/21.
 */
public class JsonOpera extends ObjectMapper{
    public JsonOpera(){
        super();
        this.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        this.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public JsonOpera(SimpleDateFormat sdf){
        super();
        this.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        this.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.setDateFormat(sdf);
    }

    /**
     * Object to Json
     * @param obj Object
     * @return String
     */
    public String generateJsonString(Object obj){
        try{
            return this.writeValueAsString(obj);
        }catch (Exception ex){
            return null;
        }
    }

    /**
     * Json to Object
     * @param jsonString String
     * @param clz Class
     * @return Object
     */
    public Object parseObject(String jsonString, Class clz){
        try{
            return this.readValue(jsonString, clz);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Json to Object
     * @param f StrFileing
     * @param clz Class
     * @return Object
     */
    public Object parseObject(File f, Class clz){
        try{
            return this.readValue(f, clz);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Json to Object
     * @param jsonString String
     * @param javaType JavaType
     * @return Object
     */
    public Object parseObject(String jsonString, JavaType javaType){
        try{
            return this.readValue(jsonString, javaType);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 获取array类型
     * @param collectionClass Class
     * @param elementClasses Class
     * @return JavaType
     */
    public JavaType getJavaType(Class<?> collectionClass, Class<?> elementClasses){
        try{
            return this.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
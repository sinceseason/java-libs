package com.xty.jms.model;

/**
 * Created by eugene on 16/8/2.
 */
public class PublishTopicData {
    public PublishTopicData(){

    }

    public PublishTopicData(String type, String data){
        this.type = type;
        this.data = data;
    }

    private String type;
    private String data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

package com.example.demoapp;

import com.google.gson.JsonObject;

/**
 * @author: qj
 * @date: 2023-12-5
 * @description
 */
public class DSEntity {
    public String domain;
    public String intent;
    public String control_obj;
    public String state_code;
    public String tips;
    public String tips_key;
    //content的内容不确定,需要根据实际的指令进行解析
    public JsonObject content;

}

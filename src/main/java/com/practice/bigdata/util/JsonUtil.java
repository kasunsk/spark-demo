package com.practice.bigdata.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kasun on 7/12/19.
 */
public class JsonUtil {


    public static String convertToJsonString(Father father){
        JsonObject fatherJson = new JsonObject();
        fatherJson.addProperty("name", father.getName());
        fatherJson.addProperty("age", father.getAge());

        JsonArray childrenJsonArray = new JsonArray();
        for(Child child : father.getChildren()) {
            JsonObject childJson = new JsonObject();
            childJson.addProperty("name", child.getName());
            childJson.addProperty("age", child.getAge());
            childrenJsonArray.add(childJson);
        }
        fatherJson.add("children", childrenJsonArray);
        JsonObject fullJson = new JsonObject();
        fullJson.add("Father", fatherJson);

        return fullJson.toString();
    }

    public static String convertToJson(Father father) throws IOException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(father);
    }

    public static void main(String [] args){
        Father father = new Father();
        father.setAge(50);
        father.setName("Nimal");

        List<Child> children = new ArrayList<>();
        Child child1 = new Child();
        child1.setAge(15);
        child1.setName("Saman");
        children.add(child1);

        Child child2 = new Child();
        child2.setName("Kamal");
        child2.setAge(20);
        children.add(child2);

        father.setChildren(children);

        System.out.println(convertToJsonString(father));
        System.out.println("........................");
        try {
            System.out.println(convertToJson(father));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

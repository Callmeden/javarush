package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
        System.out.println(convertOneToAnother(s,f.getClass()));
        System.out.println(convertOneToAnother(f,s.getClass()));
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.disable(MapperFeature.USE_ANNOTATIONS);
        mapper.writeValue(writer, one);

        StringReader reader = new StringReader(writer.toString());

        return mapper.readValue(reader, resultClassObject);

        //        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(one);
//
//        jsonString = jsonString.replace(one.getClass().getSimpleName().toLowerCase(), resultClassObject.getSimpleName().toLowerCase());
//
//        StringReader reader = new StringReader(jsonString);
//        Object two = mapper.readValue(reader, resultClassObject);
//
//        return two;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i;
        public String name;
    }
}

package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import org.json.simple.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class json {
    public static void CreateJSON() throws Exception {
        String filename = "Users.json";
        JSONObject user = new JSONObject();
        user.put("Username", "GDStanis");
        user.put("id", 000000);
        Files.write(Paths.get(filename), user.toJSONString().getBytes());
        System.out.println("Done\n" + user);
    }

//    public static void toObjectJSON(objJSON obj) throws Exception {
//        FileOutputStream fos = new FileOutputStream("Users.json");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(obj);
//        oos.flush();
//        oos.close();
    // System.out.println("Done\n" + fos);
//    }

//    public static void readJSON() throws Exception {
//        FileInputStream fis = new FileInputStream("Users.json");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        objJSON inf = (objJSON) ois.readObject();
//        System.out.println("Done\n" + "name=" + inf.name + " id=" + inf.id);
//        ois.close();
//    }

    public static void deleteJSON() throws Exception {
        File file = new File("Users.json");
        if (file.delete()) {
            System.out.println("JSON file was successfully deleted");
        } else {
            System.out.println("JSON file hasn't been found");
        }
    }

    public static void toObjectJSON(objJSON obj) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(obj);

        try (FileWriter writer = new FileWriter("Users.json", false)) {
            writer.write(json);
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readJSON(String fileName) {
        List<Character> E =  new ArrayList<Character>();
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read())!= -1) {
                E.add((char)c);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        StringBuilder builder = new StringBuilder(E.size());
        for (Character ch: E) {
            builder.append(ch);
        }
        String thestr = builder.toString();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        objJSON check = gson.fromJson(thestr,objJSON.class);
        System.out.println("id=" + check.id + " name=" + check.name);
    }

}
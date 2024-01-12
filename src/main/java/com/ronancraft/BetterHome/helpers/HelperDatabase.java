package com.ronancraft.BetterHome.helpers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class HelperDatabase {

    //String List
    public static String getJsonFromList(List<String> list) {
        if (list == null)
            return null;
        return new Gson().toJson(list);
    }

    @NonNull
    public static List<String> getListFromJson(String json) {
        if (json == null || json.isEmpty())
            return new ArrayList<>();
        try {
            return new Gson().fromJson(json, List.class);
        } catch (NullPointerException | JsonSyntaxException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    //Location
    public static String getJsonFromHomes(@NotNull HashMap<String, Location> homes) {
        List<Map> array = new ArrayList<>();
        for (Map.Entry<String, Location> home : homes.entrySet()) {
            HashMap<String, Object> obj = new HashMap();
            obj.put("name", home.getKey());
            obj.put("x", home.getValue().getBlockX());
            obj.put("y", home.getValue().getBlockY());
            obj.put("z", home.getValue().getBlockZ());
            obj.put("world", home.getValue().getWorld().getName());
            array.add(obj);
        }
        return JSONArray.toJSONString(array);
    }

    public static HashMap<String, Location> getHomesFromJson(String json) {
        if (json == null || json.isEmpty())
            return null;
        try {
            JSONArray obj = (JSONArray) JSONValue.parse(json);
            HashMap<String, Location> homes = new HashMap<>();
            //HelperLogger.info("REQUESTS FROM JSON = " + json);

            for (Object map : obj) {
                Map info = (Map) map;
                String name = ((String) info.get("name"));
                int x = ((Long) info.get("x")).intValue();
                int y = ((Long) info.get("y")).intValue();
                int z = ((Long) info.get("z")).intValue();
                String worldName = (String) info.get("world");
                World world = Bukkit.getWorld(worldName);
                homes.put(name, new Vector(x, y, z).toLocation(world));
            }
            return homes;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}

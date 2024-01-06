package com.ronancraft.BetterHome.helpers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
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
    public static String getJsonFromLocation(Location loc) {
        if (loc == null)
            return null;
        List<Map> array = new ArrayList<>();
        HashMap<String, Object> obj = new HashMap();
        obj.put("x", loc.getBlockX());
        obj.put("y", loc.getBlockY());
        obj.put("z", loc.getBlockZ());
        obj.put("world", loc.getWorld().getName());
        array.add(obj);
        return JSONArray.toJSONString(array);
    }

    public static Location getLocationFromJson(String json) {
        if (json == null || json.isEmpty())
            return null;
        try {
            JSONArray obj = (JSONArray) JSONValue.parse(json);
            List<Location> locations = new ArrayList<>();
            //HelperLogger.info("REQUESTS FROM JSON = " + json);
            Map info = (Map) obj.get(0);
            int x = ((Long) info.get("x")).intValue();
            int y = ((Long) info.get("y")).intValue();
            int z = ((Long) info.get("z")).intValue();
            String worldName = (String) info.get("world");
            World world = Bukkit.getWorld(worldName);
            return new Vector(x, y, z).toLocation(world);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}

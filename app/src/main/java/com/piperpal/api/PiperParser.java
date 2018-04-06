package com.piperpal.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.piperpal.api.Location;

public class PiperParser {



    public static Location getJSONObject(String strJSONValue) throws Exception {

        Location loc = new Location();
        String strParsedValue;

        JSONObject jsonObject = new JSONObject(strJSONValue);
        JSONObject object = jsonObject.getJSONObject("locations");
        String name = object.getString("name");
        String service = object.getString("service");
        String location = object.getString("location");

        // strParsedValue = "Name value => " + name;
        // strParsedValue += "\n Service value => " + name;

        JSONObject subObject = object.getJSONObject("sub");
        JSONArray subArray = subObject.getJSONArray("sub1");

        loc.setName(name);
        loc.setService(service);
        loc.setLocation(location);

        return loc;
    }

}

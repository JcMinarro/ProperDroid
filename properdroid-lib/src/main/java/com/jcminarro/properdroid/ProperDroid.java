package com.jcminarro.properdroid;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProperDroid {

    private static volatile ProperDroid singleton = null;
    private JSONObject properties;

     public static ProperDroid with(Context context) {
        if (singleton == null) {
            synchronized (ProperDroid.class) {
                if (singleton == null) {
                    singleton = new ProperDroid(context);
                }
            }
        }
        return singleton;
    }

    private ProperDroid(Context context) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            InputStream inputStream = context.getAssets().open("properdroid.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            properties = new JSONObject(stringBuilder.toString());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            properties = new JSONObject();
        }
    }

    public String getString(String key, String fallback) {
        return properties.optString(key, fallback);
    }

    public double getDouble(String key, double fallback) {
        return properties.optDouble(key, fallback);
    }

    public boolean getBoolean(String key, boolean fallback) {
        return properties.optBoolean(key, fallback);
    }

    public int getInt(String key, int fallback) {
        return properties.optInt(key, fallback);
    }

    public long getLong(String key, long fallback) {
        return properties.optLong(key, fallback);
    }

    public Object get(String key) {
        return properties.opt(key);
    }
}

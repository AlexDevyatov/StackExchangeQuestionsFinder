package com.alexdevyatov.example.PianoTask;

import com.alexdevyatov.example.PianoTask.model.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 12.01.2018.
 */
@Component
public class JsonParser {

    public List<Question> getItemsFromJson(String json) {
        Gson gson = new GsonBuilder().create();
        JSONObject jsonResponseObject = new JSONObject(json);
        JSONArray jsonItems = jsonResponseObject.getJSONArray("items");
        Type listType = new TypeToken<ArrayList<Question>>(){}.getType();
        List<Question> result = gson.fromJson(String.valueOf(jsonItems), listType);

        return result;
    }

}

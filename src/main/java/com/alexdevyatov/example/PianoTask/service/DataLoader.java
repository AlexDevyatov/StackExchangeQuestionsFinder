package com.alexdevyatov.example.PianoTask.service;

import com.alexdevyatov.example.PianoTask.JsonParser;
import com.alexdevyatov.example.PianoTask.model.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Created by Алексей on 12.01.2018.
 */
@Service
public class DataLoader {

    @Autowired
    private JsonParser parser;

    private final String REQUEST_BODY = "http://api.stackexchange.com/2.2/search?order=desc&sort=creation&site=stackoverflow&intitle=";

    private String load(String keyword) {
        String result = null;
        try {
            URL url = new URL(REQUEST_BODY + keyword);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Encoding", "gzip");
            Gson gson = new GsonBuilder().create();
            result = IOUtils.toString(new GZIPInputStream(connection.getInputStream()),
                    "UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Question> getQuestionsList(String keyword) {
        return parser.getItemsFromJson(load(keyword));
    }
}

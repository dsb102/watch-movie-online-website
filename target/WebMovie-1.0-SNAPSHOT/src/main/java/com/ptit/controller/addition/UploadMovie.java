package com.ptit.controller.addition;

import com.ptit.DAO.MovieDAO;
import com.ptit.handlerJson.ParseJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UploadMovie {
    public void UploadPage(int page) throws ParseException {
        JsonReaderPage jsonReaderPage = new JsonReaderPage();
        String json = jsonReaderPage.jsonGetRequest(page);
        JsonReaderMovie jsonReaderMovie = new JsonReaderMovie();
        MovieDAO movieDAO = new MovieDAO();
        ParseJson parseJson = new ParseJson();
        JSONObject jo = (JSONObject) new JSONParser().parse(json);
        JSONArray jsonObject = (JSONArray) jo.get("items");
        for (Object jsonObject1 : jsonObject) {
            String slug = ((JSONObject) jsonObject1).get("slug").toString();
            String jsonMovie = jsonReaderMovie.jsonGetRequest(slug);
            System.out.println(jsonMovie);
            movieDAO.insertToFullMovie(jsonMovie);
        }
    }

    public static void main(String[] args) throws ParseException {
        new UploadMovie().UploadPage(2);
    }
}

package com.ptit.handlerJson;

import com.ptit.model.Actor;
import com.ptit.model.Category;
import com.ptit.model.Episode;
import com.ptit.model.Movie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class ParseJson {
    public static Movie handlerJson(String file_json) throws ParseException {
        JSONObject jo = (JSONObject) new JSONParser().parse(file_json);
        JSONObject movieObj = (JSONObject) jo.get("movie");

        Movie movie = new Movie(
                0,
                (String) movieObj.get("name"),
                (String) movieObj.get("origin_name"),
                (String) movieObj.get("content"),
                (String) movieObj.get("type"),
                (String) movieObj.get("status"),
                (String) movieObj.get("thumb_url"),
                (String) movieObj.get("trailer_url"),
                (String) movieObj.get("time"),
                (String) movieObj.get("episode_current"),
                (String) movieObj.get("episode_total"),
                (String) movieObj.get("quality"),
                (String) movieObj.get("lang"),
                (String) movieObj.get("slug"),
                Math.toIntExact((Long) movieObj.get("year")),
                (String) ((JSONArray) movieObj.get("director")).get(0),
                (String) (((JSONObject) (((JSONArray) movieObj.get("country")).get(0))).get("name"))
                );
        String director = "";
        String country = "";
        for (Object jsonObject : ((JSONArray) movieObj.get("country"))) {
            director += ((JSONObject)jsonObject).get("name").toString() + ", ";
        }
        if (director.length() > 2) director = director.substring(0, director.length() - 2);
        for (Object jsonObject : ((JSONArray) movieObj.get("director"))) {
            country += jsonObject.toString() + ", ";
        }
        if (country.length() > 2) country = country.substring(0, country.length() - 2);

        System.out.println(director);
        System.out.println(country);

        List<Actor> actors = new ArrayList<>();
        for (Object actorName: (JSONArray) movieObj.get("actor")) {
            actors.add(new Actor(
                    0,
                    (String) actorName));
        }
        movie.setActors(actors);
        List<Category> categories = new ArrayList<>();
        for (Object categoryName: (JSONArray) movieObj.get("category")) {
            categories.add(new Category(
                    0,
                        (String) ((JSONObject) categoryName).get("name")
                    )
            );
        }
        movie.setCategorys(categories);
        List<Episode> episodes = new ArrayList<>();
        JSONArray episodeArr = (JSONArray) jo.get("episodes");
        JSONObject episodeObj = (JSONObject) episodeArr.get(0);
        JSONArray episodeArr1 = (JSONArray) episodeObj.get("server_data");
        for (Object episodeItem : episodeArr1) {
            JSONObject episode = (JSONObject) episodeItem;
            episodes.add(new Episode(
                    0,
                    (String) episode.get("name"),
                    (String) episode.get("slug"),
                    (String) episode.get("filename"),
                    (String) episode.get("link_embed"),
                    0
                )
            );
        }
        movie.setEpisodes(episodes);
        return movie;
    }

    public static void main(String[] args) throws ParseException {
        Movie movie = handlerJson("{\n" +
                "  \"status\": true,\n" +
                "  \"msg\": \"\",\n" +
                "  \"movie\": {\n" +
                "    \"modified\": {\n" +
                "      \"time\": \"2022-05-11T16:52:54.000Z\"\n" +
                "    },\n" +
                "    \"_id\": \"627be9e6db9df06c659561ce\",\n" +
                "    \"name\": \"T??nh Y??u v?? Danh D???\",\n" +
                "    \"origin_name\": \"Love and Honor\",\n" +
                "    \"content\": \"<p>Mimura Shinojo chuy??n l??m vi???c n???m th??? th???c ??n cho v??? l??nh ch??a. N???u th???c ??n c?? ch???t ?????c, anh s??? l?? ng?????i b??? m???t m???ng tr?????c. ????y l?? m???t c??ch ????? c??c v?? s?? samurai t??? r?? l??ng trung th??nh c???a m??nh ?????i v???i ch??? nh??n. Trong m???t l???n n???m m??n ???c s??n s???ng c?? ?????c, c??? hai m???t Mimura v??nh vi???n m???t ??nh s??ng. N???i b???t h???nh c???a anh kh??ng d???ng l???i ??? ????. Kh??ng ngu???n sinh s???ng, v??? anh, Kayo bu???c ph???i c???u c???u m???t ng?????i c?? th??? l???c v?? b??? th???t th??n. T??m h???n Mimura r???t ?????i ??au ?????n, b??? gi???ng x?? gi???a m???t b??n l?? danh d??? samurai, m???t b??n l?? t??nh y??u d??nh cho ng?????i v??? th????ng y??u m??nh h???t m???c.</p>\",\n" +
                "    \"type\": \"single\",\n" +
                "    \"status\": \"completed\",\n" +
                "    \"thumb_url\": \"https://img.ophim.tv/uploads/movies/tinh-yeu-va-danh-du-thumb.jpg\",\n" +
                "    \"poster_url\": \"https://img.ophim.tv/uploads/movies/tinh-yeu-va-danh-du-poster.jpg\",\n" +
                "    \"is_copyright\": \"off\",\n" +
                "    \"sub_docquyen\": \"off\",\n" +
                "    \"chieurap\": false,\n" +
                "    \"trailer_url\": \"https://www.youtube.com/watch?v=23Z1KwGATwg\",\n" +
                "    \"time\": \"\",\n" +
                "    \"episode_current\": \"Full\",\n" +
                "    \"episode_total\": \"1\",\n" +
                "    \"quality\": \"HD\",\n" +
                "    \"lang\": \"Vietsub\",\n" +
                "    \"notify\": \"\",\n" +
                "    \"showtimes\": \"\",\n" +
                "    \"slug\": \"tinh-yeu-va-danh-du\",\n" +
                "    \"year\": 2006,\n" +
                "    \"actor\": [\n" +
                "      \"Takuya Kimura\",\n" +
                "      \" Rei Dan\",\n" +
                "      \" Takashi Sasano\"\n" +
                "    ],\n" +
                "    \"director\": [\n" +
                "      \"Y??ji Yamada\", \"D??ng Sobin\"\n" +
                "    ],\n" +
                "    \"category\": [\n" +
                "      {\n" +
                "        \"name\": \"T??nh C???m\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"C??? Trang\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"T??m L??\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"V?? Thu???t\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"country\": [\n" +
                "      {\n" +
                "        \"name\": \"Nh???t B???n\"\n" +
                "      },{\n" +
                "        \"name\": \"Vi???t Nam\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"episodes\": [\n" +
                "    {\n" +
                "      \"server_name\": \"Vietsub #1\",\n" +
                "      \"server_data\": [\n" +
                "        {\n" +
                "          \"name\": \"Full\",\n" +
                "          \"slug\": \"full\",\n" +
                "          \"filename\": \"tinh-yeu-va-danh-du-love-and-honor\",\n" +
                "          \"link_embed\": \"https://aa.nguonphimmoi.com/share/0f0c4533ced2a79ab18a4bb3b6d1bb67\",\n" +
                "          \"link_m3u8\": \"https://aa.nguonphimmoi.com/20220511/15156_b3820e30/index.m3u8\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}");
        System.out.println(movie);

        for (Category actor : movie.getCategorys())
            System.out.println(actor);
        for (Actor actor : movie.getActors())
            System.out.println(actor);
        for (Episode actor : movie.getEpisodes())
            System.out.println(actor);
    }
}

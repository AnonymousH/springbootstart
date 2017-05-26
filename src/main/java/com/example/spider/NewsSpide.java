package com.example.spider;

import com.example.bean.NewBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public class NewsSpide {


//    public static void main(String[] args) {
//        connectUrl(0,9,1495527701094L);
//    }


    public static List<NewBean> connectUrl(int start, int end, long appid) {

        Connection.Response res = null;

        try {

            System.out.println("url-->    " + Constant.DATA_URL  + Constant.DATA_URL2 + start + Constant.DATA_URL3 + end);

            res = Jsoup.connect(Constant.DATA_URL + Constant.DATA_URL2 + start + Constant.DATA_URL3 + end)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate, sdch")
                    .header("Accept-Language", "zh-CN,zh;q=0.8")
                    .header("Connection", "keep-alive")
                    .header("Cookie", "JSESSIONID=9957f4c278548199713a86064da0266ce591dada1d391c3c2a7e23c7bf9f69ac; " +
                            "wuid=818235023472841; wuid_createAt=2017-05-23 16:20:34;" +
                            " captcha=s%3A1eaff7a02de850998677d114519957c4.ZRLbcCXfy1L78pHKtr6arklTle0VPR95rMEy8nsqqCU;" +
                            " Hm_lvt_15fafbae2b9b11d280c79eff3b840e45=1495527634; Hm_lpvt_15fafbae2b9b11d280c79eff3b840e45=1495527761;" +
                            " cn_9a154edda337ag57c050_dplus=%7B%22distinct_id%22%3A%20%2215c3464b6ab38f-0069442cddf41b-474f0820-1fa400-15c3464b6acd94%22%2C%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201495527696%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201495527696%7D;" +
                            " UM_distinctid=15c3464b6ab38f-0069442cddf41b-474f0820-1fa400-15c3464b6acd94; CNZZDATA1255169715=966283166-1495524624-null%7C1495524624")
                    .header("Host", "www.yidianzixun.com")
                    .header("Referer", "http://www.yidianzixun.com/channel/hot")
                    .header("X-Requested-With", "XMLHttpRequest")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                    .timeout(10000).ignoreContentType(true).execute();//.get();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String body = res.body();

        JsonObject returnData = new JsonParser().parse(body).getAsJsonObject();
        JsonArray jsonArray = returnData.getAsJsonArray("result");
        Gson gson = new Gson();


        List<NewBean> retList = gson.fromJson(jsonArray.toString(),
                new TypeToken<List<NewBean>>() {
                }.getType());


        return retList;

    }



}

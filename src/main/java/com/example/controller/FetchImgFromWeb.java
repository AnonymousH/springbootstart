package com.example.controller;

import com.example.bean.SqlDemo;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.util.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/23.
 */
@RestController
@RequestMapping("/fetch")
public class FetchImgFromWeb {

    @RequestMapping("/fetchUrl")
    public void getById(){


        String accessKey = "gCNPFforaECVI9IaUJ6Qcl1WDPSGoQlZ5GbjSUyo";
        String secretKey = "EwQ6EszMlTIv_Fpue-Z038vLK0Ii-Sefw8PvuHZc";
        String bucket = "caojispring";

        Configuration cfg = new Configuration(Zone.zone2());

        Auth auth = Auth.create(accessKey,secretKey);
        BucketManager bm = new BucketManager(auth,cfg);

        String key ="img/web/";

        try {
            FetchRet fetchRet =  bm.fetch("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495533898817&di" +
                    "=dff257663a6d13bb50f0fb38e3b77c09&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F0%2F551cf35a211e6.jpg", bucket,key);

            System.out.println(fetchRet.hash);
            System.out.println(fetchRet.key);
            System.out.println(fetchRet.mimeType);
            System.out.println(fetchRet.fsize);

        } catch (QiniuException e) {
            e.printStackTrace();
        }

    }

}

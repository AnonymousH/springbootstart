package com.example.controller;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Administrator on 2017/5/15.
 */
@Controller
public class FileUploadController {


    @RequestMapping("/file")
    public String file() {
        return "/file";
    }


//    /**
//     * 文件上传具体实现方法;
//     * @param file
//     * @return
//     */
//    @RequestMapping("/upload")
//    @ResponseBody
//    public String handleFileUpload(@RequestParam("file")MultipartFile file){
//        if(!file.isEmpty()){
//            try {
//              /*
//               * 这段代码执行完毕之后，图片上传到了工程的跟路径；
//               * 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
//               * 等等;
//               * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
//               * 1、文件路径；
//               * 2、文件名；
//               * 3、文件格式;
//               * 4、文件大小的限制;
//               */
//                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
//                out.write(file.getBytes());
//                out.flush();
//                out.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return"上传失败,"+e.getMessage();
//            } catch (IOException e) {
//                e.printStackTrace();
//                return"上传失败,"+e.getMessage();
//            }
//            return"上传成功";
//        }else{
//            return"上传失败，因为文件是空的.";
//        }
//    }

    @RequestMapping("/upload")
    @ResponseBody
    public void handleFileUpload27Niu(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {

            System.out.println(file.getOriginalFilename());
            System.out.println(file.getName());
//            System.out.println(file.get());


            Configuration cfg = new Configuration(Zone.zone2());

            UploadManager uploadManager = new UploadManager(cfg);
            //...生成上传凭证，然后准备上传
            String accessKey = "gCNPFforaECVI9IaUJ6Qcl1WDPSGoQlZ5GbjSUyo";
            String secretKey = "EwQ6EszMlTIv_Fpue-Z038vLK0Ii-Sefw8PvuHZc";
            String bucket = "caojispring";
            //如果是Windows情况下，格式是 D:\\qiniu\\test.png
            //默认不指定key的情况下，以文件内容的hash值作为文件名
            String key = null;

            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
//                Response response = uploadManager.put(localFilePath, key, upToken);
                Response response = uploadManager.put(file.getBytes(), key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println("putRet.key-->   "+putRet.key);
                System.out.println("putRet.hash-->   "+putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

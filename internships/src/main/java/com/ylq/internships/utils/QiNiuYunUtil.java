package com.ylq.internships.utils;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class QiNiuYunUtil {

    public static String upLoadImage(MultipartFile file) throws IOException {
        String key = null;
        Auth auth = Auth.create("HJqLq9YqqVhGaOesf2cSMXYFURQqR8BlAiSJyVdS", "Un3ryHrfyWS1IxWWZH16GEMnWd3adUkXmLTFxOW1");
        String upToken = auth.uploadToken("internships");
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        InputStream is = file.getInputStream();
        Response response = uploadManager.put(is,key,upToken,null, null);
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        System.out.println(putRet.key);
        System.out.println(putRet.hash);
        return "http://pqrkfrns8.bkt.clouddn.com/"+putRet.key;
    }
}

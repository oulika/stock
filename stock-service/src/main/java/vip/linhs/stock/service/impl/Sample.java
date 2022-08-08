package vip.linhs.stock.service.impl;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Sample {
    // 设置APPID/AK/SK
    public static final String APP_ID = "xxx";
    public static final String API_KEY = "xxx";
    public static final String SECRET_KEY = "xxx";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        String filePath = "/Users/jin/Desktop/book/xxx.txt";
        System.out.println("---begin---");
        // 调用接口
        for (int i = 4; i < 222; i++) {
            System.out.println("---" + i + "---");
            String path = "/Users/jin/Downloads/img/" + i + ".jpg";
            JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
            JSONArray jsonArray = res.getJSONArray("words_result");
            for (int j = 0; j < jsonArray.length(); j++) {
                JSONObject jsonObject = jsonArray.getJSONObject(j);
                String content = jsonObject.getString("words");
                addContent(filePath, content);
            }
        }
        System.out.println("---over---");

    }

    public static void addContent(String path, String content) {
        FileWriter fw = null;
        try {
            // 如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f = new File(path);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.yst.common.utils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2017/5/21.
 */
public class ImageEnableUtil {

    private static URL urlStr;
    private static HttpURLConnection connection;
    private static int state = -1;
    private static String succ;

    public static String isConnect(String url) {
        int counts = 0;
        succ = null; if (url == null || url.length() <= 0) { return succ; }
        while (counts < 5) {
            try {
                urlStr = new URL(url);
                connection = (HttpURLConnection) urlStr.openConnection();
                state = connection.getResponseCode();
                if (state == 200) {
                    succ = connection.getURL().toString();
                }
                break;
            } catch (Exception ex) {
                counts++;
                ex.printStackTrace();
                continue;
            }
        }
        return succ;
    }

    public static void main(String[] args) {
        System.out.println(ImageEnableUtil.isConnect("http://60.190.63.14:90/img/2847.jpg"));
    }
}


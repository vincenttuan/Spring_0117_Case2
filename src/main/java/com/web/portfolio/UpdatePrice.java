package com.web.portfolio;

import java.net.URL;
import java.util.Scanner;

public class UpdatePrice {

    public static void main(String[] args) throws Exception {
        while (true) {
            new Thread() {
                public void run() {
                    try {
                        String url = "http://localhost:8080/SpringMVC/mvc/portfolio/price/refresh";
                        Scanner sc = new Scanner(new URL(url).openStream()).useDelimiter("\\A");
                        System.out.println(sc.next());
                    } catch (Exception e) {
                    }
                }
            }.start();
            Thread.sleep(5000);
        }
    }
}

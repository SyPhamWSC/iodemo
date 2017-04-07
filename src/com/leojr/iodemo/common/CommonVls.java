package com.leojr.iodemo.common;

import java.io.*;

public class CommonVls {

    public static final String APP_NAME = "IO in Java";

    public static final int COUNT_WORD_WIDTH = 400;
    public static final int COUNT_WORD_HEIGHT = 200;

    public static final int LIST_FILE_WIDTH = 400;
    public static final int LIST_FLIE_HEIGHT = 200;

    public static final int SEARCH_FILE_WIDTH = 400;
    public static final int SEARCH_FILE_HEIGHT = 300;

    public static final int WIDTH_GUI = 350;
    public static final int HEIGHT_GUI = 130;

    private static CommonVls instance;
    private CommonVls(){

    }
    public static CommonVls getInstance(){
        if(instance == null){
            instance = new CommonVls();
        }
        return instance;
    }
    public String readFile(File file) throws IOException {
        String result = "";
        String temp = null;
        InputStream in = new FileInputStream(file);
        Reader reader = new InputStreamReader(in,"UTF-8");
        BufferedReader br = new BufferedReader(reader);

        while ((temp = br.readLine()) != null){
            result = result + temp + " ";
        }
        br.close();
        return result;
    }

}

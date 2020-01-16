package com.reportdesigner.container.util;

import java.io.*;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2020/1/16 18:33
 * @Description :文件读写util
 */
public class FileUtil {


    public static void writeDataTo(String filename, String jsonString) throws IOException {

        File file = new File("D://reportDesigner/"+filename);
        if(file.exists()){
            file.delete();
        }
        FileOutputStream fileOutStream = new FileOutputStream(file);
        DataOutputStream dataOutputStream =  new DataOutputStream(fileOutStream);
        dataOutputStream.writeBytes(jsonString);
        dataOutputStream.flush();
        dataOutputStream.close();
    }
}

package com.reportdesigner.container.util;

import java.io.*;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2020/1/16 18:33
 * @Description :文件读写util
 */
public class FileUtil {


    public static void writeDataTo(String filename, Object object) throws IOException {

        File file = new File("D://reportDesigner/"+filename);
        if(file.exists()){
            file.delete();
        }
        FileOutputStream fileOutStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static Object readFileToData(String filename) throws IOException, ClassNotFoundException {

        File file = new File("D://reportDesigner/"+filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object object = objectInputStream.readObject();
        return object;
    }
}

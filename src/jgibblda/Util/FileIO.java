package jgibblda.Util;

import java.io.*;


public class FileIO {
    public static String readToString(String filePath){
        return readToString(filePath, "utf8");
    }

    public static String readToString(String filePath, String encoding) {
        File file= new File(filePath);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    public static int writeToFile(String filePath,String content){
        int ret=0;
        FileWriter fw= null;
        try {
            fw = new FileWriter(filePath);
            PrintWriter out=new PrintWriter(fw);
            out.print(content);
            out.close();
            fw.close();
            return  ret;
        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            ret=1;
            return ret;
        }

    }
}

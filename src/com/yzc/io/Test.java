package com.yzc.io;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        File file = new File("F:\\\\yzc\\\\denglu.html");
        File out =new File("F:\\yzc\\a.txt\\"+file.getName());
//字节流输出
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file,true);
            outputStream.write("sadas".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//字节流输入
        InputStream is = null;
        try {
            is=new FileInputStream(file);
            byte[] b = new byte[(int)file.length()];
                is.read();
                for (byte a:b){
                    System.out.println((char)a);
                }
                is.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//字符流输出
        Writer writer = null;
        try {
            writer = new FileWriter(file,true);
            writer.write("sdaa,中文");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//字符流输入
        Reader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int)file.length()];
            reader.read(chars);
            System.out.println(new String(chars));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//文件复制
        char[] chars = new char[512];
        Reader reader1 = null;
        Writer writer1 = null;
        try {
            reader1 = new FileReader(file);
            writer1 = new FileWriter(out);
            int a = reader1.read(chars);
            while (a != -1){
                writer.write(new String(chars),0,a);
                a = reader1.read(chars);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader1.close();
                writer1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//字节流字符流转换
        try {
            FileInputStream fis = new FileInputStream("D:/abc.text");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bf = new BufferedReader(isr);
            String str = null;
            try {
                if ((str=bf.readLine()) != null){
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bf.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//安行读写
        File readFile = new File("D://a.text");
        File writeFile = new File("D://b.text");
        BufferedReader reader2 = null;
        OutputStream writer2 = null;
        try {
            reader2 = new BufferedReader(new FileReader(readFile));
            writer2 = new FileOutputStream(writeFile);
            String str1 = null;
            int line = 1;
            while ((str1 = reader2.readLine()) != null){
                System.out.println(line+str1);
                line++;
            }
            try {
                reader2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.pro.common.xss;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @author chenyao
 * date 2021-03-01
 */
@Data
@AllArgsConstructor
class A{
    private String a;
}
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    public  int staticVar = 5;

    public static void main(String[] args) {
        try {
            Test t = new Test();
            t.staticVar = 5;
            //初始时staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(new Test());
            out.close();

            //序列化后修改为10
            t.staticVar = 10;

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            Test ta = (Test) oin.readObject();
            oin.close();

            //再读取，通过t.staticVar打印新的值
            System.out.println(ta.staticVar);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

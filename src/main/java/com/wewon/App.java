package com.wewon;

import com.wewon.service.ClearRecycleBinSrv;
import com.wewon.service.ClearRecycleBinSrvImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
//    public static void main( String[] args )
//    {
//        // 默认是清空回收站30天以前的文件和文件夹
//        Integer pastDays = new Integer(30);
//        if (args.length > 0) {
//            try {
//                pastDays = Integer.valueOf(args[0]) ;
//            } catch (NumberFormatException e) {
//                System.out.println("由于输入的参数不是数字，pastDays取默认值："+ pastDays);
//            }
//        }
//        ClearRecycleBinSrv  clearRecycleBinSrv = new ClearRecycleBinSrvImpl();
//        if (clearRecycleBinSrv.clearOldFile(pastDays)) {
//            System.out.println("回收站里" + pastDays + "天前的文件已被清空");
//        }
//    }
public App(int value) {
//    this.value = value;
}
    public static void main(String[] args){
        Integer x = Integer.parseInt("-3") ;
//        int resuslt = 0;
        App app = new App(3);
//        App app =3;
//        resuslt = app.bitCalc(2);
//        System.out.println(resuslt);
        Map<String,Object> result = new HashMap();
//        String x= "1";
        String y = "2";
//        result = app.swap(x,y);
//        x= (String) result.get("x");
//        y= (String) result.get("y");
        System.out.println(x);
        System.out.println(y);
    }
    private int bitCalc(int x){
        x=x<< 3;
        return x;
    }
    private Map<String,Object> swap (String x,String y){
        Map<String,Object> result = new HashMap();
        String c = new String();
        c=x;
        x=y;
        y=c;
        result.put("x",x);
        result.put("y",y);
        return result;
    }
}

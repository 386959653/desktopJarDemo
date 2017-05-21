package com.wewon;

import com.wewon.service.ClearRecycleBinSrv;
import com.wewon.service.ClearRecycleBinSrvImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // 默认是清空回收站30天以前的文件和文件夹
        Integer pastDays = new Integer(30);
        if (args.length > 0) {
            try {
                pastDays = Integer.valueOf(args[0]) ;
            } catch (NumberFormatException e) {
                System.out.println("由于输入的参数不是数字，pastDays取默认值："+ pastDays);
            }
        }
        ClearRecycleBinSrv  clearRecycleBinSrv = new ClearRecycleBinSrvImpl();
        if (clearRecycleBinSrv.clearOldFile(pastDays)) {
            System.out.println("回收站里" + pastDays + "天前的文件已被清空");
        }
    }
}

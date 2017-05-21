package com.wewon.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Wewon on 2017/5/13 21:49
 */
public class ClearRecycleBinSrvImpl implements ClearRecycleBinSrv {
    public Boolean clearOldFile(Integer pastDays) {
        Boolean returnValue = new Boolean(false);
        List<String> recycleBinPathList = recycleBinPathList();
        for(String path : recycleBinPathList) {
            File directory = FileUtils.getFile(path);
            try {
                for (File file : directory.listFiles()) {
                    String fileName = file.getName();
                    String filePath = file.getAbsolutePath();
//                获取文件的后缀名，如果没有后缀名，就返回“.”前面的名字，如果该文件是文件夹就不会有后缀名
                    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    // 这个是回收站自带的桌面配置文件，不需要删除
                    if (suffix.equalsIgnoreCase("ini")) {
                        continue;
                    }
                    // 获取文件的修改时间，这个修改时间也就是文件的删除时间
                    long deleteTime = file.lastModified();
                    long now = new Date().getTime();
                    long between_days = (now - deleteTime) / (1000 * 3600 * 24);
                    if (between_days >= pastDays) {
                        // 解决了文件夹里有只读文件该文件夹删除不掉的问题
                        if (file.isDirectory()){
                            FileUtils.deleteDirectory(file);
                        }else {
                            file.deleteOnExit();
                        }
                        System.out.println(filePath + " 已从回收站清除");
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        returnValue = true;
        return returnValue;
    }

    // 清楚文件的可读属性
    private void clearReadonly(String absolutePath) throws IOException {
        Runtime.getRuntime().exec("cmd /c attrib "+absolutePath+" -r -a -s -h");
        System.out.println("文件: "+absolutePath+" 已去除只读属性！");
    }

    public List<String> recycleBinPathList(){
        List<String> recycleBinPathList = new ArrayList<String>();
        // 列出所有windows 磁盘
        File[] fs = File.listRoots();
        // 显示磁盘卷标
        for (int i = 0; i < fs.length; i++) {
            // 过滤有些可移动存储设备会显示盘符，实际却是不存在的情况
            if (fs[i].exists()) {
                String path = fs[i].getPath() + "$RECYCLE.BIN";
                path = path.replace("\\", "//");
                File directory = FileUtils.getFile(path);
//                过滤有些可移动存储设备存在，但没有回收站文件夹的情况
                if (directory.exists()) {
                    for (File file : directory.listFiles()) {
                        recycleBinPathList.add(file.getPath().replace("\\", "//"));
//                        System.out.println(file.getPath().replace("\\", "//"));
                    }
                }
            }
        }
        return recycleBinPathList;
    }


}

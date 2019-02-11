package com.learnyeai.tools.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/16 0016.
 */
public class FolderUtil {
    //获取文件夹下面所有的文件
    public static List<File> getFiles(String path, String suffix){
        List<File> resultList = new ArrayList<File>();

        List<File> list = new ArrayList<File>();
        File f = new File(path);
        getFileList(f,list);

        if(list!=null&&list.size()>0){
            for(File item:list){
                String filePath = item.getPath();
                String suffixValue = filePath.substring(filePath.lastIndexOf(".") + 1);
                if(suffix.equals(suffixValue)){
                    resultList.add(item);
                }
            }
        }
        return resultList;
    }

    public static void getFileList(File f,List<File> fileList){
        if (!f.exists()) {
            System.out.println(f.getPath() + " not exists");
        }
        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                getFileList(fs,fileList);
            }else {
                fileList.add(fs);
            }
        }
    }
}

package com.wewon.service;

import java.util.List;

/**
 * Created by Wewon on 2017/5/13.
 */
public interface ClearRecycleBinSrv {
    Boolean clearOldFile(Integer pastDays);
    List<String> recycleBinPathList();
}

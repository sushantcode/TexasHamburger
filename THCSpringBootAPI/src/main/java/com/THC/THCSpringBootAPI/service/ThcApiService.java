package com.THC.THCSpringBootAPI.service;

import com.THC.THCSpringBootAPI.model.ApiExecutionInfo;

import java.util.List;

public interface ThcApiService {

    void pushApiExecutionInfo(ApiExecutionInfo apiExecutionInfo);
    List<ApiExecutionInfo> apiExecutionInfoByName(String queryName);
    List<ApiExecutionInfo> apiExecutionInfoByDate(String queryDate);
}

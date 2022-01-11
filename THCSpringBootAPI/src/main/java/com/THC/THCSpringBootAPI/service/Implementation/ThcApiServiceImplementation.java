package com.THC.THCSpringBootAPI.service.Implementation;

import com.THC.THCSpringBootAPI.model.ApiExecutionInfo;
import com.THC.THCSpringBootAPI.repo.ApiExecutionTimeMysqlRepository;
import com.THC.THCSpringBootAPI.service.ThcApiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThcApiServiceImplementation implements ThcApiService {

    private static final Logger logger = LogManager.getLogger(ThcApiServiceImplementation.class);

    @Autowired
    private ApiExecutionTimeMysqlRepository apiExecutionTimeMysqlRepository;

    @Override
    public boolean pushApiExecutionInfo(ApiExecutionInfo apiExecutionInfo) {
        try {
            apiExecutionTimeMysqlRepository.save(apiExecutionInfo);
            return true;
        } catch (Exception e) {
            logger.error("Failed to push api execution Time to database because " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<ApiExecutionInfo> apiExecutionInfoByName(String queryName) {
        try {
            return apiExecutionTimeMysqlRepository.findByName(queryName);
        } catch (Exception e) {
            logger.error("Failed to push api execution Time to database because " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<ApiExecutionInfo> apiExecutionInfoByDate(String queryDate) {
        try {
            return apiExecutionTimeMysqlRepository.findByDate(queryDate);
        } catch (Exception e) {
            logger.error("Failed to push api execution Time to database because " + e.getMessage());
            return null;
        }
    }
}

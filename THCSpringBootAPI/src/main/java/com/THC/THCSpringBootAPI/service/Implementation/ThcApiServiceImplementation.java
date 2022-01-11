package com.THC.THCSpringBootAPI.service.Implementation;

import com.THC.THCSpringBootAPI.model.ApiExecutionInfo;
import com.THC.THCSpringBootAPI.repo.ApiExecutionTimeMysqlRepository;
import com.THC.THCSpringBootAPI.service.ThcApiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class ThcApiServiceImplementation implements ThcApiService {

    private static final Logger logger = LogManager.getLogger(ThcApiServiceImplementation.class);

    @Autowired
    private ApiExecutionTimeMysqlRepository apiExecutionTimeMysqlRepository;

    @Override
    public void pushApiExecutionInfo(ApiExecutionInfo apiExecutionInfo) {
        Pattern pattern = Pattern.compile("/api/.*");
        boolean isMatch = pattern.matcher(apiExecutionInfo.getName()).matches();
        if (isMatch) {
            try {
                apiExecutionTimeMysqlRepository.save(apiExecutionInfo);
            } catch (Exception e) {
                logger.error("Failed to push api execution Time to database because " + e.getMessage());
            }
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

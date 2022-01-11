package com.THC.THCSpringBootAPI.interceptor;

import com.THC.THCSpringBootAPI.model.ApiExecutionInfo;
import com.THC.THCSpringBootAPI.service.ThcApiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Component
public class ThcAPIInterceptor implements HandlerInterceptor {

    private static final Logger logger = LogManager.getLogger(ThcAPIInterceptor.class);

    @Autowired
    private ThcApiService thcApiService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("pre api call handler ");
        long startTime = System.currentTimeMillis();
        request.setAttribute("executionTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("Post handle method - check execution time of handling ");
        String name = request.getServletPath();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currDate = new Date();
        String date = dateFormat.format(currDate);
        long startTime = (Long) request.getAttribute("executionTime");
        long executionTime = System.currentTimeMillis() - startTime;
        ApiExecutionInfo apiExecutionInfo = new ApiExecutionInfo();
        apiExecutionInfo.setName(name);
        apiExecutionInfo.setDate(date);
        apiExecutionInfo.setExecutionTime(executionTime);
        apiExecutionInfo.setTimestamp(new Timestamp(System.currentTimeMillis()));
        thcApiService.pushApiExecutionInfo(apiExecutionInfo);
    }
}

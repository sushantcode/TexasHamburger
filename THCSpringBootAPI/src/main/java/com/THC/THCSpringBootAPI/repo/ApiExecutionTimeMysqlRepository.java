package com.THC.THCSpringBootAPI.repo;

import com.THC.THCSpringBootAPI.model.ApiExecutionInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiExecutionTimeMysqlRepository extends PagingAndSortingRepository<ApiExecutionInfo, String> {
    List<ApiExecutionInfo> findByName(String name);
    List<ApiExecutionInfo> findByDate(String date);
}

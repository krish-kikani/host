package com.Host.Host.services;

import com.Host.Host.dao.VisitDao;
import com.Host.Host.dto.VisitDTO;
import com.Host.Host.entities.Visit;
import com.Host.Host.enums.VisitEnum;
import com.Host.Host.manager.VisitManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VisitService {
    @Autowired
    private final VisitDao visitDao;

    public long count = 0;

    public VisitService(VisitDao visitDao){
        this.visitDao = visitDao;
    }
    public Visit saveVisit(VisitDTO visitDTO){
        Visit visit = new Visit();
        visit.setLongUrl(visitDTO.getLongUrl());
        visit.setKeyword(visitDTO.getKeyword());
        visit.setStatus(VisitEnum.Status.ACTIVE.name());
        visit.setCount(visitDTO.getCount());
        visit.setCreatedAt(visitDTO.getCreatedAt());
        visit.setUpdatedAt(visitDTO.getUpdatedAt());
        return visitDao.save(visit);
    }

    public void incrementCount(){
        count++;
    }
    public long getCount(){
        return count;
    }

}

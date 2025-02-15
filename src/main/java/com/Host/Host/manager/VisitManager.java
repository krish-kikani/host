package com.Host.Host.manager;

import com.Host.Host.dto.VisitDTO;
import com.Host.Host.entities.Visit;
import com.Host.Host.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VisitManager {
    @Autowired
    private VisitService visitService;

    public Visit createVisit(VisitDTO hostDTO){
        if(hostDTO.getLongUrl() == null || hostDTO.getLongUrl().isEmpty()){
            throw new IllegalIdentifierException("empty");
        }
        return VisitService.saveVisit(hostDTO);
    }
}

package com.Host.Host.controller;

import com.Host.Host.dao.VisitDao;
import com.Host.Host.dto.VisitDTO;
import com.Host.Host.entities.Visit;
import com.Host.Host.manager.VisitManager;
import com.Host.Host.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(name = "guest")
public class VisitController {

    VisitManager hostManager;
    @Autowired
    private VisitService hostService;

    public VisitController(VisitManager manager) {
        this.hostManager = manager;
    }

    @Autowired
    VisitDao HostDao;

    @GetMapping("/get")
    public List<VisitDao> getAllGuest(){
        List<VisitDao> visit = HostDao.findAll();
        return visit;
    }

    @PostMapping()
    public ResponseEntity<Visit> addVisit(@RequestBody VisitDTO visitDTO){
        Visit visit = VisitManager.createVisit(visitDTO);
        return new ResponseEntity<>(visit, HttpStatus.CREATED);
    }

    @GetMapping("/visit")
    public String visit(){
        VisitService.incrementCount();
        return "visits: " + hostService.getCount();
    }

}
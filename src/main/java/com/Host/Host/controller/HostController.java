package com.Host.Host.controller;

import com.Host.Host.dao.HostDao;
import com.Host.Host.dto.HostDTO;
import com.Host.Host.manager.HostManager;
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
public class HostController {

    @Autowired
    HostDao HostDao;

    @GetMapping("/get")
    public List<HostDao> getAllGuest(){
        List<HostDao> host = HostDao.findAll();
        return host;
    }

    @PostMapping()
    public HostDao addHost(@RequestBody HostDTO hostDTO){
        Host host  = HostManager.createHost(hostDTO);
        return new ResponseEntity<>(host, HttpStatus.CREATED);

    }
}

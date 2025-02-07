package com.Host.Host.controller;

import com.Host.Host.dao.HostDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

   /* @PostMapping
    public ResponseEntity<Host> = createHost()
    }*/
}

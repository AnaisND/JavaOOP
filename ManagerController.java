package anaisnd.example.hotel.controllers;

import anaisnd.example.hotel.domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import anaisnd.example.hotel.serv.ManagerService;
import java.util.*;

@RestController
@RequestMapping("/data/man")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @GetMapping
    public ResponseEntity<List<Manager>> getTotiManagerii(){
        return new ResponseEntity<List<Manager>>(managerService.TotiManagerii(), HttpStatus.OK);
    }
}
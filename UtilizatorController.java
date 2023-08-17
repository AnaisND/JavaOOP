package anaisnd.example.hotel.controllers;

import anaisnd.example.hotel.domain.Utilizator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import anaisnd.example.hotel.serv.UtilizatorService;
import java.util.*;

@RestController
@RequestMapping("/data/util")
public class UtilizatorController {

    @Autowired
    private UtilizatorService utilizatorService;
    @GetMapping
    public ResponseEntity<List<Utilizator>> getTotiUtilizatorii(){
        return new ResponseEntity<List<Utilizator>>(utilizatorService.TotiUtilizatorii(), HttpStatus.OK);
    }
}

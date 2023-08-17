package anaisnd.example.hotel.controllers;

import anaisnd.example.hotel.domain.Rezervare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import anaisnd.example.hotel.serv.RezervareService;
import java.util.*;

@RestController
@RequestMapping("/data/rez")
public class RezervareController {

    @Autowired
    private RezervareService rezervareService;
    @GetMapping
    public ResponseEntity<List<Rezervare>> getToateRezervarile(){
        return new ResponseEntity<List<Rezervare>>(rezervareService.ToateRezervarile(), HttpStatus.OK);
    }
}


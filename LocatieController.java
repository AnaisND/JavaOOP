package anaisnd.example.hotel.controllers;

import anaisnd.example.hotel.domain.Locatie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import anaisnd.example.hotel.serv.LocatieService;
import java.util.*;

@RestController
@RequestMapping("/data/loc")
public class LocatieController {

    @Autowired
    private LocatieService locatieService;
    @GetMapping
    public ResponseEntity<List<Locatie>> getToateLocatiile(){
        return new ResponseEntity<List<Locatie>>(locatieService.ToateLocatiile(), HttpStatus.OK);
    }
}

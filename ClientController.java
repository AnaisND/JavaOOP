package anaisnd.example.hotel.controllers;

import anaisnd.example.hotel.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import anaisnd.example.hotel.serv.ClientService;
import java.util.*;

@RestController
@RequestMapping("/data/cl")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping
    public ResponseEntity<List<Client>> getTotiClientii(){
        return new ResponseEntity<List<Client>>(clientService.TotiClientii(), HttpStatus.OK);
    }
}
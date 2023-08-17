package anaisnd.example.hotel.controllers;

import anaisnd.example.hotel.domain.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import anaisnd.example.hotel.serv.CameraService;
import java.util.*;

@RestController
@RequestMapping("/data/cam")
public class CameraController {

    @Autowired
    private CameraService cameraService;
    @GetMapping
    public ResponseEntity<List<Camera>> getToateCamerele(){
        return new ResponseEntity<List<Camera>>(cameraService.ToateCamerele(), HttpStatus.OK);
    }
}
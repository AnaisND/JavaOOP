package anaisnd.example.hotel.serv;

import anaisnd.example.hotel.domain.Camera;
import anaisnd.example.hotel.repo.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cameraRepository;
    public List<Camera> ToateCamerele(){
        return cameraRepository.findAll();
    }
}

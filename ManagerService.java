package anaisnd.example.hotel.serv;

import anaisnd.example.hotel.domain.Manager;
import anaisnd.example.hotel.repo.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;
    public List<Manager> TotiManagerii(){
        return managerRepository.findAll();
    }
}
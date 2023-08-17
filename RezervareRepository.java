package anaisnd.example.hotel.repo;
import anaisnd.example.hotel.domain.Rezervare;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervareRepository extends MongoRepository<Rezervare, ObjectId> {
}

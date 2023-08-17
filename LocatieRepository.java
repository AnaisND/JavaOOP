package anaisnd.example.hotel.repo;
import anaisnd.example.hotel.domain.Locatie;
import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatieRepository extends MongoRepository<Locatie, ObjectId> {
}

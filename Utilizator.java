package anaisnd.example.hotel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "Utilizator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilizator {
    @Id
    private ObjectId ID;
    private String Email;
    private String Parola;
    @DocumentReference
    private Client Client_;
}

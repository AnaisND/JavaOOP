package anaisnd.example.hotel.domain;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "Client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    private ObjectId ID;
    private String Nume;
    private String Prenume;
    private int Varsta;
    private String Telefon;
}

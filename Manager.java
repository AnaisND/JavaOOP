package anaisnd.example.hotel.domain;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "Manager")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    @Id
    private ObjectId ID;
    private String Nume;
    private String Prenume;
    private int Varsta;
    private String Telefon;
    private String Email;
    private String Parola;
}


package anaisnd.example.hotel.domain;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Document(collection = "Camera")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Camera {
    @Id
    private ObjectId ID;
    private String Tip;
    private int Pret;
    private String Detalii;
    private char Stare;
}


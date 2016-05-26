package mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by doppler on 2016/5/26.
 */
@Document(collection = "cc")
public class CC {
    @Id
    private String id;
    @Field(value = "name")
    private int name;
    @Field(value = "note")
    private String note;

    public void setNote(String note) {
        this.note = note;
    }

    public void setName(int name) {
        this.name = name;
    }
}

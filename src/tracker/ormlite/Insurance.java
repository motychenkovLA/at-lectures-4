package tracker.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@DatabaseTable(tableName = "insurances")

public class Insurance {
    @DatabaseField(id = true)
    private Integer id;
    @DatabaseField(columnName =  "name")
    private String name;
    @DatabaseField(columnName =  "number")
    private String number;
    @DatabaseField(columnName =  "publicId")
    private Integer publicId;
}

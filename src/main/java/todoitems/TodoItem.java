package todoitems;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class TodoItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length = 64)
    private Integer id;

    @Column(length = 140)
    private String itemName;

    private Boolean done;

    private String timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }



}
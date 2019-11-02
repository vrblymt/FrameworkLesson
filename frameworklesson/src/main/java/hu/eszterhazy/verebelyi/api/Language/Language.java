package hu.eszterhazy.verebelyi.api.Language;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="language")
public class Language {

    @Id
    @Column(name = "language_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_update", nullable = false)
    private Date last_update;

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_update=" + last_update +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Language(String name) {
        this.name = name;
    }

    public Language() {
    }
}

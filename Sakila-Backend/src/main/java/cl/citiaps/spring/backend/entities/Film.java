package cl.citiaps.spring.backend.entities;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
/*
* INSERT INTO film (title, description, release_year, last_update, language_id) VALUES('my film', 'only film',(1900),TIMESTAMP '2005-05-13 07:15:31.123456789', 1);
* Minima informacion para insertar datos a film.
*
* */

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="film_id", unique=true, nullable=false)
    private int filmId;

    @Column(name="title", nullable=false, length=45)
    private String title;

    @Column(name="description", nullable=false, length=45)
    private String description;

    @Column(name="release_year", nullable=false)
    private Date releaseYear;

    @Column(name="language_id", nullable=false)
    private int languageId;

    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;

    public Film(){}

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

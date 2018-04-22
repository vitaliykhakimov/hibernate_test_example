package vitalik.hibernate.dao.Model;

import javax.persistence.*;

@Entity
@Table(name = "book", schema = "ibatestdb")
public class Book {
    private int id;
    private String title;
    private String author;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 20)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author", nullable = true, length = 50)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Книга{" +
                "ID=" + id +
                ", Название='" + title + '\'' +
                ", Автор='" + author + '\'' +
                '}';
    }
}

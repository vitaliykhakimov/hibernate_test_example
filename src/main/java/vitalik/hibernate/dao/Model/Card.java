package vitalik.hibernate.dao.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "card", schema = "ibatestdb")
public class Card {
    private int id;
    private Date date;
    private Client clientByClientId;
    private Book bookByBookId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Карточка{" +
                "ID=" + id +
                ", Дата=" + date +
                ", Клиент=" + clientByClientId.getName() +
                ", Книга=" + bookByBookId.getTitle() +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) { this.bookByBookId = bookByBookId; }

}

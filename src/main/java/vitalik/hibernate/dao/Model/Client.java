package vitalik.hibernate.dao.Model;

import javax.persistence.*;

@Entity
@Table(name = "client", schema = "ibatestdb")
public class Client {
    private int id;
    private String name;
    private int age;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Клиент{" +
                "ID=" + id +
                ", Имя='" + name + '\'' +
                ", Возраст=" + age +
                '}';
    }
}

package com.example.test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="car")
@Table
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String vendor) {
        this.photo = vendor;
    }
    @Column
    private String name;
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    @Column
    private String photo;
    @Column
    String price;
    public Car(String name,String photo) {
        this.name = name;
        this.photo = photo;
    }

    public Car(String name,String photo, String price) {
        this.name = name;
        this.photo = photo;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vendor='" + photo + '\'' +
                '}';
    }

    public Car(){

    }
    //    @ManyToMany(mappedBy = "carList")
//    private List<User> userList;
////    @JoinTable(name = "comment",joinColumns = {@JoinColumn(name = "voiture_id")},inverseJoinColumns = {@JoinColumn(name = "idVoiture")})
////    @ManyToOne
////    @Embedded
////    private List<Comment> comments;
}

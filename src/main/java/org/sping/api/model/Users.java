package org.sping.api.model;

import javax.persistence.*;
//import java.io.Serializable;
import java.util.List;

@Entity
public class Users {
//    implements Serializable
//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;

    private String userName;

//    @org.springframework.data.annotation.Transient
    private transient String password;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userName" , referencedColumnName = "userName")
//    private List<Blog> blog;
//
//    public List<Blog> getBlog() {
//        return blog;
//    }
//
//    public void setBlog(List<Blog> blog) {
//        this.blog = blog;
//    }
//
    public Users(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

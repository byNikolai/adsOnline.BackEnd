package ru.skypro.homework.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skypro.homework.dto.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String phone;
    @NotNull
    private String password;
    private boolean enable;
    @OneToOne(cascade = CascadeType.ALL)
    private Avatar avatar;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Ads> ads;
    @Enumerated(EnumType.STRING)
    private Role role;
}
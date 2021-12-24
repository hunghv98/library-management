package com.hunghv1998.authorbooks.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hunghv1998.authorbooks.common.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email(message = "Provide a valid email")
    private String email;

    @Column(nullable = false, length = 20)
    @Min(value = 5, message = "password must have at least 5 char")
    private String password;

    @Column
    private int active;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "gender", nullable = false)
    private Gender gender;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private Set<Role> roles;

}

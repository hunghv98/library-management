package com.hunghv1998.authorbooks.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "hunghoang")
@NoArgsConstructor
public class TestEntity {

    @Id
    @GeneratedValue(generator = "UUID5")
    @GenericGenerator(name = "UUID5",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                @Parameter( name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy")
            })
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column
    private String name;

}

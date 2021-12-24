package com.hunghv1998.authorbooks.entity;

import com.hunghv1998.authorbooks.common.BookType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
//    @SequenceGenerator(
//            name = "book_sequence",
//            sequenceName = "book_sequence")
    @GeneratedValue(generator = "UUID5")
    @GenericGenerator(name = "UUID5",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter( name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy")
            })
    @Column()
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer totalPage;

    @Column(nullable = false)
    private String categories;

    @Enumerated(value = EnumType.STRING)
//    @Column(columnDefinition = "book_type", nullable = false)
    private BookType bookType;

    @Column(columnDefinition = "integer default 0")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Borrow> borrows;


}

package com.hunghv1998.authorbooks;

import com.hunghv1998.authorbooks.common.BookType;
import com.hunghv1998.authorbooks.entity.Book;
import com.hunghv1998.authorbooks.entity.TestEntity;
import com.hunghv1998.authorbooks.repository.BookRepository;
import com.hunghv1998.authorbooks.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        TestEntity testEntity1 = new TestEntity();
        testEntity1.setName("Hoang Van Hung");

        testRepository.save(testEntity1);

        TestEntity testEntity2 = new TestEntity();
        testEntity2.setName("John Wick");

        testRepository.save(testEntity2);

        Book book1 = new Book();
        book1.setBookType(BookType.Electronic);
        book1.setName("Harry Potter");
        book1.setCategories("magic");
        book1.setTotalPage(350);
        book1.setQuantity(7);

        bookRepository.save(book1);
    }
}

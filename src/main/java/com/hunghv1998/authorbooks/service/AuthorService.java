package com.hunghv1998.authorbooks.service;

import com.hunghv1998.authorbooks.entity.Author;
import com.hunghv1998.authorbooks.repository.AuthorRepository;
import com.hunghv1998.authorbooks.repository.AuthorSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {

    @Autowired
    private AuthorSpecification spec;

    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("id not found"));
    }

    public Author findByEmail(String email) {
        return authorRepository.findOne(Specification.where(spec.hasEmail(email)))
                .orElseThrow(() -> new NoSuchElementException("Email not found"));
    }

    public List<Author> findBetweenAge(int age1, int age2) {
        return authorRepository.findAll(Specification.where(spec.youngerThan(age2)
                .and(spec.olderThan(age1))));
    }
}

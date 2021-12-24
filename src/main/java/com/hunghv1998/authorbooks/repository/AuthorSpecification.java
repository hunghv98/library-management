package com.hunghv1998.authorbooks.repository;

import com.hunghv1998.authorbooks.entity.Author;
import com.hunghv1998.authorbooks.entity.Author_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecification{

    public Specification<Author> hasEmail(String email) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Author_.EMAIL), email);
    }

    public Specification<Author> hasCountry(String country) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Author_.COUNTRY), country);
    }

    public Specification<Author> olderThan(int age) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get(Author_.AGE), age);
    }

    public Specification<Author> youngerThan(int age) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get(Author_.AGE), age);
    }

}

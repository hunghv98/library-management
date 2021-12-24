package com.hunghv1998.authorbooks.repository;

import com.hunghv1998.authorbooks.entity.Author;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    Optional<Author> findById(Long id);


    @Override
    Optional<Author> findOne(Specification<Author> spec);

    @Override
    List<Author> findAll(Specification<Author> spec);
}

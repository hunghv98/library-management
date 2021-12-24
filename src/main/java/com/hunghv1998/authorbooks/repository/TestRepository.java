package com.hunghv1998.authorbooks.repository;

import com.hunghv1998.authorbooks.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestRepository extends JpaRepository<TestEntity, UUID> {

}

package com.bmn.e_commerce.repositories;

import com.bmn.e_commerce.models.Path;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PathRepository extends JpaRepository<Path, Long> {

    Optional<Path> findByName(String fileName);
}

package com.bmn.e_commerce.repositories;

import com.bmn.e_commerce.models.Category;
import com.bmn.e_commerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

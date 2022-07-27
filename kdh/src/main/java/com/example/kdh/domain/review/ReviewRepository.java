package com.example.kdh.domain.review;

import com.example.kdh.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<User, String> {
}

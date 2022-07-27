package com.example.kdh.domain.business_hours;

import com.example.kdh.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessHoursRepository extends JpaRepository<User, String> {
}

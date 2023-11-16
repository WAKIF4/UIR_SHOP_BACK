package com.eclipse.UirShop.repositories;

import com.eclipse.UirShop.entities.User;
import com.eclipse.UirShop.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRole(Role role);
}

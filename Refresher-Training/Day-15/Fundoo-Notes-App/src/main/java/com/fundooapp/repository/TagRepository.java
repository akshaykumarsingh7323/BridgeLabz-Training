package com.fundooapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundooapp.entity.Tag;
import com.fundooapp.entity.User;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByNameAndUser(String name, User user);

    List<Tag> findByUser(User user);
}
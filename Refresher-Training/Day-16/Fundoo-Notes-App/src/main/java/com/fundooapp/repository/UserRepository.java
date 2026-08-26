package com.fundooapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundooapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

	Optional<User> findByResetToken(String resetToken);

	// Basic: findBy, existsBy, countBy, deleteBy, removeBy, getBy, readBy, queryBy
	// Logical: And, Or, Not
	// Comparison: GreaterThan, GreaterThanEqual, LessThan, LessThanEqual, Between
	// String: Like, NotLike, Containing, StartingWith, EndingWith, IgnoreCase
	// Null/Boolean: IsNull, IsNotNull, True, False
	// Sorting: OrderBy, Asc, Desc

}
package com.harshad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshad.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}

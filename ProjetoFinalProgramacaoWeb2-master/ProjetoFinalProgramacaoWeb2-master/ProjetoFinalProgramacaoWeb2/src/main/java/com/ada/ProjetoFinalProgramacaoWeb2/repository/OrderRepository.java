package com.ada.ProjetoFinalProgramacaoWeb2.repository;

import com.ada.ProjetoFinalProgramacaoWeb2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT * FROM ORDERS WHERE USER_ID = :userId", nativeQuery = true)
    List<Order> findAllByUser(Integer userId);

    @Query(value = "SELECT o FROM Order o JOIN o.products p WHERE p.id = :productId")
    List<Order> findAllByProduct(Integer productId);

}

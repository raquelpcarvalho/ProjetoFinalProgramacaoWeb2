package com.ada.ProjetoFinalProgramacaoWeb2.utils;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Order;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Product;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderConvert {

    public static Order toEntity(OrderRequest orderRequest, User user, List<Product> products){
        Order order = new Order();

        BigDecimal total = BigDecimal.ZERO;
        for(Product product : products){
            total = total.add(product.getPrice());
        }
        order.setTotalPrice(total);

        //order.setTotalPrice(orderRequest.getTotalPrice());
        order.setUser(user);
        order.setProducts(products);
        return order;
    }

    public static OrderResponse toResponse(Order order){
        OrderResponse ordersResponse = new OrderResponse();
        ordersResponse.setId(order.getId());
        ordersResponse.setUser(order.getUser());
        ordersResponse.setProducts(order.getProducts());
        ordersResponse.setTotalPrice(order.getTotalPrice());
        return ordersResponse;
    }

    public static List<OrderResponse> toResponseList(List<Order> orders){
        List<OrderResponse> ordersResponse = new ArrayList<>();
        for(Order order: orders){
            ordersResponse.add(toResponse(order));
        }
        return ordersResponse;
    }


}

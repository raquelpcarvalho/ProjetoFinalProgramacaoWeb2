package com.ada.ProjetoFinalProgramacaoWeb2.controller;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.OrderResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.saveOrder(orderRequest);
        return ResponseEntity.created(URI.create("/order/" + orderResponse.getId())).body(orderResponse);
    }


    @GetMapping("/order/product/{productId}")
    public List<OrderResponse> getAllByProduct(@PathVariable Integer productId){
        return orderService.getAllByProduct(productId);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrder(
            @RequestParam(name = "userId", required = false) Integer userId,
            @RequestParam(name = "productId", required = false) Integer productId
    ){
        return ResponseEntity.ok(orderService.getAllOrders(userId, productId));
    }

}

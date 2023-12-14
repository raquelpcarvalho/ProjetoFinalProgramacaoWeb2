package com.ada.ProjetoFinalProgramacaoWeb2.controller;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.EmployeeRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.EmployeeResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import com.ada.ProjetoFinalProgramacaoWeb2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(
            @RequestParam(name = "user", required = false) Integer user
    ){
        return ResponseEntity.ok(employeeService.getAllEmployee(user));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse = employeeService.saveEmployee(employeeRequest);
        return ResponseEntity.created(URI.create("/employee/"+employeeResponse.getMatricula())).body(employeeResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @PathVariable Integer id,
            @RequestBody EmployeeRequest employeeRequest, User user
    ){
        return  ResponseEntity.ok(employeeService.updateEmployee(id, employeeRequest, user));
    }


    @RequestMapping("/searchBySalary")
    public ResponseEntity<List<EmployeeResponse>> searchEmployeesBySalary(
            @RequestParam(name = "minSalary", required = false) BigDecimal minSalary
    ){
        List<EmployeeResponse> employees = employeeService.searchEmployeesByMinSalary(minSalary);
        return ResponseEntity.ok(employees);
    }


}

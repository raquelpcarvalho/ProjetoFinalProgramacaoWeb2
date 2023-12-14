package com.ada.ProjetoFinalProgramacaoWeb2.service;

import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.EmployeeRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.EmployeeResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserRequest;
import com.ada.ProjetoFinalProgramacaoWeb2.controller.dto.UserResponse;
import com.ada.ProjetoFinalProgramacaoWeb2.model.Employee;
import com.ada.ProjetoFinalProgramacaoWeb2.model.User;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.EmployeeRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.repository.UserRepository;
import com.ada.ProjetoFinalProgramacaoWeb2.utils.EmployeeConvert;
import com.ada.ProjetoFinalProgramacaoWeb2.utils.UserConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest){
        User user = userRepository.findById(employeeRequest.getUserId()).get();
        Employee employee = EmployeeConvert.toEntity(employeeRequest, user);
        employee.setActive(true);
        return EmployeeConvert.toResponse(employeeRepository.save(employee));
    }

    public List<EmployeeResponse> getAllEmployee(Integer user){
        if(user != null){
            return getAllByUser(user);
        }
        return EmployeeConvert.toResponseList(employeeRepository.findAll());
    }

    public List<EmployeeResponse> getAllByUser(Integer user){
        return EmployeeConvert.toResponseList(employeeRepository.findEmployeeByUser(user));
    }

    public void deleteEmployee(Integer id){
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setActive(false);
        employeeRepository.save(employee);
    }

    public EmployeeResponse updateEmployee(Integer id, EmployeeRequest employeeRequest, User user){
        Employee employee = EmployeeConvert.toEntity(employeeRequest, user);
        employee.setActive(true);
        employee.setMatricula(id);
        return EmployeeConvert.toResponse(employeeRepository.save(employee));
    }

    public List<EmployeeResponse> searchEmployeesByMinSalary(BigDecimal minSalary) {

        List<Employee> employees = employeeRepository.findBySalaryGreaterThanEqual(minSalary);
        return EmployeeConvert.toResponseList(employees);
    }




}

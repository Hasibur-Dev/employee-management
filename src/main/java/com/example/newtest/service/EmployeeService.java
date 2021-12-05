package com.example.newtest.service;

import com.example.newtest.domain.Employee;
import com.example.newtest.domain.EmployeeExample;
import com.example.newtest.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> listAll(){
        return employeeMapper.selectByExample(new EmployeeExample());
    }

    public Employee findById(Integer id){
        return employeeMapper.selectByPrimaryKey(id);
    }

    public void save(Employee employee) {
       if  (employeeMapper.selectByPrimaryKey(employee.getEmployeenumber()) != null){
           employeeMapper.updateByPrimaryKey(employee);
       }
       else {
           employeeMapper.insert(employee);
       }
    }

    public void deleteByID(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
}

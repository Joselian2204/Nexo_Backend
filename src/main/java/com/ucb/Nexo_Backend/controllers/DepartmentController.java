package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Department;
import com.ucb.Nexo_Backend.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentService service;
    @Autowired
    public void setService(DepartmentService service){
        this.service = service;
    }
    @GetMapping(value = "/bol")
    public List<Department> listDepartments(){
        return service.getAll();
    }
}

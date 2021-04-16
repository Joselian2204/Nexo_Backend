package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Department;
import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.services.DepartmentCasesService;
import com.ucb.Nexo_Backend.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    private DepartmentService service;
    private DepartmentCasesService casesService;
    @Autowired
    public void setServices(DepartmentService service, DepartmentCasesService casesService){
        this.service = service;
        this.casesService = casesService;
    }
    @GetMapping(value = "/bol")
    public List<Department> listDepartments(){
        return service.getAll();
    }
    @GetMapping(value = "/department/{id}")
    public List<DepartmentCases> getCases(@PathVariable String id){
        return casesService.getByDepartmentId(id);
    }
}

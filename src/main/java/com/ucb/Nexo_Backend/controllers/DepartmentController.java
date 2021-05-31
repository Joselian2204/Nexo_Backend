package com.ucb.Nexo_Backend.controllers;

import com.ucb.Nexo_Backend.models.Department;
import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.services.DepartmentCasesService;
import com.ucb.Nexo_Backend.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*")
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
    public List<DepartmentCases> getCases(@PathVariable String id,@RequestParam String date1, @RequestParam String date2) throws ParseException{
        if(date1 == "" || date2 == ""){
            return casesService.getByDepartmentId(id);
        }
        else{
            return casesService.getByDateId(id,date1,date2);
        }
    }
    @GetMapping(value = "/bol_cases")
    public Department getTotal(){
        return this.service.getTotal();
    }

    @GetMapping(value = "/department")
    public List<DepartmentCases> getDates(@RequestParam String id, @RequestParam String date1, @RequestParam String date2) throws ParseException {

        return casesService.getByDateId(id,date1,date2);
    }
    @GetMapping(value = "/department/average/{id}")
    public DepartmentCases getCases(@PathVariable String id){
        return casesService.getAverage(id);
    }
}

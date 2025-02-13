package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Department;
import com.cg.feign.DepartmentFeignClient;
import com.cg.service.DepartmentService;

@RestController
@RequestMapping("/dapi")
public class DepartmentController {
	 @Autowired
	 DepartmentService departmentservice;
	 
	 @Autowired
	 DepartmentFeignClient departmentfeignclient;
	 
	 @GetMapping("/department")
	 public List<Department> getAllDepartments() {
		 return departmentservice.getAllDepartments();
	 }
	 
	 @GetMapping("/allemp")
	 public ResponseEntity<String> getEmployees(){
		 return ResponseEntity.ok().body(departmentfeignclient.employeeResponse());
	 }
	 
}

package com.example.lab5_q2.Controller;

import com.example.lab5_q2.Api.ApiRespons;
import com.example.lab5_q2.model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class TrackerController {
    ArrayList<Project> projects = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Project> getProjects() {
        return projects;
    }
    @PostMapping("/add")
    public ApiRespons addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiRespons("project added successfully");
    }
    @PutMapping("/ubdate/{index}")
    public ApiRespons updateProject(@RequestBody Project project,@PathVariable int index) {
        projects.set(index, project);
        return new ApiRespons("project updated successfully");
    }
    @DeleteMapping("/delete/{index}")
    public ApiRespons deleteProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiRespons("project deleted successfully");
    }
    @PutMapping("/changestatus/{index}")
    public ApiRespons chngeStatus(@PathVariable int index,String status) {
        if(projects.get(index).getStatus().equalsIgnoreCase("not done")) {
            projects.get(index).setStatus("done");

        }
        return new ApiRespons("project status changed successfully");
    }
    @GetMapping("/search/{title}")
    public ArrayList<Project> searchProject(@PathVariable String title) {
        ArrayList<Project> searchprojects = new ArrayList<>();
        for(Project project : projects) {
            if(project.getTitle().equalsIgnoreCase(title)) {
                searchprojects.add(project);
            }
        }
        return searchprojects;
    }
    @GetMapping("/getbycompany/{companyName}")
    public ArrayList<Project> getProjectsByCompanyName(@PathVariable String companyName ) {
        ArrayList<Project> searchbyCompany = new ArrayList<>();
        for(Project project : projects) {
            if(project.getCompanyName().equalsIgnoreCase(companyName)) {
                searchbyCompany.add(project);
            }

        }
      return searchbyCompany;

    }

}

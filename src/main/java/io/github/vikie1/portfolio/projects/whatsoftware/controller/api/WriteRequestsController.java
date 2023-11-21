package io.github.vikie1.portfolio.projects.whatsoftware.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.vikie1.portfolio.projects.whatsoftware.pojo.SoftwareAttributesPojo;
import io.github.vikie1.portfolio.projects.whatsoftware.service.ControllerLinkService;

@RestController @RequestMapping("/admin")
public class WriteRequestsController {
    @Autowired
    ControllerLinkService controllerLinkService;

    //Create
    @PostMapping("/soft")
    public void postNewSoftwareDetails(@RequestBody SoftwareAttributesPojo softwareAttributesPojo){ controllerLinkService.postSoftwareDetails(softwareAttributesPojo); }
}

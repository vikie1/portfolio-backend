package io.github.vikie1.portfolio.projects.whatsoftware.service;

import io.github.vikie1.portfolio.projects.whatsoftware.entity.SoftwareEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.entity.TypeEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.pojo.DeriveEntityFromPojo;
import io.github.vikie1.portfolio.projects.whatsoftware.pojo.SoftwareAttributesPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ControllerLinkService {

    @Autowired
    SoftwareService softwareService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    TypeService typeService;

    //POST Request
    public void postSoftwareDetails(SoftwareAttributesPojo softwareAttributes) {
//        if (softwareAttributes.isNested()) {
//            nestedCategoryService.addNestedCategory(DeriveEntityFromPojo.constructCategory(softwareAttributes).getNestedCategory());
//        }
//        else categoryService.addCategory(DeriveEntityFromPojo.constructCategory(softwareAttributes).getCategory());
//        typeService.addType(DeriveEntityFromPojo.constructTypeEntity(softwareAttributes));
        if (softwareAttributes == null) return;
        softwareService.addSoftware(DeriveEntityFromPojo.constructSoftwareEntity(softwareAttributes));
    }

    //PUT Request
    public void putFullSoftwareDetailsUpdate(SoftwareAttributesPojo softwareAttributesPojo) {
        try {
            softwareService.updateSoftware(DeriveEntityFromPojo.constructSoftwareEntity(softwareAttributesPojo));
            categoryService.updateCategory(DeriveEntityFromPojo.createCategory(softwareAttributesPojo));
        } catch (SoftwareService.SoftwareNotFoundException | CategoryService.CategoryNotFoundException e) {
            Logger.getLogger("Software").log(Level.SEVERE, e.toString());
        }
    }

    //GET Requests
    public HashMap<String, List<SoftwareEntity>> getSoftwareByCategory(String category) {
        HashMap<String, List<SoftwareEntity>> typeEntityHashMap = new HashMap<>();
        List<SoftwareEntity> entityList = new ArrayList<SoftwareEntity>(softwareService.getSoftwareByCategory(categoryService.getCategory(category)));
        typeEntityHashMap.put("list", entityList);
        return typeEntityHashMap;
    }
    public HashMap<String, List<TypeEntity>> getByType(String category){
        HashMap<String, List<TypeEntity>> typeEntityHashMap = new HashMap<>();
        List<TypeEntity> entityList = new ArrayList<TypeEntity>(typeService.getAllByCategory(categoryService.getCategory(category)));
        typeEntityHashMap.put(category, entityList);
        return typeEntityHashMap;
    }
}
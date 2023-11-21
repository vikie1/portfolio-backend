package io.github.vikie1.portfolio.projects.whatsoftware.pojo;

import io.github.vikie1.portfolio.projects.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.entity.SoftwareEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.entity.TypeEntity;
import org.springframework.lang.NonNull;

/**
 * This class just help reduce the number/size of JSON objects sent to controller
 * It does so by constructing Entity classes from pojo thus reducing redundancy in JSON objects.
 */

public class DeriveEntityFromPojo {
    
    // Construct SoftwareEntity
    static public SoftwareEntity constructSoftwareEntity(@NonNull SoftwareAttributesPojo softwareAttributesPojo){
        return new SoftwareEntity(
                softwareAttributesPojo.softwareName(),
                softwareAttributesPojo.description(),
                softwareAttributesPojo.downloadUrl(),
                constructTypeEntity(softwareAttributesPojo)
        );
    }

    //Construct TypeEntity
    static public TypeEntity constructTypeEntity(@NonNull SoftwareAttributesPojo softwareAttributesPojo){
        return new TypeEntity(
                softwareAttributesPojo.type(),
                createCategory(softwareAttributesPojo),
                softwareAttributesPojo.isNested()
        );
    }

    public static CategoryEntity createCategory(SoftwareAttributesPojo softwareAttributesPojo){
        return new CategoryEntity(
                softwareAttributesPojo.category(),
                null
        );
    }

}

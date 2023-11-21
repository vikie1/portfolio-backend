package io.github.vikie1.portfolio.projects.whatsoftware.service;

import io.github.vikie1.portfolio.projects.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.entity.SoftwareEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.entity.TypeEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoftwareService {
    @Autowired
    TypeService typeService;
    @Autowired
    SoftwareRepository softwareRepository;

    //Create
    public void addSoftware(SoftwareEntity softwareEntity) {
        TypeEntity givenType = softwareEntity.getTypeEntity();
        TypeEntity neededType = typeService.getType(givenType.getType());
        if (neededType != null) softwareEntity.setTypeEntity(neededType);
        else {
            typeService.addType(givenType);
            addSoftware(softwareEntity);
        }
        softwareRepository.save(softwareEntity);
    }

    //Read
    public SoftwareEntity getById(Long id){ return softwareRepository.findById(id).orElse(null); }
    public SoftwareEntity getBySoftwareName(String name) { return softwareRepository.findByNameAllIgnoreCase(name); }
    public List<SoftwareEntity> getSoftwareByCategory(CategoryEntity category){
        List<TypeEntity> types = typeService.getAllByCategory(category);
        List<SoftwareEntity> software = new ArrayList<>();
        for(TypeEntity type : types){
            software.addAll(softwareRepository.findAllByTypeEntity(type));
        }
        return software;
    }

    //Update
    public void updateSoftware(SoftwareEntity newSoftwareEntity) throws SoftwareNotFoundException {
        SoftwareEntity oldSoftwareEntity;
        if (softwareRepository.existsByName(newSoftwareEntity.getName())){
            oldSoftwareEntity = softwareRepository.findByNameAllIgnoreCase(newSoftwareEntity.getName());
            newSoftwareEntity.setId(oldSoftwareEntity.getId());
        } else throw new SoftwareNotFoundException("Software : " + newSoftwareEntity.getName() + "Does Not Exist" );
        softwareRepository.save(newSoftwareEntity);
    }

    //Delete
    public void delete(SoftwareEntity software){ softwareRepository.delete(software); }
    public void clearSoftware(){ softwareRepository.deleteAll(); }
    public void deleteByName(String name){ softwareRepository.deleteByName(name); }

    public static class SoftwareNotFoundException extends Exception{
        SoftwareNotFoundException(String exceptionMessage){ super(exceptionMessage); }
    }
}

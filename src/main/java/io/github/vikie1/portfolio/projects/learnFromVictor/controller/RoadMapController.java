package io.github.vikie1.portfolio.projects.learnFromVictor.controller;

import io.github.vikie1.portfolio.projects.learnFromVictor.entity.RoadMap;
import io.github.vikie1.portfolio.projects.learnFromVictor.service.RoadMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/api/lfv")
public class RoadMapController {
    @Autowired RoadMapService roadMapService;

    //POST
    @PostMapping("/roadmaps")
    public void post(@RequestBody RoadMap roadMap){ roadMapService.add(roadMap);}

    //GET
    @GetMapping("/roadmaps")
    public Map<String, List<RoadMap>> get(){
        Map<String, List<RoadMap>> roadMaps = new HashMap<>();
        roadMaps.put("roadMaps", roadMapService.getAll());
        return roadMaps;
    }

    //PUT
    @PutMapping("/roadmaps/{id}")
    public void put(@RequestBody RoadMap roadMap, @PathVariable("id") long id){ roadMapService.update(roadMap, id);}

    //DELETE
    @DeleteMapping("/roadmaps/{id}")
    public void delete(@PathVariable("id") long id){ roadMapService.delete(id);}
}

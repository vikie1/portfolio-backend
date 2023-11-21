package io.github.vikie1.portfolio.projects.whatsoftware.controller.api;

import io.github.vikie1.portfolio.projects.whatsoftware.entity.CategoryEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.entity.SoftwareOfTheDayEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.service.CategoryService;
import io.github.vikie1.portfolio.projects.whatsoftware.service.SoftwareOfTheDayService;
import io.github.vikie1.portfolio.projects.whatsoftware.util.DayOfTheWeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController @RequestMapping("/api/project")
public class GetRequestsController {
    @Autowired
    SoftwareOfTheDayService softwareOfTheDayService;
    @Autowired
    CategoryService categoryService;

    //Requests for software of the day
    @GetMapping("/SotD")
    public SoftwareOfTheDayEntity getSoftwareOfTheDay(HttpServletRequest request, HttpServletResponse response){
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SUNDAY) {
            try { response.sendRedirect(request.getContextPath() + "/api/SotD"); }
            catch (IOException e) {
                Logger.getLogger("Navigation").log(Level.SEVERE, e.toString());
            }
        }
        return softwareOfTheDayService.getSoftwareOfTheDayByDate(DayOfTheWeek.getDayById(day));
    }
    @GetMapping("/SotD/day/{day}")
    public SoftwareOfTheDayEntity getSoftwareOfTheDayByDay(@PathVariable String day, HttpServletRequest request, HttpServletResponse response){
        if (DayOfTheWeek.getIdByDay(day) == Calendar.SUNDAY) {
            try { response.sendRedirect(request.getContextPath() + "/api/SotW"); }
            catch (IOException e) { Logger.getLogger("Navigation").log(Level.SEVERE, e.toString()); }
        }
        return softwareOfTheDayService.getSoftwareOfTheDayByDate(day);
    }
    @GetMapping("/SotD/software/{software}")
    public SoftwareOfTheDayEntity getSoftwareOfTheDayBySoftware(@PathVariable String software){
        return softwareOfTheDayService.getSoftwareOfTheDayByName(software);
    }
    @GetMapping("/SotW")
    public HashMap<String, SoftwareOfTheDayEntity> getStarsOfTheWeek(HttpServletRequest request, HttpServletResponse response){
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        if (day != Calendar.SUNDAY) {
            try { response.sendRedirect(request.getContextPath() + "/api/SotD"); }
            catch (IOException e) { Logger.getLogger("Navigation").log(Level.SEVERE, e.toString()); }
        }
        return softwareOfTheDayService.getWeeklySoftware();
    }

    //Get software Categories
    @GetMapping("/categories")
    public HashMap<String, List<String>> getCategories(){
        HashMap<String, List<String>> response = new HashMap<>();
        response.put("cat", categoryService.getAllCategories());
        return response;
    }
    //Get software of a certain category
    @GetMapping("/category/{name}")
    public CategoryEntity getCategorised(@PathVariable String name){ return categoryService.getCategory(name); }

}

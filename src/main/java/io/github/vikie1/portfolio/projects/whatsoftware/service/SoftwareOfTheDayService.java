package io.github.vikie1.portfolio.projects.whatsoftware.service;

import io.github.vikie1.portfolio.projects.whatsoftware.entity.SoftwareOfTheDayEntity;
import io.github.vikie1.portfolio.projects.whatsoftware.repository.SoftwareOfTheDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SoftwareOfTheDayService {
    @Autowired
    SoftwareOfTheDayRepository softwareOfTheDayRepository;

    //Create
    public void addSoftwareOfTheDay(SoftwareOfTheDayEntity softwareOfTheDay, boolean update) {
        softwareOfTheDayRepository.save(softwareOfTheDay);
    }

    //Read
    public SoftwareOfTheDayEntity getSoftwareOfTheDayByDate(String date) {
        return softwareOfTheDayRepository.findByDateAllIgnoreCase(date);
    }
    public SoftwareOfTheDayEntity getSoftwareOfTheDayByName(String softwareOfTheDay) {
        return softwareOfTheDayRepository.findBySoftwareAllIgnoreCase(softwareOfTheDay);
    }
    public HashMap<String, SoftwareOfTheDayEntity> getWeeklySoftware() {
        HashMap<String, SoftwareOfTheDayEntity> weeklyStarred = new HashMap<>();
        List<SoftwareOfTheDayEntity> software = softwareOfTheDayRepository.findAll();
        for (SoftwareOfTheDayEntity softwareOfTheDay: software) {
            weeklyStarred.put(softwareOfTheDay.getDate(), softwareOfTheDay);
        }
        return weeklyStarred;
    }

    //Update
    public void updateSoftwareOfTheDay(SoftwareOfTheDayEntity newSoftwareOfTheDay) throws SoftwareNotFoundException {
        SoftwareOfTheDayEntity existingSoftwareOfTheDayEntity;
        if (softwareOfTheDayRepository.existsBySoftwareAllIgnoreCase(newSoftwareOfTheDay.getSoftware())){
            existingSoftwareOfTheDayEntity = softwareOfTheDayRepository.findBySoftwareAllIgnoreCase(newSoftwareOfTheDay.getSoftware());
            newSoftwareOfTheDay.setId(existingSoftwareOfTheDayEntity.getId());
        }
        else if (softwareOfTheDayRepository.existsByDateAllIgnoreCase(newSoftwareOfTheDay.getDate())){
            existingSoftwareOfTheDayEntity = softwareOfTheDayRepository.findByDateAllIgnoreCase(newSoftwareOfTheDay.getDate());
            newSoftwareOfTheDay.setId(existingSoftwareOfTheDayEntity.getId());
        }
        else throw new SoftwareNotFoundException(
                    "Software : " + newSoftwareOfTheDay.getSoftware()
                            + "Or Date : " + newSoftwareOfTheDay.getDate()
                            + "Does Not Exist for any day."
            );
        softwareOfTheDayRepository.save(newSoftwareOfTheDay);
    }

    //Delete
    public void delete(SoftwareOfTheDayEntity softwareOfTheDay){ softwareOfTheDayRepository.delete(softwareOfTheDay); }
    public void deleteByDate(String date){ softwareOfTheDayRepository.deleteByDateAllIgnoreCase(date); }
    public void clear(){ softwareOfTheDayRepository.deleteAll(); }
    public void deleteBySoftware(String softwareOfTheDay){ softwareOfTheDayRepository.deleteBySoftwareAllIgnoreCase(softwareOfTheDay);}

    static class SoftwareNotFoundException extends Exception{
        SoftwareNotFoundException(String exceptionMessage){
            super(exceptionMessage);
        }
    }
}

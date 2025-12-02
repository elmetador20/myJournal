package com.project.myproject.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.myproject.entity.ConfigJournalApp;
import com.project.myproject.repository.ConfigJournalAppRepository;

import jakarta.annotation.PostConstruct;

@Component
public class AppCache {

@Autowired
private ConfigJournalAppRepository configjournalAppRepository;
 private Map<String,String> appCache=new HashMap<>();

  @PostConstruct
  public void init(){
    List<ConfigJournalApp> all= configjournalAppRepository.findAll();
    for(ConfigJournalApp configJournalApp:all)
    appCache.put(ConfigJournalApp.getKey(),configJournalApp.getValue());

    appCache=null;
  }

}

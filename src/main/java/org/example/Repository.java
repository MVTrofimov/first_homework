package org.example;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class Repository {

    private final Map<String, String> contactsJournal = new HashMap<>();

    public void add(String userInformation) {
        String[] line = userInformation.split(";");
        contactsJournal.put(line[2], userInformation);
    }

    public void delete(String email) {
        contactsJournal.remove(email);
    }

    public void showAll() {
        for (String k : contactsJournal.keySet()){
            System.out.println(contactsJournal.get(k));
        }
    }

    public Set<String> keySet(){
        return contactsJournal.keySet();
    }

    public String get(String email){
        return contactsJournal.get(email);
    }

    public void put(String key, String value){
        contactsJournal.put(key, value);
    }

    public boolean containsKey(String element) {
        return contactsJournal.containsKey(element);
    }



}

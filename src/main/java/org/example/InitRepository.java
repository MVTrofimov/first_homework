package org.example;

import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InitRepository implements Repository {

    @Value("${app.filename}")
    private String filename;

    private final Map<String, String> contactsJournal = new HashMap<>();

    @Override
    public void add(String userInformation) {
        String[] line = userInformation.split(";");
        contactsJournal.put(line[2], userInformation);
    }

    @Override
    public void delete(String email) {
        contactsJournal.remove(email);
    }

    @Override
    public void showAll() {
        for (String k : contactsJournal.keySet()){
            System.out.println(contactsJournal.get(k));
        }
    }

    @Override
    public void loadToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String k : contactsJournal.keySet()){
            writer.write(contactsJournal.get(k) + "\n");
        }
        writer.close();
    }

    @Override
    public boolean containsKey(String element) {
        return contactsJournal.containsKey(element);
    }

    public void initializationFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String str = reader.readLine();
        String[] line = str.split(";");
        while (str != null){
            line = str.split(";");
            contactsJournal.put(line[2], str);
            str = reader.readLine();
        }
        reader.close();
    }
}

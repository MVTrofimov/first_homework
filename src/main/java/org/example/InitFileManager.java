package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.io.*;
@PropertySource("classpath:application_init.properties")
@Profile("init")
@Component
public class InitFileManager implements FileManager{

    @Value("${app.filename}")
    private String filename;

    private Repository repository;

    public InitFileManager() {
    }


    @Autowired
    public InitFileManager(Repository repository) {
        this.repository = repository;
    }


    public void loadToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String k : repository.keySet()){
            writer.write(repository.get(k) + "\n");
        }
        writer.close();
    }

    public void initializationFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String str = reader.readLine();
        String[] line = str.split(";");
        while (str != null){
            line = str.split(";");
            repository.put(line[2], str);
            str = reader.readLine();
        }
        reader.close();
    }
}

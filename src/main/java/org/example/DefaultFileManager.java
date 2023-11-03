package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@PropertySource("classpath:application_default.properties")
@Profile("default")
@Component
public class DefaultFileManager implements FileManager {

    @Value("${app.filename}")
    private String filename;

    private Repository repository;

    public DefaultFileManager() {
    }

    @Autowired
    public DefaultFileManager(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void loadToFile() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String k : repository.keySet()){
            writer.write(repository.get(k) + "\n");
        }
        writer.close();

    }
}

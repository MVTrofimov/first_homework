package org.example;

import java.io.IOException;
import java.util.Map;

public interface Repository {

    public void add(String userInformation);

    public void delete(String email);

    public void showAll();
    public void loadToFile() throws IOException;
    public boolean containsKey(String element);

}

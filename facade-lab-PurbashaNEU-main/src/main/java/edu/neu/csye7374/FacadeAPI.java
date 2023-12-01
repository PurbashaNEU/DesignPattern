package edu.neu.csye7374;

import java.util.List;

public interface FacadeAPI {
    void save(List<String> programData);
    List<String> load();
}


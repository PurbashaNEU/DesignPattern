package edu.neu.csye7374;

import java.util.List;
//low level api
public interface StudentRosterAPI {
 void displaySavingMsg();
 void fileWriting(List<String> filename);
 void displaySavedMsg();
 void displayLoading();
 List<String> fileReading();
}

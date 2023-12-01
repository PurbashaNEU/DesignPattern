package edu.neu.csye7374;

import java.util.List;

public class StudentRosterFacade implements FacadeAPI{
    private final StudentRosterAPI roster;

    public StudentRosterFacade(StudentRosterAPI roster) {
        super();
        this.roster = roster;
    }

    @Override
    public void save(List<String> programData) {
        roster.displaySavingMsg();
        roster.fileWriting(programData);
        roster.displaySavedMsg();
    }

    @Override
    public List<String> load() {
        roster.displayLoading();
        return roster.fileReading();
    }
}
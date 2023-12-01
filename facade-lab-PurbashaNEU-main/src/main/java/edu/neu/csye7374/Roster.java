package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roster {
    public static void demo() {
        // Calling low level inside high level
        StudentRosterFacade roster = new StudentRosterFacade(new Studentregistration());

        roster.save(new ArrayList<>(Arrays.asList("Omar Garza",
                                                  "Noah Wilkerson",
                                                  "Frida Reese",
                                                  "Connor Dalton",
                                                  "Seth Moses",
                                                  "Ellen Brooks",
                                                  "Naomi Page",
                                                  "Desmond Pattison",
                                                  "Paulina Grant",
                                                  "Tyler Atkinson")));

        List<String> list = new ArrayList<>();

        list = roster.load();

        for (String l : list) {
            System.out.println(l);
        }
    }
}
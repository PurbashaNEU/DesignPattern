package edu.neu.csye7374;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Studentregistration implements StudentRosterAPI{
    @Override
    public void displaySavingMsg() {
        System.out.println("Saving file ...\n");
    }

    @Override
    public void fileWriting(List<String> filename) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("FacadeOutput.txt"));
            for (String fn : filename) {
                bw.write(fn+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displaySavedMsg() {
        System.out.println("\nFacade Output File Saved! \n");
    }

    @Override
    public void displayLoading() {
        System.out.println("===========================================");
        System.out.println("\nLoading file . . .\n");
    }

    @Override
    public List<String> fileReading() {
        List<String> students =  new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("FacadeOutput.txt"));
            String s;
            try {
                while((s = br.readLine()) != null) {
                    students.add(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}
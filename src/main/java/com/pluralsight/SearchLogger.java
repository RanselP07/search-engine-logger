package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchLogger {

    static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        LocalDateTime today = LocalDateTime.now();
        String search = "";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ArrayList<String> allSearch = new ArrayList<>();
        int counter = -1;


        try{
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("logs.txt"));

            bufWriter.write(LocalDateTime.now().format(format) + " launch\n");

            do{
                System.out.print("Enter a search term (X or x to exit): ");
                search = myScanner.nextLine();

                allSearch.add(LocalDateTime.now().format(format) + " : " + search);
                counter++;

            }while (!search.equalsIgnoreCase("x"));


            for (int i = 0; i < counter; i++ ){
                bufWriter.write(allSearch.get(i) + "\n");
            }

            bufWriter.write(LocalDateTime.now().format(format) + " Exit");

            bufWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

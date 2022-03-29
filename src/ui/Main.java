package ui;

import model.objects.Building;
import model.objects.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    private static BufferedReader br;
    private static Building[] buildings;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        readInput();
    }

    private static void readInput() throws Exception {
        buildings = new Building[Integer.parseInt(br.readLine())];

        int acount = 1;

        while(buildings.length >= acount){
            int countPerson = 0;
            for (int i = 0; i < buildings.length; i++) {
                if(buildings[i]==null){
                     String [] prop = br.readLine().split(" ");
                     countPerson = Integer.parseInt(prop[1]);
                    buildings[i] = new Building(prop[0].charAt(0), Integer.parseInt(prop[2]), Integer.parseInt(prop[3]));
                    i = buildings.length+1;
                }
            }
            int cuantityPerson = 0;
            while(countPerson > cuantityPerson ){
                String [] person = br.readLine().split(" ");
                Person person1 = new Person(person[0],Integer.parseInt(person[2]));
                cuantityPerson++;
            }




            acount++;
        }
    }
}

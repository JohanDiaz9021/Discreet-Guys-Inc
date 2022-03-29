package ui;

import model.data_structures.Queue;
import model.objects.Building;
import model.objects.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader br;
    private static Building[] buildings;
    private static Queue<Person> queue;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        queue = new Queue<>();
        readInput();
    }

    private static void readInput() throws IOException {
        buildings = new Building[Integer.parseInt(br.readLine())];

        for (int i = 0; i < buildings.length; i++) {
            String[] prop = br.readLine().split(" ");
            int countPerson = Integer.parseInt(prop[1]);
            buildings[i] = new Building(prop[0].charAt(0), Integer.parseInt(prop[2]), Integer.parseInt(prop[3]));
            fillQueue(countPerson);
        }
    }

    private static void fillQueue(int countPerson) throws IOException {
        for (int i = 0; i < countPerson; i++) {
            String[] person = br.readLine().split(" ");
            Person p = new Person(person[0], Integer.parseInt(person[1]), Integer.parseInt(person[2]));
            queue.enqueue(p);
        }
    }
}

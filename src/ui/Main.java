package ui;

import model.data_structures.Queue;
import model.data_structures.Stack;
import model.data_structures.PriorityQueue;
import model.objects.Building;
import model.objects.Person;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Main {

    private static BufferedReader br;
    private static Building[] buildings;
    private static Queue<Person> queue;
    private static PriorityQueue<Person> priorityQueue;
    private static Stack<Person> stack;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        queue = new Queue<>();
        stack = new Stack<>();
        readInput();
    }

    private static void readInput() throws Exception {
        buildings = new Building[Integer.parseInt(br.readLine())];

        for (int i = 0; i < buildings.length; i++) {
            String[] prop = br.readLine().split(" ");
            int countPerson = Integer.parseInt(prop[1]);
            priorityQueue = new PriorityQueue<>(countPerson, new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					return o1.getOffice() - o2.getOffice();
				}
			});
            buildings[i] = new Building(prop[0].charAt(0), Integer.parseInt(prop[2]), Integer.parseInt(prop[3]));
            fillQueue(countPerson);
            fillPriorityQueue(countPerson);
    		fillStack(countPerson);
    		asignOffice(countPerson, i);
    		String temp = (i != buildings.length-1) ? br.readLine() : "";
        }
    }

    private static void fillQueue(int countPerson) throws Exception {
        for (int i = 0; i < countPerson; i++) {
            String[] person = br.readLine().split(" ");
            Person p = new Person(person[0], Integer.parseInt(person[1]), Integer.parseInt(person[2]));
            queue.enqueue(p);
        }
    }

	private static void fillPriorityQueue(int countPerson) throws Exception {
		for(int i =0;i< countPerson;i++) {
			priorityQueue.offer(queue.dequeue());
		}
	}

	private static void fillStack(int countPerson) throws Exception {
		for (int i = 0; i < countPerson; i++) {
			stack.push(priorityQueue.poll());
		}
	}
	
	private static void asignOffice(int countPerson, int building) throws Exception {
		for (int i = 0; i < countPerson; i++) {
			if (buildings[building].getOffices().search(stack.top().getOffice()) == null) {
				try {
					buildings[building].getOffices().insert(stack.top().getOffice(), stack.top());
					System.out.println(stack.top().getName() + " got asigned to office " + stack.top().getOffice());
				} catch (Exception e) {
					System.out.println(stack.top().getName() + " can't be asigned to an office");
				}
			}
			stack.pop();
		}
		System.out.println("");
	}
}

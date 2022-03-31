package ui;

import model.data_structures.Queue;
import model.data_structures.Stack;
import model.data_structures.PriorityQueue;
import model.objects.Building;
import model.objects.Person;
import java.io.BufferedReader;
import java.io.IOException;
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
		askOffice();
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
    		assignOffice(countPerson, i);
    		if (i != buildings.length - 1) {
				br.readLine();
				System.out.println("");
			}
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
	
	private static void assignOffice(int countPerson, int building) throws Exception {
		for (int i = 0; i < countPerson; i++) {
			if (0 < stack.top().getOffice() && stack.top().getOffice() <= buildings[building].getNum_offices()) {
				if (buildings[building].getOffices().search(stack.top().getOffice()) == null) {
					try {
						buildings[building].getOffices().insert(stack.top().getOffice(), stack.top());
						System.out.println(stack.top().getName() + " got assigned to office " + stack.top().getOffice());
					} catch (Exception e) {
						System.out.println(stack.top().getName() + " can't be assigned to an office");
					}
				} else {
					System.out.println(stack.top().getName() + " can't be assigned to an office");
				}
			} else {
				System.out.println(stack.top().getName() + " can't be assigned to an office that doesn't exist");
			}
			stack.pop();
		}
	}

	private static void askOffice() throws IOException {
		System.out.println("\n¿Do you want to investigate which people are in which office??\n1. Yes\n2. No");
		if (Integer.parseInt(br.readLine()) == 1) {
			System.out.println("Insert the identifier of the building (Ej: A)");
			int indexBuilding = validateBuilding(br.readLine().charAt(0));
			if (indexBuilding != -1) {
				System.out.println("Insert the office number");
				int office = Integer.parseInt(br.readLine());
				if (office > 0 && office <= buildings[indexBuilding].getNum_offices()) {
					Person p = buildings[indexBuilding].getOffices().search(office);
					String msg = (p == null) ? "The office is empty" : "In the office is " + p.getName();
					System.out.println(msg);
				} else {
					System.out.println("The office does not exist");
				}
			} else {
				System.out.println("The building does not exist");
			}
			askOffice();
		}
	}

	private static int validateBuilding(char in) {
		for (int i = 0; i < buildings.length; i++) {
			if (buildings[i].getName() == in) {
				return i;
			}
		}
		return -1;
	}
}

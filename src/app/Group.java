package app;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Group implements Serializable {

    Trainer trainer;
    List<Member> people;
    Log log;
    String specialization;
    String room;
    String day;
    String time;

    public static List<Group> groups = new LinkedList<Group>();

    public Group(Trainer trainer, List<Member> people, String specialization, String room, String day, String time) {
        this.trainer = trainer;
        this.people = people;
        log = new Log(people);
        this.specialization = specialization;
        this.room = room;
        this.day = day;
        this.time = time;
    }

    public static void createGroup() {
        System.out.println("Dostępni trenerzy: ");
        Trainer.showTrainers();
        Scanner number = new Scanner(System.in);
        System.out.println("Podaj numer trenera dla nowej grupy: ");
        int trainerNr = number.nextInt();

        Scanner text = new Scanner(System.in);

        System.out.println("Podaj specjalizacje nowej grupy: ");
        String specialization = text.nextLine();

        System.out.println("Pokój w którym grupa będzie miała zajęcia: ");
        String room = text.nextLine();

        System.out.println("Podaj dzień (dni) tygodnia w który grupa będzie miała zajęcia: ");
        String day = text.nextLine();

        System.out.println("Podaj godzinę o której grupa zaczyna zajęcia: ");
        String time = text.nextLine();

        System.out.println("\nLista klubowiczów: ");
        Member.showMembers();

        List<Member> groupMembers = new LinkedList<Member>();

        String choice;
        do {
            addMemberToGroup(groupMembers);
            Scanner ch = new Scanner(System.in);
            System.out.println("Czy chcesz dodać kolejnego klubowicza do grupy(T/N)?: ");
            choice = ch.nextLine();

        } while (choice.equals("T") || choice.equals("t"));

        Group group = new Group(Trainer.trainers.get(trainerNr), groupMembers, specialization, room, day, time);
        groups.add(group);

        System.out.println("\nGrupa została utworzona pomyślnie!\n");

    }

    public static void addMemberToGroup(List<Member> people) {
        Scanner number = new Scanner(System.in);
        System.out.println("Podaj nr klubowicza w celu zapisania do grupy: ");
        int nr = number.nextInt();
        if (nr > Member.members.size()) {
            System.out.println("Brak klubowicza o podanym numerze!\n");
        }
        else {
            people.add(Member.members.get(nr));
            System.out.println("Dodano klubowicza nr " + nr + " do grupy!\n");
        }
    }

    public static void deleteMemberFromGroup(List<Member> people) {
        if (people.size() == 0) System.out.println("Brak klubowiczów w grupie!\n");
        else {
            for (int i = 0; i < people.size(); i++) {
                System.out.println("Klubowicz " + i + ": ");
                System.out.println("Imię: " + people.get(i).name);
                System.out.println("Nazwisko: " + people.get(i).surname);
                System.out.println("PESEL: " + people.get(i).pesel);
                System.out.println("   ");
            }
        }
        Scanner number = new Scanner(System.in);
        System.out.println("Podaj nr klubowicza, który ma być usunięty z grupy: ");
        int nr = number.nextInt();
        if (nr >= people.size() || nr < 0) {
            System.out.println("Brak klubowicza o podanym numerze!");
        }
        else {
            people.remove(nr);
            System.out.println("Usunięto klubowicza nr " + nr + " z grupy!\n");
        }
    }

    public static void deleteGroup(int nr){
        Scanner check = new Scanner(System.in);
        System.out.println("Czy usunąć wskazaną grupę zajęciową [nr " + nr + " - " + groups.get(nr).specialization + "] (T/N)?: ");
        String Check = check.nextLine();
        switch (Check)
        {
            case "T":
            case "t":
                Group group;
                group = groups.get(nr);
                group = null;
                group.trainer = null;
                groups.get(nr).people = null;
                groups.get(nr).specialization = null;
                groups.get(nr).room = null;
                groups.get(nr).day = null;
                groups.get(nr).time = null;
                Group.groups.remove(nr);
                System.out.println("Grupa zajęciowa została usunięta.\n");
                break;

            default :
                System.out.println("Wskazana grupa zajęciowa NIE została usunięta.\n");
                break;
        }

    }

    public static void showGroups(){
        if (groups.size() == 0) System.out.println("Brak utworzonych grup!\n");
        else {
            for (int i = 0; i < groups.size(); i++) {
                System.out.println("Grupa " + i + ": ");
                System.out.println("Trener: " + groups.get(i).trainer.surname);
                System.out.println("Specjalizacja: " + groups.get(i).specialization);
                System.out.println("Pokój: " + groups.get(i).room);
                System.out.println("Dzień (dni) tygodnia: " + groups.get(i).day);
                System.out.println("Godzina: " + groups.get(i).time);
                System.out.println("   ");
            }
        }
    }

}

package app;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Trainer implements Serializable {

    String name;
    String surname;
    String specialization;

    public static List<Trainer> trainers = new LinkedList<Trainer>();

    public Trainer (String name, String surname, String specialization){
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
    }

    public static void addTrainer(){
        Scanner text = new Scanner(System.in);
        System.out.println("Podaj imię trenera: ");
        String name = text.nextLine();
        System.out.println("Podaj nazwisko trenera: ");
        String surname = text.nextLine();
        System.out.println("Podaj specjalizacje trenera: ");
        String specialization = text.nextLine();
        Trainer trainer = new Trainer(name, surname, specialization);
        trainers.add(trainer);
    }

    public static void changeTrainerName(int nr){
        Scanner text = new Scanner(System.in);
        System.out.println("Podaj nowe imię trenera nr " + nr +": ");
        String newName = text.nextLine();
        trainers.get(nr).name = newName;
        System.out.println("Pomyślnie zmieniono imię trenera nr " + nr +" na: " + trainers.get(nr).name + "!\n");
    }

    public static void changeTrainerSurname(int nr){
        Scanner text = new Scanner(System.in);
        System.out.println("Podaj nowe nazwisko trenera nr " + nr +": ");
        String newSurname = text.nextLine();
        trainers.get(nr).surname = newSurname;
        System.out.println("Pomyślnie zmieniono nazwisko trenera nr " + nr +" na: " + trainers.get(nr).surname + "!\n");
    }

    public static void changeTrainerSpecialization(int nr){
        Scanner text = new Scanner(System.in);
        System.out.println("Podaj nową specializacje trenera nr " + nr +": ");
        String newSpecialization = text.nextLine();
        trainers.get(nr).specialization = newSpecialization;
        System.out.println("Aktualna specjalizacja trenera nr " + nr +" to: " + trainers.get(nr).specialization + "\n");
    }

    public static void deleteTrainer(int nr){
        Scanner check = new Scanner(System.in);
        System.out.println("Czy usunąć trenera " +  trainers.get(nr).name + " " + trainers.get(nr).surname + " (T/N)?: ");
        String Check = check.nextLine();
        switch (Check)
        {
            case "T":
            case "t":
                trainers.get(nr).name = null;
                trainers.get(nr).surname = null;
                trainers.get(nr).specialization = null;
                trainers.remove(nr);
                System.out.println("Trener został usunięty.\n");
                break;

            default :
                System.out.println("Wskazany trener NIE został usunięty.\n");
                break;
        }

    }

    public static void allocateTrainerToGroup(int nr) {
        Group.showGroups();
        Scanner number = new Scanner(System.in);
        System.out.println("Podaj numer grupy dla której ma być przypisany trener: ");
        int groupNr = number.nextInt();

        if (groupNr > Group.groups.size()) System.out.println("Brak grupy o podanym numerze!\n");
        else {
            Group.groups.get(groupNr).trainer = Trainer.trainers.get(nr);
            System.out.println("Przydzielono trenera " + Trainer.trainers.get(nr).name + " " + Trainer.trainers.get(nr).surname + " do grupy nr " + groupNr + "\n");
        }

    }

    public static void showTrainers(){
        if (trainers.size() == 0) System.out.println("Brak zapisanych trenerów!\n");
        else {
            for (int i = 0; i < trainers.size(); i++) {
                System.out.println("Trener " + i + ": ");
                System.out.println("Imię: " + trainers.get(i).name);
                System.out.println("Nazwisko: " + trainers.get(i).surname);
                System.out.println("Specjalizacja: " + trainers.get(i).specialization);
                System.out.println("   ");
            }
        }
    }
}

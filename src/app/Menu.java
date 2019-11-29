package app;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static int mainMenu(){
        System.out.println("");
        System.out.println("1. Zarządzaj klubowiczami");
        System.out.println("2. Zarządzaj trenerami");
        System.out.println("3. Zarządzaj grupami");
        System.out.println("4. Wyszukaj grupy");
        System.out.println("5. Dziennik obecności");
        System.out.println("\n6. Wyjście z programu");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        return choice;
    }

    public static void memberMenu(){
        int choice = 0;
        do {
            System.out.println("1. Dodaj nowego klubowicza");
            System.out.println("2. Usunięcie klubowicza");
            System.out.println("3. Zmiana dancyh klubowicza");
            System.out.println("\n4. Wyjście do menu głównego");

            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    Member.addMember();

                    break;

                case 2:
                    Scanner number = new Scanner(System.in);
                    System.out.println("Podaj numer usuwanego klubowicza: ");
                    int nr = number.nextInt();
                    Member.deleteMember(nr);

                    break;

                case 3:
                    memberSubMenu();

                    break;

                case 4:
                    break;

                default:
                    System.out.println("Brak opcji o takim numerze!\n");
                    break;

            }
        } while (choice != 4);
    }

    public static void memberSubMenu(){
        Scanner number = new Scanner(System.in);
        System.out.println("Podaj numer klubowicza dla którego chcesz zmienić dane: ");
        int nr = number.nextInt();
        System.out.println("1. Edytuj imię klubowicza");
        System.out.println("2. Edytuj nazwisko klubowicza");
        System.out.println("3. Edytuj nr PESEL klubowicza");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                Member.changeMemberName(nr);

                break;

            case 2:
                Member.changeMemberSurname(nr);

                break;

            case 3:
                Member.changeMemberPesel(nr);

                break;


            default:
                System.out.println("Brak opcji o takim numerze!\n");

                break;
        }
    }

    public static void trainerMenu(){
        int choice = 0;
        do {
            System.out.println("1. Dodaj nowego trenera");
            System.out.println("2. Usunięcie trenera");
            System.out.println("3. Zmiana dancyh trenera");
            System.out.println("4. Przypisanie trenera do grupy zajęciowej");
            System.out.println("\n5. Wyjście do menu głównego");

            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    Trainer.addTrainer();

                    break;

                case 2:
                    Scanner number = new Scanner(System.in);
                    System.out.println("Podaj numer usuwanego trenera: ");
                    int nr = number.nextInt();
                    Trainer.deleteTrainer(nr);

                    break;

                case 3:
                    trainerSubMenu();

                    break;

                case 4:
                    Scanner number1 = new Scanner(System.in);
                    System.out.println("Podaj numer trenera dla którego przypisać grupę zajęciową: ");
                    int nr1 = number1.nextInt();
                    Trainer.allocateTrainerToGroup(nr1);

                    break;

                case 5:
                    break;

                default:
                    System.out.println("Brak opcji o takim numerze!\n");
                    break;

            }
        } while (choice != 5);
    }

    public static void trainerSubMenu(){
        Scanner number = new Scanner(System.in);
        System.out.println("Podaj numer trenera dla którego chcesz zmienić dane: ");
        int nr = number.nextInt();
        System.out.println("1. Edytuj imię trenera");
        System.out.println("2. Edytuj nazwisko trenera");
        System.out.println("3. Zmień specializacje trenera");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                Trainer.changeTrainerName(nr);

                break;

            case 2:
                Trainer.changeTrainerSurname(nr);

                break;

            case 3:
                Trainer.changeTrainerSpecialization(nr);

                break;


            default:
                System.out.println("Brak opcji o takim numerze!\n");

                break;
        }
    }

    public static void groupMenu(){
        int choice = 0;
        do {
            System.out.println("1. Dodaj nową grupę");
            System.out.println("2. Usuń grupę");
            System.out.println("3. Dodaj klubowicza do grupy");
            System.out.println("4. Usuń klubowicza z grupy");
            System.out.println("\n5. Wyjście do menu głównego");

            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    Group.createGroup();

                    break;

                case 2:
                    Scanner number = new Scanner(System.in);
                    System.out.println("Podaj numer usuwanej grupy: ");
                    int nr = number.nextInt();
                    Group.deleteGroup(nr);

                    break;

                case 3:
                    Scanner number1 = new Scanner(System.in);
                    System.out.println("Podaj numer grupy do której ma być dodany klubowicz: ");
                    int nr1 = number1.nextInt();
                    System.out.println("Lista klubowiczów: ");
                    Member.showMembers();
                    Group.addMemberToGroup(Group.groups.get(nr1).people);

                    break;

                case 4:
                    Scanner number2 = new Scanner(System.in);
                    System.out.println("Podaj numer grupy z której ma być usunięty klubowicz: ");
                    int nr2 = number2.nextInt();
                    Group.deleteMemberFromGroup(Group.groups.get(nr2).people);

                    break;

                case 5:
                    break;

                default:
                    System.out.println("Brak opcji o takim numerze!\n");
                    break;

            }
        } while (choice != 5);
    }

    public static void searchGroups() throws IOException {
        if (Group.groups.size() == 0) System.out.println("Brak utworzonych grup!\n");
        else {
            System.out.println("Lista trenerów: \n");
            Trainer.showTrainers();
            Scanner number = new Scanner(System.in);
            System.out.println("Podaj numer trenera, którego grupy zajęciowe chcesz wyświetlić: ");
            int trainerNr = number.nextInt();
            int counter = 0;
            for (int i = 0; i < Group.groups.size(); i++) {
                if (Group.groups.get(i).trainer.name.equals(Trainer.trainers.get(trainerNr).name) && Group.groups.get(i).trainer.surname.equals(Trainer.trainers.get(trainerNr).surname) && Group.groups.get(i).trainer.specialization.equals(Trainer.trainers.get(trainerNr).specialization)) {
                    System.out.println("Grupa " + i + ": ");
                    System.out.println("Specjalizacja: " + Group.groups.get(i).specialization);
                    System.out.println("Pokój: " + Group.groups.get(i).room);
                    System.out.println("Dzień (dni) tygodnia: " + Group.groups.get(i).day);
                    System.out.println("Godzina: " + Group.groups.get(i).time);
                    System.out.println("   ");
                    counter++;
                }
            }
            if (counter == 0) System.out.println("Ten trener nie prowadzi żadnej grupy zajęciowej!\n");
        }

        System.out.println("Wciśnij Enter, aby wrócić do menu głównego...");
        System.in.read();
    }

}

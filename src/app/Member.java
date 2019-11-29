package app;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Member implements Serializable {

    String pesel;
    String name;
    String surname;

    public static List<Member> members = new LinkedList<Member>();

    public Member (String pesel, String name, String surname) {
            this.pesel = pesel;
            this.name = name;
            this.surname = surname;
    }

    public static void addMember() {
        Scanner text = new Scanner(System.in);
        System.out.println("Podaj imię klubowicza: ");
        String name = text.nextLine();
        System.out.println("Podaj nazwisko klubowicza: ");
        String surname = text.nextLine();
        System.out.println("Podaj nr PESEL klubowicza: ");
        String pesel = text.nextLine();
        Member member = new Member(pesel, name, surname);
        members.add(member);
        System.out.println("Pomyślnie dodano nowego klubowicza\n");

    }

    public static void changeMemberName(int nr) {
        Scanner text = new Scanner(System.in);
        System.out.println("Podaj nowe imię klubowicza nr " + nr +": ");
        String newName = text.nextLine();
        members.get(nr).name = newName;
        System.out.println("Pomyślnie zmieniono imię klubowicza nr " + nr +" na: " + members.get(nr).name + "!\n");
    }

    public static void changeMemberSurname(int nr) {
        Scanner text = new Scanner(System.in);
        System.out.println("Podaj nowe nazwisko klubowicza nr " + nr +": ");
        String newSurname = text.nextLine();
        members.get(nr).surname = newSurname;
        System.out.println("Pomyślnie zmieniono nazwisko klubowicza nr " + nr +" na: " + members.get(nr).surname + "!\n");
    }

    public static void changeMemberPesel(int nr) {
        Scanner text = new Scanner(System.in);
        System.out.println("Podaj poprawny PESEL klubowicza nr " + nr +": ");
        String correctPesel = text.nextLine();
        members.get(nr).pesel = correctPesel;
        System.out.println("Aktualny nr PESEL klubowicza nr " + nr +" to: " + members.get(nr).pesel + "\n");
    }

    public static void deleteMember(int nr) {
        Scanner check = new Scanner(System.in);
        System.out.println("Czy usunąć klubowicza " +  members.get(nr).name + " " + members.get(nr).surname + " (T/N)?: ");
        String Check = check.nextLine();
        switch (Check)
        {
            case "T":
            case "t":
                members.get(nr).name = null;
                members.get(nr).surname = null;
                members.get(nr).pesel = null;
                members.remove(nr);
                System.out.println("Klubowicz został usunięty.\n");
                break;

            default :
                System.out.println("Wskazany klubowicz NIE został usunięty.\n");
                break;
        }

    }

    public static void showMembers() {
        if (members.size() == 0) System.out.println("Brak zapisanych klubowiczów!\n");
        else {
            for (int i = 0; i < members.size(); i++) {
                System.out.println("Klubowicz " + i + ": ");
                System.out.println("Imię: " + members.get(i).name);
                System.out.println("Nazwisko: " + members.get(i).surname);
                System.out.println("PESEL: " + members.get(i).pesel);
                System.out.println("   ");
            }
        }
    }
}

package app;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Log implements Serializable {

    int[][] log;

    public Log(List<Member> people) {

        log = new int[people.size()][51];
        for (int i = 0; i < people.size(); i++) {
            log[i][0] = i;
        }
    }

    public static void log() throws IOException {
        Group.showGroups();
        if (Group.groups.size() != 0) {
            Scanner number = new Scanner(System.in);
            int groupNr = 0;
            do {
                System.out.println("Podaj numer grupy, dla której chcesz otworzyć dziennik: ");
                groupNr = number.nextInt();
            } while (groupNr > Group.groups.size());
            System.out.println("Podaj numer zajęć, dla których chcesz uzupełnić dziennik: ");
            int nr = number.nextInt();
            if (nr > 50 || nr < 1) System.out.println("Brak zajęć o podanym numerze!\n");
            else {
                System.out.println("Wpisy w dzienniku: 0-nieobecny, 1-obecny\n");
                for (int i = 0; i < Group.groups.get(groupNr).log.log.length; i++) {
                    if (Group.groups.get(groupNr).log.log[i][nr] == 1)
                        System.out.println("Klubowicz: " + Group.groups.get(groupNr).people.get(i).name + " " + Group.groups.get(groupNr).people.get(i).surname + " był na tych zajęciach.");
                    else {
                        System.out.println("Teraźniejszy status obecności dla: " + Group.groups.get(groupNr).people.get(i).name + " " + Group.groups.get(groupNr).people.get(i).surname + " - " + Group.groups.get(groupNr).log.log[i][nr]);
                        System.out.println("Wprowadź nową obecność (obecny-1, nieobecny-0): ");
                        do {
                            Scanner number1 = new Scanner(System.in);
                            Group.groups.get(groupNr).log.log[i][nr] = number1.nextInt();
                        } while (Group.groups.get(groupNr).log.log[i][nr] != 0 && Group.groups.get(groupNr).log.log[i][nr] != 1);
                    }
                }
                System.out.println("Koniec listy obecności lub wszyscy byli obecni\n");
            }
        }
        System.out.println("Wciśnij Enter, aby wrócić do menu głównego...");
        System.in.read();
    }
}

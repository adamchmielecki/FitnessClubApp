package app;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        try {
            ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("members.txt"));
            Member.members = (List<Member>) in1.readObject();
            in1.close();
            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("trainers.txt"));
            Trainer.trainers = (List<Trainer>) in2.readObject();
            in2.close();
            ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("groups.txt"));
            Group.groups = (List<Group>) in3.readObject();
            in3.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        int choice = Menu.mainMenu();

        while(choice != 6){
            switch(choice){
                case 1:
                    Member.showMembers();
                    Menu.memberMenu();

                    break;

                case 2:
                    Trainer.showTrainers();
                    Menu.trainerMenu();

                    break;

                case 3:
                    Group.showGroups();
                    Menu.groupMenu();

                    break;

                case 4:
                    Menu.searchGroups();

                    break;

                case 5:
                    Log.log();

                    break;
            }

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            choice = Menu.mainMenu();
        }

        try {
            System.out.println("Trwa zapis danych...");

            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("members.txt"));
            out1.writeObject(Member.members);
            out1.close();
            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("trainers.txt"));
            out2.writeObject(Trainer.trainers);
            out2.close();
            ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("groups.txt"));
            out3.writeObject(Group.groups);
            out3.close();

            System.out.println("\nZapis danych zakończony.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

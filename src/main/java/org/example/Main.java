package org.example;

import org.example.Model.Astronaut;
import org.example.Model.MissionEvent;
import org.example.Model.Supply;
import org.example.Repository.FileRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FileRepository repo = new FileRepository();
        Scanner scanner = new Scanner(System.in);

        List<Astronaut> astronauts = null;
        List<MissionEvent> events = null;
        List<Supply> supplies = null;



        try {
            astronauts = repo.loadAstronauts("astronauts.json");
            events = repo.loadEvents("events.json");
            supplies = repo.loadSupplies("supplies.json");
        } catch (IOException e) {
            System.err.println("Eroare la citire: " + e.getMessage());
            return;
        }

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENIU ===");
            System.out.println("1. Afisare date initiale (Task 1)");
            System.out.println("0. Iesire");
            System.out.print("Alege o optiune: ");


            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nDrivers loaded: " + astronauts.size());
                    System.out.println("Events loaded: " + events.size());
                    System.out.println("Penalties loaded: " + supplies.size());
                    astronauts.forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("\nIesire.");
                    running = false;
                    break;

                default:
                    System.out.println("\nOptiune invalida!");
            }
        }
        scanner.close();
    }
}

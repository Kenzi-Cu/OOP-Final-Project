/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise.simpleroomsimulautosorter;

/**
 *
 * @author garre
 */
import java.util.Random;
public class Time {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Room[] rooms = new Room[20];
        // 10 small and rooms
        for (int i = 0; i < 10; i++) {
            rooms[i] = new Room("small");
        }
        for (int i = 10; i < 20; i++) {
            rooms[i] = new Room("big");
        }
        int day = 1;
        while (true) {
            System.out.println("\n<><><><><><> Day " + day + " <><><><><><>");
 for (int i = 0; i < rooms.length; i++) {
                rooms[i].updateDay();
                // Controls chance of request, feel free to change
                int chance = random.nextInt(100);
                if (chance < 5) {
                    System.out.println("Room" + i + "requested" +
                            " (" + rooms[i].getSize() + ")");
                    boolean doubleBooked =
                            rooms[i].requestRoom(random);
                    if (doubleBooked) {
                        System.out.println("DOUBLE BOOKING DETECTED");
                        System.out.println(
                                "Requested room size: " +
                                rooms[i].getRequestedSize()
                        );
                        // Setup for autosorter
                    } else {
                        System.out.println("Room " + i +
                                " occupied for " +
                                rooms[i].getDaysRemaining() +
                                " days.");
                    }
                }
            }
            // Display 
            for (int i = 0; i < rooms.length; i++) {
                System.out.print("Room " + i + " | ");
                if (rooms[i].isOccupied()) {
                    System.out.println("occupied (" +
                            rooms[i].getDaysRemaining() +
                            " days left)");
                } else {
                    System.out.println("Free");
                }
            }
            day++;
            //Controls speed of simulation, feel free to speed up or slow down
            Thread.sleep(1000);
        }
    }
}
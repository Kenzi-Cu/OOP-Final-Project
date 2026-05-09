/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise.simpleroomsimulautosorter;


import java.util.Random;
import java.time.LocalDate

class Room {
    private String size;
    private boolean occupied;
    private int daysRemaining;
    private boolean doubleBooked; //For you to make the autosorter, represents two or more orders for the same room
    private String requestedSize;
    public Room(String size) {
        this.size = size;
        this.occupied = false;
        this.daysRemaining = 0;
        this.doubleBooked = false;
        this.requestedSize = "";
    }

    //This is for adding the option for the user to check each room's statuses, you guys need to make it
    public String getSize() {
        return size;
    }
    public boolean isOccupied() {
        return occupied;
    }
    public int getDaysRemaining() {
        return daysRemaining;
    }
    public boolean isDoubleBooked() {
        return doubleBooked;
    }
    public String getRequestedSize() {
        return requestedSize;
    }
    public boolean requestRoom(Random random) {
        // This detects double bookings
        if (occupied) {
            doubleBooked = true;
            // Then it stores requested room size, use this again for the autosorter
            requestedSize = size;
            return true;
        }
        occupied = true;
        // Randomizes occupancy feel free to change
        daysRemaining = random.nextInt(30) + 1;
        return false;
    }
//Couldn't figure out how to add dates across the year so maybe you guys can help with that?
    public void updateDay() {
        if (occupied) {
            daysRemaining--;
            if (daysRemaining <= 0) {
                occupied = false;
                daysRemaining = 0;
            }
        }
    }
    // Reset function just in case
    public void clearDoubleBooking() {
        doubleBooked = false;
        requestedSize = "";
    }
}


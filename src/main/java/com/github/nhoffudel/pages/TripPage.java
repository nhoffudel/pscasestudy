package com.github.nhoffudel.pages;

import com.github.nhoffudel.DatabaseConnection;
import com.github.nhoffudel.model.Trip;
import com.github.nhoffudel.service.TripService;
import com.github.nhoffudel.utils.IOConsole;

import java.util.List;

public class TripPage implements Runnable{
    private static final IOConsole console = new IOConsole();
    private String username;

    public TripPage(String username){
        this.username = username;
    }

    @Override
    public void run() {
        boolean running = true;
        TripService tripService = new TripService(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
        while (running){
            System.out.println("Welcome to the trip page! Your trips:");
            List<Trip> trips = tripService.findByOwner(username);
            printTrips(trips);
            String userInput = getTripPageDashboardInput();
            if ("add trip".equals(userInput)) {
                Trip newTrip = getAddTripInput();
                newTrip.setOwner(username);
                tripService.create(newTrip);
                System.out.println("Trip added");
            }
            else if ("edit trip".equals(userInput)){
                Long editID = console.getLongInput("Enter the ID of the trip you want to change");
                editTrip(editID);
                System.out.println("Trip edited");
            }
            else if ("delete trip".equals(userInput)){
                Long editID = console.getLongInput("Enter the ID of the trip you want to remove");
                removeTrip(editID);
                System.out.println("Trip deleted");
            }
            else if ("main menu".equals(userInput)) running = false;
            else System.out.println("invalid input");
        }
    }

    private Trip getAddTripInput() {
        Trip newTrip = new Trip();
        newTrip.setVehName(console.getStringInput("Enter the name of the vehicle used"));
        newTrip.setDatebegin(console.getIntegerInput("Enter the date the trip started"));
        newTrip.setDateend(console.getIntegerInput("Enter the date the trip ended"));
        newTrip.setPlacebegin(console.getStringInput("Enter the place the trip started"));
        newTrip.setPlaceend(console.getStringInput("Enter the place the trip ended"));
        newTrip.setMilesbegin(console.getDoubleInput("Enter the miles reading when the trip started"));
        newTrip.setMilesend(console.getDoubleInput("Enter the miles reading when the trip ended"));
        newTrip.setCost(console.getDoubleInput("Enter the cost of the trip"));
        newTrip.setFuelecon(console.getDoubleInput("Enter the fuel economy of the trip"));
        newTrip.setNotes(console.getStringInput("Enter any notes"));
        return newTrip;
    }

    private void editTrip(Long editID) {
        TripService tripService = new TripService(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
        Trip newTrip = tripService.read(editID);
        String thingToEdit = console.getStringInput("What do you want to edit?" +
                "\n\t[ vehicle ], [ date begin ], [ date end ], [ place begin ], [ place end ], " +
                "\n\t[ miles begin ], [ miles end ], [ cost ], [ fuel economy ], [ notes ]");
        switch (thingToEdit) {
            case "vehicle":
                newTrip.setVehName(console.getStringInput("Enter the name of the vehicle used"));
                break;
            case "date begin":
                newTrip.setDatebegin(console.getIntegerInput("Enter the date the trip started"));
                break;
            case "date end":
                newTrip.setDateend(console.getIntegerInput("Enter the date the trip ended"));
                break;
            case "place begin":
                newTrip.setPlacebegin(console.getStringInput("Enter the place the trip started"));
                break;
            case "place end":
                newTrip.setPlaceend(console.getStringInput("Enter the place the trip ended"));
                break;
            case "miles begin":
                newTrip.setMilesbegin(console.getDoubleInput("Enter the miles reading when the trip started"));
                break;
            case "miles end":
                newTrip.setMilesend(console.getDoubleInput("Enter the miles reading when the trip ended"));
                break;
            case "cost":
                newTrip.setCost(console.getDoubleInput("Enter the cost of the trip"));
                break;
            case "fuel economy":
                newTrip.setFuelecon(console.getDoubleInput("Enter the fuel economy of the trip"));
                break;
            case "notes":
                newTrip.setNotes(console.getStringInput("Enter any notes"));
                break;
            default:
                System.out.println("invalid input");
        }
        tripService.update(editID, newTrip);
    }

    private void removeTrip(long id) {
        TripService tripService = new TripService(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
        tripService.delete(id);
    }

    private void printTrips(List<Trip> trips){
        for (Trip t : trips) {
            System.out.println("Trip id: " + t.getId());
            System.out.println("Vehicle used: " + t.getVehName());
            System.out.println("Trip began at " + t.getPlacebegin() + " on " + t.getDatebegin() + " at " + t.getMilesbegin() + " miles");
            System.out.println("Trip ended at " + t.getPlaceend() + " on " + t.getDateend() + " at " + t.getMilesend() + " miles");
            System.out.println("Fuel economy: " + t.getFuelecon() + " Cost: $" + t.getCost());
            System.out.println("Notes: " + t.getNotes() + "\n");
        }
    }

    private String getTripPageDashboardInput() {
        return console.getStringInput("From here, you can do the following things:" +
                "\n\t[ add trip ], [ edit trip ], [ delete trip ], [ main menu ]");
    }
}

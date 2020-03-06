package com.github.nhoffudel.pages;

import com.github.nhoffudel.SQLiteDBConnection;
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
        TripService tripService = new TripService(SQLiteDBConnection.VMS_TRIPS);
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
                Long editID = console.getLongInput("Enter the ID of the trip you want to edit");
                editTrip(editID);
                System.out.println("Trip edited");
            }
            else if ("delete trip".equals(userInput)){
                Long editID = console.getLongInput("Enter the ID of the trip you want to delete");
                removeTrip(editID);
                System.out.println("Trip deleted");
            }
            else if ("main menu".equals(userInput)) running = false;
            else System.out.println("Invalid input");
        }
    }

    private Trip getAddTripInput() {
        Trip newTrip = new Trip();
        newTrip.setVehicleName(console.getStringInput("Enter the name of the vehicle used").replaceAll("'", "`"));
        newTrip.setDateBegin(console.getIntegerInput("Enter the date the trip started in MMDDYY"));
        newTrip.setDateEnd(console.getIntegerInput("Enter the date the trip ended in MMDDYY"));
        newTrip.setPlaceBegin(console.getStringInput("Enter the place the trip started").replaceAll("'", "`"));
        newTrip.setPlaceEnd(console.getStringInput("Enter the place the trip ended").replaceAll("'", "`"));
        newTrip.setMilesBegin(console.getDoubleInput("Enter the mile reading when the trip started"));
        newTrip.setMilesEnd(console.getDoubleInput("Enter the mile reading when the trip ended"));
        newTrip.setCost(console.getDoubleInput("Enter the cost of the trip"));
        newTrip.setFuelEcon(console.getDoubleInput("Enter the fuel economy of the trip"));
        newTrip.setNotes(console.getStringInput("Enter any notes").replaceAll("'", "`"));
        return newTrip;
    }

    private void editTrip(Long editID) {
        TripService tripService = new TripService(SQLiteDBConnection.VMS_TRIPS);
        Trip newTrip = tripService.read(editID);
        String thingToEdit = console.getStringInput("What do you want to edit?" +
                "\n\t[ vehicle ], [ date begin ], [ date end ], [ place begin ], [ place end ], " +
                "\n\t[ miles begin ], [ miles end ], [ cost ], [ fuel economy ], [ notes ]");
        switch (thingToEdit) {
            case "vehicle":
                newTrip.setVehicleName(console.getStringInput("Enter the name of the vehicle used").replaceAll("'", "`"));
                break;
            case "date begin":
                newTrip.setDateBegin(console.getIntegerInput("Enter the date the trip started in MMDDYY"));
                break;
            case "date end":
                newTrip.setDateEnd(console.getIntegerInput("Enter the date the trip ended in MMDDYY"));
                break;
            case "place begin":
                newTrip.setPlaceBegin(console.getStringInput("Enter the place the trip started").replaceAll("'", "`"));
                break;
            case "place end":
                newTrip.setPlaceEnd(console.getStringInput("Enter the place the trip ended").replaceAll("'", "`"));
                break;
            case "miles begin":
                newTrip.setMilesBegin(console.getDoubleInput("Enter the miles reading when the trip started"));
                break;
            case "miles end":
                newTrip.setMilesEnd(console.getDoubleInput("Enter the miles reading when the trip ended"));
                break;
            case "cost":
                newTrip.setCost(console.getDoubleInput("Enter the cost of the trip"));
                break;
            case "fuel economy":
                newTrip.setFuelEcon(console.getDoubleInput("Enter the fuel economy of the trip"));
                break;
            case "notes":
                newTrip.setNotes(console.getStringInput("Enter any notes").replaceAll("'", "`"));
                break;
            default:
                System.out.println("Invalid input");
        }
        tripService.update(editID, newTrip);
    }

    private void removeTrip(long id) {
        TripService tripService = new TripService(SQLiteDBConnection.VMS_TRIPS);
        tripService.delete(id);
    }

    private void printTrips(List<Trip> trips){
        for (Trip t : trips) {
            System.out.println("Trip id: " + t.getId());
            System.out.println("Vehicle used: " + t.getVehicleName());
            System.out.println("Trip began at " + t.getPlaceBegin() + " on " + toDate(t.getDateBegin()) + " at " + t.getMilesBegin() + " miles");
            System.out.println("Trip ended at " + t.getPlaceEnd() + " on " + toDate(t.getDateEnd()) + " at " + t.getMilesEnd() + " miles");
            System.out.println("Fuel economy: " + t.getFuelEcon() + " Cost: $" + t.getCost());
            System.out.println("Notes: " + t.getNotes() + "\n");
        }
    }

    private String toDate(int i){
        String s = String.valueOf(i);
        if (s.length() == 5) s = "0" + s;
        return s.substring(0,2) + "/" + s.substring(2,4) + "/" + s.substring(4);
    }

    private String getTripPageDashboardInput() {
        return console.getStringInput("From here, you can do the following things:" +
                "\n\t[ add trip ], [ edit trip ], [ delete trip ], [ main menu ]");
    }
}

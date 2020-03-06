package com.github.nhoffudel.pages;

import com.github.nhoffudel.SQLiteDBConnection;
import com.github.nhoffudel.model.Vehicle;
import com.github.nhoffudel.service.VehicleService;
import com.github.nhoffudel.utils.IOConsole;

import java.util.List;

public class VehiclePage implements Runnable{
    private static final IOConsole console = new IOConsole();
    private String username;

    public VehiclePage(String username){
        this.username = username;
    }

    @Override
    public void run() {
        boolean running = true;
        VehicleService vehicleService = new VehicleService(SQLiteDBConnection.VMS_VEHICLES);
        while (running){
            System.out.println("Welcome to the vehicle page! You own:");
            List<Vehicle> vehicles = vehicleService.findByOwner(username);
            printVehicles(vehicles);
            String userInput = getVehiclePageDashboardInput();
            if ("add vehicle".equals(userInput)) {
                Vehicle newVehicle = getAddVehicleInput();
                newVehicle.setOwner(username);
                if (vehicleService.read(newVehicle.getVIN()) != null) vehicleService.create(newVehicle);
                else System.out.println("Vehicle already exists in database");
            }
            else if ("edit vehicle".equals(userInput)){
                String editVin = console.getStringInput("Enter the VIN of the vehicle you want to edit");
                editVehicle(editVin);
                System.out.println("Vehicle edited");
            }
            else if ("delete vehicle".equals(userInput)){
                String editVin = console.getStringInput("Enter the VIN of the vehicle you want to delete");
                deleteVehicle(editVin);
                System.out.println("Vehicle deleted");
            }
            else if ("main menu".equals(userInput)) running = false;
            else System.out.println("Invalid input");
        }
    }

    private Vehicle getAddVehicleInput() {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVIN(console.getStringInput("Enter the VIN").replaceAll("'", "`"));
        newVehicle.setName(console.getStringInput("Enter a name for this vehicle").replaceAll("'", "`"));
        newVehicle.setYear(console.getIntegerInput("Enter the year"));
        newVehicle.setMake(console.getStringInput("Enter the make"));
        newVehicle.setModel(console.getStringInput("Enter the model"));
        newVehicle.setTrim(console.getStringInput("Enter the trim level"));
        newVehicle.setEngine(console.getStringInput("Enter the engine"));
        newVehicle.setColor(console.getStringInput("Enter the color"));
        newVehicle.setNotes(console.getStringInput("Enter any notes").replaceAll("'", "`"));
        return newVehicle;
    }

    private void editVehicle(String editVin) {
        VehicleService vehicleService = new VehicleService(SQLiteDBConnection.VMS_VEHICLES);
        Vehicle newVehicle = vehicleService.read(editVin);
        String thingToEdit = console.getStringInput("What do you want to edit?" +
                "\n\t[ name ], [ year ], [ make ], [ model ], " +
                "\n\t[ trim ], [ color ], [ engine ], [ notes ]");
        switch (thingToEdit) {
            case "name":
                newVehicle.setName(console.getStringInput("Enter a new name for this vehicle").replaceAll("'", "`"));
                break;
            case "year":
                newVehicle.setYear(console.getIntegerInput("Enter the new year"));
                break;
            case "make":
                newVehicle.setMake(console.getStringInput("Enter the new make"));
                break;
            case "model":
                newVehicle.setModel(console.getStringInput("Enter the new model"));
                break;
            case "trim":
                newVehicle.setTrim(console.getStringInput("Enter the new trim level"));
                break;
            case "color":
                newVehicle.setColor(console.getStringInput("Enter the new color"));
                break;
            case "engine":
                newVehicle.setEngine(console.getStringInput("Enter the new engine"));
                break;
            case "notes":
                newVehicle.setNotes(console.getStringInput("Enter any new notes").replaceAll("'", "`"));
                break;
            default:
                System.out.println("Invalid input");
        }
        vehicleService.update(newVehicle);
    }

    private void deleteVehicle(String editVin) {
        VehicleService vehicleService = new VehicleService(SQLiteDBConnection.VMS_VEHICLES);
        vehicleService.delete(editVin);
    }

    private void printVehicles(List<Vehicle> vehicles){
        for (Vehicle v : vehicles) {
            System.out.println("Name: " + v.getName());
            System.out.println("VIN: " + v.getVIN());
            System.out.println(v.getYear() + " " + v.getMake() + " " + v.getModel() + " " + v.getTrim());
            System.out.println("Color: " + v.getColor() + " Engine: " + v.getEngine());
            System.out.println("Notes: " + v.getNotes());
        }
    }

    private String getVehiclePageDashboardInput() {
        return console.getStringInput("\nFrom here, you can do the following things:" +
                "\n\t[ add vehicle ], [ edit vehicle ], [ delete vehicle ], [ main menu ]");
    }
}

package com.github.nhoffudel.pages;

import com.github.nhoffudel.DatabaseConnection;
import com.github.nhoffudel.model.Record;
import com.github.nhoffudel.service.RecordService;
import com.github.nhoffudel.utils.IOConsole;

import java.util.List;

public class RecordPage implements Runnable{
    private static final IOConsole console = new IOConsole();
    private String username;

    public RecordPage(String username){
        this.username = username;
    }

    @Override
    public void run() {
        boolean running = true;
        RecordService recordService = new RecordService(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
        while (running){
            System.out.println("Welcome to the service record page! Your records:");
            List<Record> records = recordService.findByOwner(username);
            printRecords(records);
            String userInput = getRecordPageDashboardInput();
            if ("add record".equals(userInput)) {
                Record newRecord = getAddRecordInput();
                newRecord.setOwner(username);
                recordService.create(newRecord);
                System.out.println("Record added");
            }
            else if ("edit record".equals(userInput)){
                Long editID = console.getLongInput("Enter the ID of the record you want to edit");
                editRecord(editID);
                System.out.println("Record edited");
            }
            else if ("delete record".equals(userInput)){
                Long editID = console.getLongInput("Enter the ID of the record you want to delete");
                removeRecord(editID);
                System.out.println("Record deleted");
            }
            else if ("main menu".equals(userInput)) running = false;
            else System.out.println("Invalid input");
        }
    }

    private Record getAddRecordInput() {
        Record newRecord = new Record();
        newRecord.setVehicleVIN(console.getStringInput("Enter the VIN of the vehicle"));
        newRecord.setName(console.getStringInput("Enter the a name for this record"));
        newRecord.setDate(console.getIntegerInput("Enter the date in MMDDYY"));
        newRecord.setMiles(console.getDoubleInput("Enter the miles"));
        newRecord.setCost(console.getDoubleInput("Enter the cost"));
        newRecord.setLocation(console.getStringInput("Enter the location"));
        newRecord.setNotes(console.getStringInput("Enter any notes"));
        return newRecord;
    }

    private void editRecord(Long editID) {
        RecordService recordService = new RecordService(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
        Record newRecord = recordService.read(editID);
        String thingToEdit = console.getStringInput("What do you want to edit?" +
                "\n\t[ vehicle ], [ name ], [ date ], [ miles ] " +
                "\n\t[ cost ], [ location ], [ notes ]");
        switch (thingToEdit) {
            case "vehicle":
                newRecord.setVehicleVIN(console.getStringInput("Enter the VIN of the vehicle"));
                break;
            case "name":
                newRecord.setName(console.getStringInput("Enter the a name for this record"));
                break;
            case "date":
                newRecord.setDate(console.getIntegerInput("Enter the date in MMDDYY"));
                break;
            case "miles":
                newRecord.setMiles(console.getDoubleInput("Enter the miles"));
                break;
            case "cost":
                newRecord.setCost(console.getDoubleInput("Enter the cost"));
                break;
            case "location":
                newRecord.setLocation(console.getStringInput("Enter the location"));
                break;
            case "notes":
                newRecord.setNotes(console.getStringInput("Enter any notes"));
                break;
            default:
                System.out.println("Invalid input");
        }
        recordService.update(editID, newRecord);
    }

    private void removeRecord(long id) {
        RecordService recordService = new RecordService(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
        recordService.delete(id);
    }

    private void printRecords(List<Record> records){
        for (Record r : records) {
            System.out.println("Record id: " + r.getId() + " Service name: " + r.getName());
            System.out.println("Date: " + toDate(r.getDate()) + " at " + r.getMiles() + " miles");
            System.out.println("Performed at: " + r.getLocation() + " at cost: $" + r.getCost());
            System.out.println("Notes: " + r.getNotes());
        }
    }

    private String toDate(int i){
        String s = String.valueOf(i);
        return s.substring(0,2) + "/" + s.substring(2,4) + "/" + s.substring(4);
    }

    private String getRecordPageDashboardInput() {
        return console.getStringInput("\nFrom here, you can do the following things:" +
                "\n\t[ add record ], [ edit record ], [ delete record ], [ main menu ]");
    }
}

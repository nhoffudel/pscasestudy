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
            System.out.println("Welcome to the record page! Your records:");
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
                Long editID = console.getLongInput(new StringBuilder().append("Enter the ID of the record you want to change").toString());
                editRecord(editID);
                System.out.println("Record edited");
            }
            else if ("delete record".equals(userInput)){
                Long editID = console.getLongInput(new StringBuilder().append("Enter the ID of the record you want to remove").toString());
                removeRecord(editID);
                System.out.println("Record deleted");
            }
            else if ("main menu".equals(userInput)) running = false;
            else System.out.println("invalid input");
        }
    }

    private Record getAddRecordInput() {
        Record newRecord = new Record();
        newRecord.setVehVIN(console.getStringInput(new StringBuilder().append("Enter the VIN of the vehicle").toString()));
        newRecord.setName(console.getStringInput(new StringBuilder().append("Enter the a name for this record").toString()));
        newRecord.setDate(console.getIntegerInput(new StringBuilder().append("Enter the date").toString()));
        newRecord.setMiles(console.getDoubleInput(new StringBuilder().append("Enter the miles").toString()));
        newRecord.setCost(console.getDoubleInput(new StringBuilder().append("Enter the cost").toString()));
        newRecord.setLocation(console.getStringInput(new StringBuilder().append("Enter the location").toString()));
        newRecord.setNotes(console.getStringInput(new StringBuilder().append("Enter any notes").toString()));
        return newRecord;
    }

    private void editRecord(Long editID) {
        RecordService recordService = new RecordService(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
        Record newRecord = recordService.read(editID);
        newRecord.setVehVIN(console.getStringInput(new StringBuilder().append("Enter the VIN of the vehicle").toString()));
        newRecord.setName(console.getStringInput(new StringBuilder().append("Enter the a name for this record").toString()));
        newRecord.setDate(console.getIntegerInput(new StringBuilder().append("Enter the date").toString()));
        newRecord.setMiles(console.getDoubleInput(new StringBuilder().append("Enter the miles").toString()));
        newRecord.setCost(console.getDoubleInput(new StringBuilder().append("Enter the cost").toString()));
        newRecord.setLocation(console.getStringInput(new StringBuilder().append("Enter the location").toString()));
        newRecord.setNotes(console.getStringInput(new StringBuilder().append("Enter any notes").toString()));
        recordService.update(editID, newRecord);
    }

    private void removeRecord(long id) {
        RecordService recordService = new RecordService(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
        recordService.delete(id);
    }

    private void printRecords(List<Record> records){
        for (Record r : records) {
            System.out.println("Record id: " + r.getId() + " Name: " + r.getName());
            System.out.println("Date: " + r.getDate() + " at " + r.getMiles() + " miles");
            System.out.println("Performed at: " + r.getLocation() + " at cost: $" + r.getCost());
            System.out.println("Notes: " + r.getNotes());
        }
    }

    private String getRecordPageDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nFrom here, you can do the following things:")
                .append("\n\t[ add record ], [ edit record ], [ delete record ], [ main menu ]")
                .toString());
    }
}

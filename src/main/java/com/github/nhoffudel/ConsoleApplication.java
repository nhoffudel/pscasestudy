package com.github.nhoffudel;

public class ConsoleApplication {
    public static void main(String[] args) {
        JdbcConfigurator.initialize();
        Runnable sms = new VehicleManagementSystem();
        sms.run();
    }
}

package com.github.nhoffudel;

public class MainApplication {
    public static void main(String[] args) {
        JdbcConfigurator.initialize();
        Runnable sms = new VehicleManagementSystem();
        sms.run();
    }
}

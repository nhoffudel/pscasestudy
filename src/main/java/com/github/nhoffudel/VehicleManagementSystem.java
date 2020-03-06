package com.github.nhoffudel;

import com.github.nhoffudel.model.User;
import com.github.nhoffudel.pages.*;
import com.github.nhoffudel.service.UserService;
import com.github.nhoffudel.utils.IOConsole;

public class VehicleManagementSystem implements Runnable {
    private static final IOConsole console = new IOConsole();

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            String smsDashboardInput = getVehicleManagementSystemDashboardInput();
            if ("login".equals(smsDashboardInput)) {
                UserService userService = new UserService(SQLiteDBConnection.VMS_USERS);
                String username = console.getStringInput("Enter your username:");
                if (!userService.contains(username)) System.out.println("User not found");
                else {
                    String userPassword = console.getStringInput("Enter your password:");
                    Boolean isValidLogin = userService.validateUser(username, userService.hashPass(userPassword));
                    if (isValidLogin) {
                        boolean loggedIn = true;
                        while (loggedIn) {
                            User user = userService.read(username);
                            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
                            String userDashboardInput = getUserDashboardInput();
                            if ("vehicles".equals(userDashboardInput)) {
                                VehiclePage vehiclePage = new VehiclePage(username);
                                vehiclePage.run();
                            } else if ("trips".equals(userDashboardInput)) {
                                TripPage tripPage = new TripPage(username);
                                tripPage.run();
                            } else if ("records".equals(userDashboardInput)) {
                                RecordPage recordPage = new RecordPage(username);
                                recordPage.run();
                            } else if ("change password".equals(userDashboardInput)) {
                                UserPage userPage = new UserPage(username);
                                userPage.changePassword();
                            } else if ("change name".equals(userDashboardInput)) {
                                UserPage userPage = new UserPage(username);
                                userPage.changeName();
                            } else if ("logout".equals(userDashboardInput)) loggedIn = false;
                            else System.out.println("Invalid input");
                        }
                    }
                    else System.out.println("Invalid login");
                }
            } else if ("register".equals(smsDashboardInput)) {
                UserPage userPage = new UserPage();
                userPage.register();
            } else if ("forgot password".equals(smsDashboardInput)) {
                UserPage userPage = new UserPage();
                userPage.forgotPassword();
            } else if ("quit".equals(smsDashboardInput)) {
                System.out.println("Closing application");
                running = false;
            } else System.out.println("Invalid input");
        }
    }

    private String getVehicleManagementSystemDashboardInput() {
        return console.getStringInput("Welcome to the Vehicle Management System Dashboard!" +
                "\nFrom here, you can select any of the following options:" +
                "\n\t[ login ], [ forgot password ],  [ register ], [ quit ]");
    }

    private String getUserDashboardInput() {
        return console.getStringInput("Welcome to the main menu!" +
                "\nFrom here, you can go to the following pages:" +
                "\n\t[ vehicles ], [ trips ], [ records ], [ change password ], [ logout ]");
    }

}

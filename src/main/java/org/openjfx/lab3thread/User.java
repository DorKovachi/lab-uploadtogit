package org.openjfx.lab3thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class User{
    private static int maxLengthUserName = 50;
    private static int maxlengthPassword = 12;
    private static int minLengthPassword = 8 ;
    private String userName;
    private String userPass;


    public User(String userName, String password){
        if(userName.length() > maxLengthUserName)
            throw new IllegalArgumentException("Username is too long, try something shorter" + userName);
        if(!userName.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            throw new IllegalArgumentException("Please enter a valid Email as username" + userName);
        if(password.length() > maxlengthPassword)
            throw new IllegalArgumentException("Your password is too long, try a shorter one" + password);
        if(password.length() < minLengthPassword)
            throw new IllegalArgumentException("Your password is too short, add more characters" + password);
        if(!password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&.\\^])[A-Za-z\\d@$!%*#?&.\\^]{8,}$"))
            throw new IllegalArgumentException("Please enter a valid password" + password);

        this.userName = userName;
        this.userPass = password;
        System.out.println(userName + password);
    }

    public String getName(){
        return this.userName;
    }

    public String getUserPass(){
        return this.userPass;
    }


    //scans users from a txt file, line by line username and password are separated by spaces.
    public static ArrayList<User> scanUsersFromFile(String filePath) {
        ArrayList<User> users = new ArrayList<User>();

        File readFile = new File(filePath);

        // try-with-resources: Scanner will be closed automatically
        try (Scanner Reader = new Scanner(readFile)) {
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                String[] dataSplited = data.split("\\s+");

                User nextUser;
                try {
                    nextUser = new User(dataSplited[0], dataSplited[1]);
                    users.add(nextUser);
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return users;
    }

}

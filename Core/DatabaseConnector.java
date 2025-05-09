package Core;

import java.io.*;
import java.util.*;

/**
 * Responsible for handling database operations related to user data.
 * This class provides methods to add users to a file, search for users by username,
 * and retrieve all stored users for authentication and other purposes.
 */
public class DatabaseConnector {
    /**
     * The file path where user data is stored.
     */
    private final String filePath;

    /**
     * Constructs a {@code DatabaseConnector} with the specified file path.
     *
     * @param filePath the file path where the user data will be stored
     */
    public DatabaseConnector(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Adds a new user to the database by appending the user's details to a file.
     * The user details are written in the following format: name, username, email, password.
     *
     * @param user the {@link UserData} object containing the user's information
     */
    public void addUser(UserData user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.getName() + "," + user.getUsername() + "," + user.getEmail() + "," + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for a user by their username in the database file.
     *
     * @param username the username to search for
     * @return {@code true} if the username exists in the file, {@code false} otherwise
     */
    public boolean searchForUser(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 1 && fields[1].equals(username)) {
                    return true; // Username found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Username not found
    }

    /**
     * Retrieves the list of stored users from the database file.
     * This is used for validating login credentials, checking usernames and passwords.
     *
     * @return a list of {@link UserData} objects representing all users in the file
     */
    public List<UserData> getStoredUsers() {
        List<UserData> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    users.add(new UserData(fields[0], fields[1], fields[2], fields[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}

package Core;
import java.io.*;
import java.util.*;

// database connector which stores the data of the new users into the file
public class DatabaseConnector {
    private final String filePath;

    // constructor
    public DatabaseConnector(String filePath) {
        this.filePath = filePath;
    }

    // adding a new user
    public void addUser(UserData user) {
        // writing into the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.getName() + "," + user.getUsername() + "," + user.getEmail() + "," + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // searching if a user exists using the given new username
    public boolean searchForUser(String username) {
        // extracting the data that is stored in the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                // checking if the stored username is equal to the input username
                if (fields.length > 1 && fields[1].equals(username)) {
                    return true; // username found so not unique
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // username not found, so input username is unique
        return false;
    }

    // getting the list of the stored data of users in the file
    // used inorder to check the usernames and passwords if they match the input during log in process
    public List<UserData> getStoredUsers() {
        List<UserData> users = new ArrayList<>();

        // reading from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // taking each line, extracting each field alone, and adding it to the list
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

package Core;

/**
 * Represents a user and their associated information.
 * This class is used to store and retrieve user data such as name, username, email, and password.
 */
public class UserData {
    /**
     * The user's full name.
     */
    private String name;

    /**
     * The user's username.
     */
    private String username;

    /**
     * The user's email address.
     */
    private String email;

    /**
     * The user's password.
     */
    private String password;

    /**
     * Default constructor for creating a {@link UserData} object without initializing any fields.
     */
    public UserData() {}

    /**
     * Constructs a {@code UserData} object with the specified user information.
     *
     * @param name     the user's full name
     * @param username the user's unique username
     * @param email    the user's email address
     * @param password the user's password
     */
    public UserData(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Returns the user's full name.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the user's unique username.
     *
     * @return the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the user's email address.
     *
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the user's password.
     *
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's username.
     *
     * @param username the new username to assign to the user
     */
    public void setUsername(String username) {
        this.username = username;
    }
}

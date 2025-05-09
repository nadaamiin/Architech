package Add_card;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a bank entity with a name and a unique bank ID.
 * Also manages a static list of valid supported banks.
 */

public class Bank {
    /**
     * The name of the bank.
     */
    private String name;

    /**
     * The unique identifier of the bank.
     */
    private String bankId;

    /**
     * A static map of valid banks, where the key is the lowercase bank name
     * and the value is the corresponding Bank object.
     */
    private static final Map<String, Bank> validBanks = new HashMap<>();

    /**
     * Initializes and populates the list of supported banks.
     * This method should be called once during application startup.
     */
    public static void setSuppBanks() {
        Bank cib;
        cib = new Bank();
        cib.setName("CIB");
        cib.setBankId("444");

        Bank qnb;
        qnb = new Bank();
        qnb.setName("QNB");
        qnb.setBankId("310");

        Bank hsbc;
        hsbc = new Bank();
        hsbc.setName("HSBC");
        hsbc.setBankId("199");

        Bank Alahly;
        Alahly = new Bank();
        Alahly.setName("Alahly");
        Alahly.setBankId("111");

        Bank misr;
        misr = new Bank();
        misr.setName("Misr");
        misr.setBankId("172");

        Bank alexandria;
        alexandria = new Bank();
        alexandria.setName("Alexandria");
        alexandria.setBankId("211");

        validBanks.put(cib.getName().toLowerCase(), cib);
        validBanks.put(qnb.getName().toLowerCase(), qnb);
        validBanks.put(hsbc.getName().toLowerCase(), hsbc);
        validBanks.put(Alahly.getName().toLowerCase(), Alahly);
        validBanks.put(misr.getName().toLowerCase(), misr);
        validBanks.put(alexandria.getName().toLowerCase(), alexandria);
    }

    /**
     * Retrieves a {@link Bank} object based on its name.
     *
     * @param name the name of the bank (case-insensitive)
     * @return the matching {@link Bank} object if found, or null otherwise
     */
    public static Bank getBankByName(String name) {

        return validBanks.get(name.toLowerCase());
    }

    /**
     * Prints the names of all supported banks to the console.
     */
    public static void getBanks() {
        System.out.println("Supported Banks:");
        for (String key : validBanks.keySet()) {
            System.out.println("- " + validBanks.get(key).getName());
        }
    }

    /**
     * Returns the name of the bank.
     *
     * @return the name of the bank
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the bank.
     *
     * @param name the name to set for the bank
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the unique ID of the bank.
     *
     * @return the bank's ID
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * Sets the unique ID of the bank.
     *
     * @param bankId the ID to set for the bank
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * Returns the map of valid supported banks.
     *
     * @return the map of bank names to {@link Bank} objects
     */
    public Map<String, Bank> getValidBanks() {
        return validBanks;
    }
}

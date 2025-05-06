package Add_card;

import java.util.Map;

public class Bank {
    private String name;
    private String bankId;
    private Map<String, Bank> validBanks;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBankId() {
        return bankId;
    }
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
    public Map<String, Bank> getValidBanks() {
        return validBanks;
    }
    public void setValidBanks(Map<String, Bank> validBanks) {
        this.validBanks = validBanks;
    }

}

package Add_card;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String name;
    private String bankId;
    // Static shared list of supported banks
    private static final Map<String, Bank> validBanks = new HashMap<>();

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

    public static Bank getBankByName(String name) {
        return validBanks.get(name.toLowerCase());
    }
    public static void getBanks() {
        System.out.println("Supported Banks:");
        for (String key : validBanks.keySet()) {
            System.out.println("- " + validBanks.get(key).getName());
        }
    }

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
}

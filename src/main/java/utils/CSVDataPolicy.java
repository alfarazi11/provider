package utils;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVDataPolicy {

    private static final String USER_CSV = System.getProperty("user.dir") + "/data/DataPolicy.csv";

    @CsvBindByName(column = "cardnum")
    private String cardNum;

    @CsvBindByName(column = "dob")
    private String dob;

    @CsvBindByName(column = "type")
    private String type;

    @CsvBindByName(column = "note")
    private String note;

    public CSVDataPolicy getPolicyUnderCorporate(){
        CSVDataPolicy csvDataPolicy = new CSVDataPolicy();
        List<CSVDataPolicy> policyList = csvDataPolicy.getPolicyList();
        for (int i = 0; i < policyList.size(); i++){
            if (policyList.get(i).getType().equalsIgnoreCase("Policy Under corporate")) {
                return policyList.get(i);
            }
        }
        return null;
    }

    public CSVDataPolicy getPolicyIndividual() {
        CSVDataPolicy csvDataPolicy = new CSVDataPolicy();
        List<CSVDataPolicy> policyList = csvDataPolicy.getPolicyList();

        for (int i = 0; i < policyList.size(); i++){
            if (policyList.get(i).getType().equalsIgnoreCase("Policy Individual")) {
                return policyList.get(i);
            }
        }
        return null;
    }

    public CSVDataPolicy getInValidPass() {
        CSVDataPolicy csvDataPolicy = new CSVDataPolicy();
        List<CSVDataPolicy> policyList = csvDataPolicy.getPolicyList();

        for (int i = 0; i < policyList.size(); i++){
            if (policyList.get(i).getType().equalsIgnoreCase("invalidPass")) {
                return policyList.get(i);
            }
        }
        return null;
    }

    public List<CSVDataPolicy> getPolicyList() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(USER_CSV));
        ) {
            CsvToBean<CSVDataPolicy> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVDataPolicy.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getDOB() {
        return dob;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

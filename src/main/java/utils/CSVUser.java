package utils;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVUser {

    private static final String USER_CSV = System.getProperty("user.dir") + "/data/UserData.csv";
    private static final String USER_Prod_CSV = System.getProperty("user.dir") + "/data/UserDataProd.csv";

    @CsvBindByName(column = "username")
    private String userName;

    @CsvBindByName(column = "password")
    private String password;

    @CsvBindByName(column = "type")
    private String type;

    public CSVUser getValidUser(){
        CSVUser csvUser = new CSVUser();
        List<CSVUser> userList = csvUser.getUserList();
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getType().equalsIgnoreCase("valid")) {
                return userList.get(i);
            }
        }
        return null;
    }

    public CSVUser getInValidUName() {
        CSVUser csvUser = new CSVUser();
        List<CSVUser> userList = csvUser.getUserList();

        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getType().equalsIgnoreCase("invalidUsername")) {
                return userList.get(i);
            }
        }
        return null;
    }

    public CSVUser getInValidPass() {
        CSVUser csvUser = new CSVUser();
        List<CSVUser> userList = csvUser.getUserList();

        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getType().equalsIgnoreCase("invalidPass")) {
                return userList.get(i);
            }
        }
        return null;
    }

    public List<CSVUser> getUserList() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(USER_CSV));
//                Reader reader = Files.newBufferedReader(Paths.get(USER_Prod_CSV));
        ) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

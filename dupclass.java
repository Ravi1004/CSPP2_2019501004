import java.util.*;

public class User {
    private String userName;
    private String[] allConnections;
    private int number;

    User(){
        this.userName = "";
        this.allConnections = new String[50];
        this.number = 0;
    }

    User(String name, String[] connections){
        this.userName = name;
        this.allConnections = connections;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getAllConnections() {
        return allConnections;
    }

    public void setAllConnections(String[] allConnections) {
		this.allConnections = allConnections;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}

   

   
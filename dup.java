/**
 * This class implements all the methods of the SocialNetworkInterface 
 * You are free to add your own behaviours to this class.
 * 
 * @author Siva Sankar
 */

import java.util.Arrays;

public class SocialNetwork {

    /**
     * users indicates the actual users in the network
     */
    User[] users;

    /**
     * The size indicates the numebr of users in the network
     */
    int size;

    /**
     * Initializes the default values of the social network.
     */
    public SocialNetwork() {
        // TODO
        // Your code goes here
        User[] users = new User[50];
        size = 0; 

    }

    /**
     * This method takes the string as a parameter which is used
     * to create a network. do nothing if the string is empty.
     * 
     * @param str to be used to create a network.
     */
    public void createDataStructure(String str) {
        // TODO
        // Your code goes here
        if(str.length() != 0){
            String[] tokens = str.split("\r\n");
            for(int j = 0 ; j < tokens.length ; j++){
                String[] words = (tokens[j]).split(" ");
                users[size].setUserName(words[0]);
                users[size].setAllConnections(words[words.length-1].split(","));
                size++;
            }
        }
        return;
    }

    private boolean searchUser(User user) {
        for (int i = 0; i < size; i++) {
            if (user.equals(users[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Please don't modify the follwoing code.
     * This method returns the User based on the userName.
     * 
     * @param userName the string to be used to search for the user.
     * @return the User object based on the userName. 
     * Returns null otherwise
     */
    public User getUser(String userName) {
        for (int i = 0; i < size; i++) {
            if (userName.equals(users[i].getUserName())) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * This method adds a new User (object) that is passed as 
     * argument to the social network if the user is not currently 
     * on the social network.
     * @param userA to be added to the social network.
     */
    public void addUser(User userA) {
        // TODO
        // Your code goes here
        int temp = 0;
        for (int i = 0 ; i < size ; i++){
            if(users[i] != userA){
                temp++;
            }
        }
        if(temp == size){
            users[size] = userA;
            size++;
        }
        return;
    }

    /**
     * This method takes two users (objects) as arguments and 
     * connects them on the network. userA and userB are 
     * the users that are passed as parameters to this function, 
     * then add userB to userA’s connections
     * 
     * Note: Both userA and userB should be there on the network.
     * if anyone of them are not on the network, then do nothing.
     * 
     * @param userA the userB is to be added to userA connections
     * @param userB to be added to userA connections
     */
    public void addConnection(User userA, User userB) {
        // TODO
        // Your code goes here
        if(searchUser(userA) && searchUser(userB)){
            for (int i = 0 ; i < size ; i++){
                if(users[i] == userA){
                    String[] temp = new String[users[i].getNumber()+1];
                    temp = users[i].getAllConnections();
                    for (int j = 0 ; j < size ; j++){
                        if(users[j] == userB){
                            temp[temp.length-1] = users[j].getUserName();
                        }
                    users[i].setAllConnections(temp);
                    temp = null;
                    users[i].setNumber(users[i].getNumber()+1);

                }
            }
        }
    }
    }

    /**
     * This method takes a user object as an argument that returns the 
     * connections of this user. Return null if the user is not in 
     * the network.
     * 
     * @param userA the user object used to return the 
     * connections of this user.
     * 
     * @return the list of connections of userA. otherwise return null
     */
    public String[] getConnections(User userA) {
        // TODO
        // Your code goes here
        for (int i = 0 ; i < size ; i++){
            if(userA.equals(users[i])){
                return users[i].getAllConnections();
            }
        }
        return null;
    }

    /**
     * This method returns the common connections of userA and userB.
     * Note: both userA and userB should be on the network. if anyone 
     * of them is not in the network, then return null
     * 
     * @param userA the first user
     * @param userB the second user
     * 
     * @return the common connections of both userA and userB if they 
     * both are in the network, otherwise return null
     */
    public User[] getCommonConnections(User userA, User userB) {
        // TODO
        // Your code goes here
        String[] list = new String[10];
        int temp2 = 0;
        for(int k = 0 ; k < userA.getNumber() ; k++){
            if (Arrays.asList(userA.getAllConnections()).contains(userA.getAllConnections()[k])){
                list[temp2] = userA.getAllConnections()[k];
                temp2++ ;
            }
        }

        return null;
    }

    /**
     * This reutrns the String version of the social network.
     * 
     * @return the String version of the network, return an empty string
     * if there are no users in the network.
     */
    public String toString() {
        if (this.size == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (i = 0; i < size-1; i++) {
            sb.append(users[i] + "\n");
        }
        sb.append(users[i]);
        return sb.toString();
    }
}
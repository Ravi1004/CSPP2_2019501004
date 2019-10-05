public class User {
    import java.util.*;

public class User {
    private String name;
    private User[] connections;
    private Integer number;
    private User{

    }
    public User(String name,Integer number){
        this.name = name;
        this.connections = connections;
        this.number = number;
    }
	
	public User(String name,Integer number){
        this.name = name;
        this.number = number;
    }
	
	public User(User user)
	{
		this.name = user.name;
		this.number = user.number;
		this.connections = user.connections;
	}
	
    public String getName() {
        return name;
    }

    public User[] getConnections() {
        return connections;
    }
    public Integer getNumber() {
        return number;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setConnection(User connection) {
        connections.add(connection);
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getUserName(){
        String str = this.getName() + " : " + "["
		for(i  = 0 ; i < connections.length - 1 ; i++){
			str = str + connections[i].getName() + ",";
		}
		str = str + connections[connections.length - 1] + "]";
    }
    
}
    
}
import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;

class Player implements Comparable<Player>{
    private String name;
    private int score;
    private int level;


    public Player(String name, int level, int score){
        this.name = name;
        this.level = level;
        this.score = score;
        
    }

    public String getName(){
        return this.name;
    }
    public int getLevel(){
        return this.level;
    }
    public int getScore(){
        return this.score;
    }
    public String setName(){
        return name;
    }
    public void setScore(int score, int bonus){
        this.score = score + bonus;
    }

    
    public int compareTo(Player p){
        return p.score - this.score;
    }

    public String toString(){
        return "Player\t Name : "+this.name+"\t Score : "+this.score+" ";
    }
}
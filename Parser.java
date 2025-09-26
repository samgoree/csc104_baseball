import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import java.text.ParseException;

public class Parser {
    // A class to parse the teams.json file
    // Don't edit this class
    Scanner player_sc, team_sc;
    int playerAttributes, teamAttributes;
    public Parser(String playersPath, String teamPath) throws ParseException, FileNotFoundException{
        player_sc = new Scanner(new File(playersPath));
        playerAttributes = player_sc.nextLine().split(",").length;
        if(playerAttributes!= 3){ throw new ParseException("Player file has the wrong number of fields.", 0);}
        team_sc = new Scanner(new File(teamPath));
        teamAttributes = team_sc.nextLine().split(",").length;
    }

    public boolean hasNextTeam(){
        // returns true if there is a next team
        return team_sc.hasNextLine();
    }

    public boolean hasNextPlayer(){
        // returns true if there is a next player
        return player_sc.hasNextLine();
    }

    public Player getPlayer(){
        /*
         * Get the next player from the player file
         * Assumes the player file has fields name,position,team
         */
        String[] data = player_sc.nextLine().split(",");
        String name = data[0];
        String position = data[1];
        String team = data[2];

        return new Player(name, position, team);
        
    }

    public Team getTeam(){
        /*
         * Get the next team from the team file
         * Assumes the team file has fields location,nickname
         */
        String[] data = team_sc.nextLine().split(",");
        String location = data[0];
        String nickname = data[1];

        return new Team(location, nickname);
        
    }
}

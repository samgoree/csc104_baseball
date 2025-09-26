import java.io.FileNotFoundException;
import java.text.ParseException;

import javax.management.openmbean.InvalidKeyException;

public class Baseball {

    public static void main(String[] args){
        Team[] teams;
        try{
            Parser p = new Parser("all_players.csv", "teams.csv");
            teams = new Team[12];
            int i = 0;
            while(p.hasNextTeam()){
                teams[i] = p.getTeam();
            }
            String team;
            Player player;
            boolean found;
            while(p.hasNextPlayer()){
                player = p.getPlayer();
                team = player.team;
                found = false;
                for(i = 0; i < teams.length; i++){
                    if(team.equals(teams[i].nickname)){
                        teams[i].addPlayer(player);
                        found = true;
                        break;
                    }
                }
                if(!found) throw new InvalidKeyException("Team " + team +" not found for player " + player);
            }

            Game g;
            for(int team1 = 0; team1 < teams.length; team1++){
                for(int team2 = team1+1; team2 < teams.length; team2++){
                    g = new Game(teams[team1], teams[team2]);
                    g.play();

                }
            }
        } catch(FileNotFoundException e){
            System.out.println(e);
        } catch(ParseException e){
            System.out.println(e);
        }
        
    }
}

package guildWithoutStreams;

import guild.Guild;
import guild.Player;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository (guild)
        guild.Guild guild = new Guild("Weekend Raiders", 20);
        //Initialize entity
        guild.Player player = new guild.Player("Mark", "Rogue");
        //Print player
        System.out.println(player);
        //Player Mark: Rogue
        //Rank: Trial
        //Description: n/a

        //Add player
        guild.addPlayer(player);
        System.out.println(guild.count()); //1
        System.out.println(guild.removePlayer("Gosho")); //false

        guild.Player firstPlayer = new guild.Player("Pep", "Warrior");
        guild.Player secondPlayer = new guild.Player("Lizzy", "Priest");
        guild.Player thirdPlayer = new guild.Player("Mike", "Rogue");
        guild.Player fourthPlayer = new guild.Player("Marlin", "Mage");

        //Add description to player
        secondPlayer.setDescription("Best healer EU");

        //Add players
        guild.addPlayer(firstPlayer);
        guild.addPlayer(secondPlayer);
        guild.addPlayer(thirdPlayer);
        guild.addPlayer(fourthPlayer);

        //Promote player
        guild.promotePlayer("Lizzy");

        //Remove Player
        System.out.println(guild.removePlayer("Pep")); //true

        guild.Player[] kickedPlayers = guild.kickPlayersByClass("Rogue");
        for (Player kickedPlayer : kickedPlayers) {
            System.out.print(kickedPlayer.getName() + " ");
        }
        //Mark Mike

        System.out.println(guild.report());
        //Players in the guild: Weekend Raiders:
        //Player Lizzy: Priest
        //Rank: Member
        //Description: Best healer EU
        //Player Marlin: Mage
        //Rank: Trial
        //Description: n/a

    }
}

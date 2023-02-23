package guildWithoutStreams;

import guild.Player;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<guild.Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(guild.Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        int index = findPlayerIndex(name);
        if (index != -1) {
            this.roster.remove(index);
            return true;
        }
        return false;
    }

    public void promotePlayer(String name) {
        int index = findPlayerIndex(name);
        if (index != -1) {
            this.roster.get(index).setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        int index = findPlayerIndex(name);
        if (index != -1) {
            this.roster.get(index).setRank("Trial");
        }
    }

    public guild.Player[] kickPlayersByClass(String clazz) {
        int count = 0;
        for (guild.Player player : this.roster) {
            if (player.getClazz().equals(clazz)) {
                count++;
            }
        }

        guild.Player[] arr = new guild.Player[count];

        int index = 0;
        for (guild.Player player : this.roster) {
            if (player.getClazz().equals(clazz)) {
                arr[index++] = player;
            }
        }

        for (guild.Player player : arr) {
            this.roster.remove(player);
        }

        return arr;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Players in the guild: " + this.name + ":"
                + System.lineSeparator());

        for (Player player : roster) {
            sb.append(player.toString())
                    .append(System.lineSeparator());

        }
        return sb.toString().trim();
    }

    private int findPlayerIndex(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}

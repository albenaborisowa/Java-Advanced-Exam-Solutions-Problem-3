package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    //        public boolean removePlayer(String name) {
//        int index = findPlayerIndex(name);
//        if (index != -1) {
//            this.roster.remove(index);
//            return true;
//        }
//        return false;
//    }
    public boolean removePlayer(String name) {
        Player player = this.roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (player != null) {
            this.roster.remove(player);
            return true;
        }
        return false;
    }

//    public void promotePlayer(String name) {
//        int index = findPlayerIndex(name);
//        if (index != -1) {
//            this.roster.get(index).setRank("Member");
//        }
//    }

    public void promotePlayer(String name) {
        Player player = this.roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (player != null) {
            player.setRank("Member");
        }
    }

//    public void demotePlayer(String name) {
//        int index = findPlayerIndex(name);
//        if (index != -1) {
//            this.roster.get(index).setRank("Trial");
//        }
//    }

    public void demotePlayer(String name) {
        Player player = this.roster.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (player != null) {
            player.setRank("Trial");
        }
    }

//    public Player[] kickPlayersByClass(String clazz) {
//        int count = 0;
//        for (Player player : this.roster) {
//            if (player.getClazz().equals(clazz)) {
//                count++;
//            }
//        }
//
//        Player[] arr = new Player[count];
//
//        int index = 0;
//        for (Player player : this.roster) {
//            if (player.getClazz().equals(clazz)) {
//                arr[index++] = player;
//            }
//        }
//
//        for (Player player : arr) {
//            this.roster.remove(player);
//        }
//        return arr;
//    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removedPlayers = this.roster.stream()
                .filter(p -> p.getClazz().equals(clazz))
                .collect(Collectors.toList());

        this.roster.removeAll(removedPlayers);

        return removedPlayers.toArray(Player[]::new);
    }

    public int count() {
        return this.roster.size();
    }

//    public String report() {
//        StringBuilder sb = new StringBuilder("Players in the guild: " + this.name + ":"
//                + System.lineSeparator());
//
//        for (Player player : this.roster) {
//            sb.append(player.toString())
//                    .append(System.lineSeparator());
//        }
//        return sb.toString().trim();
//    }

    public String report() {
        return String.format("Players in the guild: %s:%n%s", this.name,
                this.roster.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim());

    }

//    private int findPlayerIndex(String name) {
//        for (int i = 0; i < this.roster.size(); i++) {
//            if (this.roster.get(i).getName().equals(name)) {
//                return i;
//            }
//        }
//        return -1;
//    }
}

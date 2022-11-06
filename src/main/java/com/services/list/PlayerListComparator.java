package com.services.list;

import java.util.Comparator;

import com.handballCamp.model.Player;

public class PlayerListComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {

        String nameP1 = p1.getName();
        String nameP2 = p2.getName();

        return nameP1.compareTo(nameP2);
    }

}

package com.services.list;

import com.handballCamp.model.Team;

public class PlayerListService {

    public void List(Team team) {

        PlayerListComparator Organizer = new PlayerListComparator();

        team.getPlayers().sort(Organizer);

        team.getPlayers()
                .forEach(player -> System.out.println("Nome: " + player.getName() + ", Nº: " + player.getNumber()));

    }

}

import java.util.Comparator;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        //-------------------------------------------------------------------------------------------------------------------------------//
        
        Player homeplayer1 = new Player("João Luiz","03/05/2002",'M',1.85, 13);
        Player homeplayer2 = new Player("Eduardo","15/03/2002",'M',1.80, 10);
        Player homeplayer3 = new Player("Devid ","20/08/2000",'M',1.68, 30);
        Player homeplayer4 = new Player("Lucas","03/09/2001",'M',1.84, 14);
        Player homeplayer5 = new Player("Caio","11/01/2002",'M',1.90, 95);
        Player homeplayer6 = new Player("Artur","14/05/2003",'M',1.72, 18);
        Player homeplayer7 = new Player("Fabiano","17/08/2001",'M',1.83, 22);
        
        Captain teamCaptain = new Captain(homeplayer5); // <-- Estabelecendo capitão do Time mandante
        
        Stadium defaultStadium = new Stadium("Estádio Municipal Nilton Santos", null); // <-- Estádio do time mandante

        Address nsAdress = new Address("Q. 1602 Sul ", null, "77103-970", "Plano Diretor Sul");

        defaultStadium.setAddress(nsAdress); // Editando endereço do estádio local

        
        Team teamId1 = new Team("Palmas FC", teamCaptain, defaultStadium, 0); // <-- Criando o time de casa
        

        //===Introduzindo jogadores ao time====//
            teamId1.addPlayer(homeplayer1);
            teamId1.addPlayer(homeplayer2);
            teamId1.addPlayer(homeplayer3);
            teamId1.addPlayer(homeplayer4);
            teamId1.addPlayer(homeplayer5);
            teamId1.addPlayer(homeplayer6);
            teamId1.addPlayer(homeplayer7);
        //=====================================//

        //===========================================================================//
        class PlayerComparator implements Comparator<Player> { // classe comparadora
            
            @Override
            public int compare(Player p1, Player p2) {
                
                String nameP1 = p1.getName();
                String nameP2 = p2.getName();
                
                return nameP1.compareTo(nameP2);
            }
            
        }

        class TeamComparator implements Comparator<Team> {

            @Override
            public int compare(Team t1, Team t2) {
                
                String nameP1 = t1.getName();
                String nameP2 = t2.getName();
                
                return nameP1.compareTo(nameP2);
            }


        }
        //===========================================================================//
        
        final List<Player> homePlayers = teamId1.getPlayers(); //recupera os nomes dos jogadores
        
        PlayerComparator nameOrg = new PlayerComparator();
        TeamComparator teamOrg = new TeamComparator();

        homePlayers.sort(nameOrg); // <-- organiza o nome dos jogadores por ordem alfabética
        
        // System.out.println(
        //     "|====================| \n"
        //     + "Time: " + teamId1.getName() + "\n"
        //     + "\n Pontuação: " + teamId1.getPoints()
        //     + "\n Capitão: " + teamId1.getCaptain().getCaptain().getName() + "\n \n"
        //     + "Escalação: "
        // );

        // homePlayers.forEach(homePlayer -> System.out.println( "Nome: " + homePlayer.getName() + ", Nº: " + homePlayer.getNumber() )); // <-- retorna a lista dos nomes
        
        //-------------------------------------------------------------------------------------------------------------------------------//
    
        Player outplayer1 = new Player("Vinícius","03/05/2002",'M',1.95, 23);
        Player outplayer2 = new Player("Alberto","15/03/2002",'M',1.80, 30);
        Player outplayer3 = new Player("Lucas","20/08/2000",'M',1.68, 18);
        Player outplayer4 = new Player("Fernando","03/09/2001",'M',1.84, 51);
        Player outplayer5 = new Player("Diego","11/01/2002",'M',1.90, 01);
        Player outplayer6 = new Player("Daniel","14/05/2003",'M',1.72, 21);
        Player outplayer7 = new Player("Ricardo","17/08/2001",'M',1.83, 99);
        
        Captain teamCaptain2 = new Captain(homeplayer1); // <-- Estabelecendo capitão do Time visitante
        
        Stadium defaultStadium2 = new Stadium("Estádio Central", null); // <-- Estádio do time visitante
        
        Team teamId2 = new Team("FLASCO FC", teamCaptain2, defaultStadium2, 0); // <-- Criando o time visitante
        

        //===Introduzindo jogadores ao time====//
            teamId2.addPlayer(outplayer1);
            teamId2.addPlayer(outplayer2);
            teamId2.addPlayer(outplayer3);
            teamId2.addPlayer(outplayer4);
            teamId2.addPlayer(outplayer5);
            teamId2.addPlayer(outplayer6);
            teamId2.addPlayer(outplayer7);
        //=====================================//

        final List<Player> outPlayers = teamId2.getPlayers(); //recupera os nomes dos jogadores

        outPlayers.sort(nameOrg); // <-- organiza o nome dos jogadores por ordem alfabética

        // System.out.println(
        //     "|====================| \n"
        //     + "Time: " + teamId2.getName() + "\n"
        //     + "\n Pontuação: " + teamId2.getPoints()
        //     + "\n Capitão: " + teamId2.getCaptain().getCaptain().getName() + "\n \n"
        //     + "Escalação: "
        // );

        // outPlayers.forEach(outPlayer -> System.out.println( "Nome: " + outPlayer.getName() + ", Nº: " + outPlayer.getNumber() )); // <-- retorna a lista dos nomes


        
        //-------------------------------------------------------------------------------------------------------------------------------//

        Championship firstChamp = new Championship("Taça Palmas");
        
        Match firstMatch = new Match("10/11/2022", teamId1, teamId2);

        firstChamp.addMatch(firstMatch);
        
        // System.out.println(
        //     firstChamp.getName() + " começou! \n"
        //     + "O primeiro confronto será: " + firstChamp.getMatch(0).getHomeTeam().getName() + " x " + firstChamp.getMatch(0).getVisitorTeam().getName()
        //     + " \n Acontecerá em: " + firstChamp.getMatch(0).getDate()
        //     + " \n No " + firstChamp.getMatch(0).getStadium().getName()
        // );

    }
}
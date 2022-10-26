import java.util.List;

public class Main {

	public static void main(String[] args) {
		Player player = new Player("João","03/05/2002",'M',1.85);
		Player player2 = new Player("Eduardo","15/03/2002",'M',1.80);
		Captain captain = new Captain(player);
		Captain captain2 = new Captain(player2);
		Address address = new Address("704 sul",3,"77022-250","plano diretor sul");
		Stadium stadium = new Stadium("Niltom",address);
		Team teamHome = new Team("Flamengo",captain,stadium,20);
		Team teamVisitor = new Team("Palmas HC",captain2,null,1000);
		Match match = new Match("25/10/2022",teamHome,teamVisitor,stadium);
		
		System.out.println("O jogo acontecera no estadio "+ stadium.getName());
		System.out.println();
		System.out.println("A partida sera no dia "+ match.getDate());
		System.out.println("A partida do time "+ match.getHomeTeam().getName());
		System.out.println("Contra o time "+ match.getVisitorTeam().getName());

		System.out.println();
		System.out.println("Todos os Jogadores do Time da Casa:"+ teamHome.getName());
		teamHome.addPlayer(player);
		for(int i = 0; i < teamHome.getPlayers().size(); i++) {
			
			List<Player> players = teamHome.getPlayers();
			System.out.println("Jogador: "+ players.get(i).getName());
			
		}
		System.out.println("O capitão é:"+ teamHome.getCaptain().getCaptain().getName());

		System.out.println();
		System.out.println();
		System.out.println("Todos os Jogadores do Time Visitande:"+ teamVisitor.getName());
		teamVisitor.addPlayer(player2);
		for(int i = 0; i < teamVisitor.getPlayers().size(); i++) {
			
			List<Player> players = teamVisitor.getPlayers();
			System.out.println("Jogador: "+ players.get(i).getName());
		}
		System.out.println("O capitão é:"+ teamVisitor.getCaptain().getCaptain().getName());

		

		System.out.println();
		System.out.println();

		
	}

}

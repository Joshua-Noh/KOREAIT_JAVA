package gamelevel;

public class MainBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player = new Player();
		player.play(1);
		
		AdvancedLevel alevel = new AdvancedLevel();
		player.upgradeLevel(alevel);
		player.play(2);
		
		Superlevel sLevel = new Superlevel();
		player.upgradeLevel(sLevel);
		player.play(3);

	}

}

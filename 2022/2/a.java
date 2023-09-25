import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class A {
	public static void main(String[] args) {
		class GameItem {
			private char name;
			private char defeats;
			private char tiedWith;

			public GameItem(char name, char defeats, char tiedWith) {
				this.name = name;
				this.defeats = defeats;
				this.tiedWith = tiedWith;
			}

			public char getName() {
				return name;
			}

			public char getDefeats() {
				return defeats;
			}

			public char getTiedWith() {
				return tiedWith;
			}

		}

		Path path = Paths.get("2022/2/data.txt");
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(path, Charset.forName("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<GameItem> gameItems = new ArrayList<>();

		gameItems.add(new GameItem('X', 'C', 'A'));
		gameItems.add(new GameItem('Y', 'A', 'B'));
		gameItems.add(new GameItem('Z', 'B', 'C'));

		List<Character> names = new ArrayList<>();

		for (GameItem gameItem : gameItems) {
			names.add(gameItem.getName());
		}

		int score = 0;

		for (String line : lines) {
			char yourPick = line.charAt(2);
			int yourPickIndex = names.indexOf(yourPick);

			switch (yourPick) {
				case 'X':
					score += 1;
					break;
				case 'Y':
					score += 2;
					break;
				case 'Z':
					score += 3;
					break;
			}

			char opponentPick = line.charAt(0);
			if (gameItems.get(yourPickIndex).getDefeats() == opponentPick) {
				score += 6;
			} else if (gameItems.get(yourPickIndex).getTiedWith() == opponentPick) {
				score += 3;
			}
		}
		System.out.println(score);
	}
}

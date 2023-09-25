import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class B {
    public static void main(String[] args) {
        Path path = Paths.get("2022/2/data.txt");
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path, Charset.forName("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        int score = 0;

        for (String line : lines) {
            char yourOutcome = line.charAt(2);
            char opponentPick = line.charAt(0);

            switch (yourOutcome) {
                case 'X':
                    switch (opponentPick) {
                        case 'A':
                            score += 3;
                            break;
                        case 'B':
                            score += 1;
                            break;
                        case 'C':
                            score += 2;
                            break;
                    }
                    break;
                case 'Y':
                    score += 3;
                    switch (opponentPick) {
                        case 'A':
                            score += 1;
                            break;
                        case 'B':
                            score += 2;
                            break;
                        case 'C':
                            score += 3;
                            break;
                    }
                    break;
                case 'Z':
                    score += 6;
                    switch (opponentPick) {
                        case 'A':
                            score += 2;
                            break;
                        case 'B':
                            score += 3;
                            break;
                        case 'C':
                            score += 1;
                            break;
                    }
                    break;
            }
        }
        System.out.println(score);
    }
}

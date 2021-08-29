package ejercicio04;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Episode e1 = new Episode("The phantom menace", "Episode I", true, 59);
        Episode e2 = new Episode("Attack of the Clones", "Episode II", true, 56);
        Episode e3 = new Episode("Revenge of the Sith", "Episode III", true, 66);
        Episode e4 = new Episode("A new hope", "Episode IV", true, 96);
        Episode e5 = new Episode("The empire strikes back", "Episode V", true, 97);
        Episode e6 = new Episode("Return of the Jedi", "Episode VI", true, 94);
        Episode e7 = new Episode("The force awakens", "Episode VII", true, 85);
        Episode e8 = new Episode("The last Jedi", "Episode I", true, 42);
        Episode e9 = new Episode("The Rise of Skywalker", "Episode IX", true, 86);
        Season s1 = new Season(List.of(e1, e2, e3));
        Season s2 = new Season(List.of(e4, e5, e6));
        Season s3 = new Season(List.of(e7, e8, e9));
        Show starWars = new Show("Star Wars",
                "A dying group of space wizards fights for survival in a gritty futuristic war that looks suspiciously like the 1970’s, but is now mostly CG.",
                "George Lucas",
                "Science Fiction",
                List.of(s1, s2, s3));
        System.out.println("Rating:" + starWars.getAverageRating());
        System.out.println("Seen:" + starWars.getEpisodesSeen());
        System.out.println("Has seen all:" + starWars.hasSeenAll());
    }
}

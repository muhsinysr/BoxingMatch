import java.util.Random;

class Boxer {
    private String name;
    private int weight;
    private int age;
    private boolean isHealthy;
    private int score;

    public Boxer(String name, int weight, int age, boolean isHealthy) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.isHealthy = isHealthy;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public int getScore() {
        return score;
    }

    public void attack(Boxer opponent) {
        Random random = new Random();
        int attackPower = random.nextInt(10) + 1;
        System.out.println(this.name + " attacks " + opponent.getName() + " with power of " + attackPower);
        opponent.defend(attackPower);
    }

    public void defend(int attackPower) {
        Random random = new Random();
        int defendPower = random.nextInt(10) + 1;
        System.out.println(this.name + " defends with power of " + defendPower);
        if (attackPower > defendPower) {
            System.out.println(this.name + " takes damage");
            if (this.isHealthy) {
                this.isHealthy = false;
                System.out.println(this.name + " is injured");
            }
        }
    }

    public void increaseScore() {
        score++;
    }
}

class Referee {
    public void startMatch(Boxer boxer1, Boxer boxer2) {
        System.out.println("The boxing match has started!");
        int round = 1;
        while (boxer1.isHealthy() && boxer2.isHealthy() && round <= 10) {
            System.out.println("Round " + round + " starts:");
            if (round % 2 == 1) {
                boxer1.attack(boxer2);
                if (!boxer2.isHealthy()) {
                    System.out.println(boxer1.getName() + " wins round " + round);
                    boxer1.increaseScore();
                }
            } else {
                boxer2.attack(boxer1);
                if (!boxer1.isHealthy()) {
                    System.out.println(boxer2.getName() + " wins round " + round);
                    boxer2.increaseScore();
                }
            }
            round++;
        }
        System.out.println("The boxing match has ended!");
        if (boxer1.getScore() > boxer2.getScore()) {
            System.out.println(boxer1.getName() + " wins the match!");
        } else if (boxer2.getScore() > boxer1.getScore()) {
            System.out.println(boxer2.getName() + " wins the match!");
        } else {
            System.out.println("The match is a tie!");
        }
    }

    public void count(Boxer boxer) {
        System.out.println(boxer.getName() + " is down!");
    }

    public void endMatch(Boxer winner) {
        System.out.println(winner.getName() + " wins the boxing match!");
    }
}

public class BoxingMatchSimulator {
    public static void main(String[] args) {
        Boxer boxer1 = new Boxer("Mike Tyson", 220, 54, true);
        Boxer boxer2 = new Boxer("Evander Holyfield", 225, 59, true);
        Referee referee = new Referee();
        BoxingMatch match = new BoxingMatch(boxer1, boxer2, referee);
        match.startMatch();
    }
}

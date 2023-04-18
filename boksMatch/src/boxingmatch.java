import java.util.Random;

class BoxingMatch {
    private Boxer boxer1;
    private Boxer boxer2;
    private Referee referee;

    public BoxingMatch(Boxer boxer1, Boxer boxer2, Referee referee) {
        this.boxer1 = boxer1;
        this.boxer2 = boxer2;
        this.referee = referee;
    }

    public void startMatch() {
        Boxer firstBoxer = getFirstBoxer();
        Boxer secondBoxer = (firstBoxer == boxer1) ? boxer2 : boxer1;

        referee.startMatch(firstBoxer, secondBoxer);
    }

    private Boxer getFirstBoxer() {
        Random random = new Random();
        int randomNum = random.nextInt(2);
        return (randomNum == 0) ? boxer1 : boxer2;
    }
}


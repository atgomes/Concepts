public class Main {
    public static final Long MIN_VERSION = 3001L;

    public static void main(String[] args) {

        String file1 = "playing file 1";
        String file2 = "playing file 2";

        // PROBLEM: if Soundcard version above 3001 then play file 1. if not play file 2

        // Approach 1
        SoundCard soundCard1 = new SoundCard();
        Computer computer = new Computer(soundCard1);


        if (computer.getSoundCard().displayVersion() > MIN_VERSION) {
            computer.getSoundCard().playSound(file1);
        } else {
            computer.getSoundCard().playSound(file2);
        }

        // It makes sense for a computer to always have a playback device

        // Approach 2
        SoundCard soundCard2 = new SoundCard(100L);
        Computer computer2 = new Computer();
        computer2.addPlayer(soundCard2);

        if (computer2.hasAnyPlayer(MIN_VERSION)) {
            computer2.playSound(file1);
        } else {
            computer2.playSound(file2);
        }
        // Or
        if (computer2.getPlayerVersion() > MIN_VERSION) {
            computer2.playSound(file1);
        } else {
            computer2.playSound(file2);
        }
    }
}

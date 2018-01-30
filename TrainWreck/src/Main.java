public class Main {
    public static final Long MIN_VERSION = 3001L;

    public static void main(String[] args) {

        String file1 = "playing file 1";
        String file2 = "playing file 2";

        // PROBLEM: if Soundcard version is above 3001 then play file 1. if not play file 2
        // Assumption: It makes sense for a computer to always have a playback device

        // Approach 1: get sound card, get sound card version. ask sound card to play a file.
        SoundCard soundCard1 = new SoundCard();
        Computer computer = new Computer(soundCard1);

        if (computer.getSoundCard().displayVersion() > MIN_VERSION) {
            computer.getSoundCard().playSound(file1);
        } else {
            computer.getSoundCard().playSound(file2);
        }

        // Approach 2: ask the computer if it has any player above version MIN_VERSION. ask the computer to play a file.
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

        // Assumption: a computer might not always have a playback device

        // Approach 1: get sound card, get sound card version and try to play file
        Computer computer3 = new Computer();
        if (computer3.getSoundCard() != null) {
             if (computer3.getSoundCard().displayVersion() > MIN_VERSION) {
                 computer3.getSoundCard().playSound(file1);
             } else {
                 computer3.getSoundCard().playSound(file2);
             }
        } else {
            System.out.println("No playback devices available");
        }

        // Approach 2: ask computer if it can play a file and play it.
        Computer computer4 = new Computer();
        if (computer4.hasAnyPlayer(MIN_VERSION)) {
            computer4.playSound(file1);
        } else {
            computer4.playSound(file2);
        }
        // =======================================================================================================
        // Even better: the playback device should know if it can play a file or not and the computer should manage the
        // playback devices
        SoundFile recentFile = new SoundFile();
        recentFile.version = 4000L;
        recentFile.content = "Some recent youtube viral song.";
        SoundFile oldFile = new SoundFile();
        oldFile.version = 50L;
        oldFile.content = "A classic hit.";

        SoundCard smartSoundCard = new SoundCard(100L);
        SoundCard smartSoundCard2 = new SoundCard(9800L);
        Computer smartComputer = new Computer();
        smartComputer.addPlayer(smartSoundCard);
        smartComputer.addPlayer(smartSoundCard2);

        System.out.println("Trying to play a recent file. Only the smartSoundCard2 will play it");
        smartComputer.playSound(recentFile);

        System.out.println("Trying to play an old file. Both sound cards would play it but only one will.");
        smartComputer.playSound(oldFile);

        // With this we understand that when many "train wrecks" appear in our code it's probably because our system
        // is poorly designed from the start.
    }
}

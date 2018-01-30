public interface Player extends Hardware {
    void playSound(String file);

    void playSound(SoundFile soundFile) throws Exception;
}

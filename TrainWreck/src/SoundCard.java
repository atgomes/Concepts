public class SoundCard implements Player, Recorder {

    private Long version = 9800L;


    public SoundCard() {
    }

    public SoundCard(Long version) {
        this.version = version;
    }

    @Override
    public Long displayVersion() {
        return this.version;
    }

    @Override
    public void playSound(String file) {
        System.out.println(file);
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void record() {
        System.out.println("SoundCard is recording...");
    }
}

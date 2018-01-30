public class SoundCard implements Player, Recorder {

    private Long version = 9800L;

    private boolean enabled = true;


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
    public void playSound(SoundFile soundFile) throws Exception {
        if (this.version > soundFile.version) {
            System.out.println("soundcard v" + this.version + " plays: " + soundFile.content);
        }
        else {
            throw new Exception("Can't play file.");
        }

    }

    @Override
    public void enable() {
        this.enabled = true;
    }

    @Override
    public void disable() {
        this.enabled = false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void record() {
        System.out.println("SoundCard is recording...");
    }
}

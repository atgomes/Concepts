import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

public class Computer implements Player, Recorder {

    private Long version = 2056L;

    Collection<Player> playerComponents;

    Collection<Recorder> recorderComponents;

    // #1
    private SoundCard soundCard;

    private boolean enabled = true;

    public Computer() {
        playerComponents = new ArrayList<>();
        recorderComponents = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        playerComponents.add(player);
    }

    public void addRecorder(Recorder recorder) {
        recorderComponents.add(recorder);
    }

    // #1
    public Computer(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public SoundCard getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    @Override
    public Long displayVersion() {
        return this.version;
    }

    public Long getPlayerVersion() {
        for (Player p : playerComponents) {
            if (p.isEnabled()) {
                return p.displayVersion();
            }
        }
        return -1L;
    }

    public boolean hasAnyPlayer(Long minVersion) {
        for (Player p : playerComponents) {
            if (p.isEnabled() && p.displayVersion() > minVersion) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void playSound(String file) {
        for (Player p : playerComponents) {
            if (p.isEnabled()) {
                p.playSound(file);
                return;
            }
        }
        System.out.println("No playback devices available");
    }

    @Override
    public void playSound(SoundFile soundFile) {
        for (Player p : playerComponents) {
            if (p.isEnabled()) {
                try {
                    p.playSound(soundFile);
                    return;
                } catch (Exception ex) {
                    Logger.getAnonymousLogger().warning(ex.getMessage());
                }
            }
        }
        System.out.println("No capable playback devices available");
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
        for (Recorder p : recorderComponents) {
            if (p.isEnabled()) {
                p.record();
                return;
            }
        }
    }
}

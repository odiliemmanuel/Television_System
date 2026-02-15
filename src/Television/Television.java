package Television;

public class Television {

    private boolean isOn;
    private int volume;

    public void turnOff() {
       isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public boolean tvIsOn() {
        return this.isOn;
    }

    public void increaseVolume() {
        if(isOn) {
            volume++;
        }
        else{
            this.volume = 0;
        }
    }

    public int getVolumeLevel() {
        return this.volume;
    }
}

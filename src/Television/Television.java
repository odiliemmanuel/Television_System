package Television;

public class Television {

    private boolean isOn;
    private int volume;
    private int channel = 1;

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
        if(isOn && volume < 100) {
            volume++;
        }

    }

    public int getVolumeLevel() {
        return this.volume;
    }

    public void decreaseVolume() {
        if(isOn && volume > 0){
            volume --;
        }

    }

    public void increaseChannel() {
        if(isOn && channel < 300) {
            channel++;
        }
    }

    public int getCurrentChannel() {
        return this.channel;
    }

    public void decreaseChannel() {
        if(isOn && channel > 1){
            channel --;
        }

    }

    public void setChannel(int input) {
        if(isOn && input < 300 && input > 1) {
            this.channel = input;

        }

    }
}

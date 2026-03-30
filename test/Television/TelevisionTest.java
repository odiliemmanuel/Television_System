package Television;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TelevisionTest {
    Television television;

    @BeforeEach
    public void startEachMethodWith(){
        television = new Television();
    }

    @Test
    public void testThatICanPutOffTv(){
        television. turnOff();

        boolean actual = television.tvIsOn();
        boolean expected = false;
        assertEquals(actual, expected);

    }

    @Test
    public void testThatICanPutOnTv(){

        television.turnOn();
        boolean actual = true;
        boolean expected = television.tvIsOn();
        assertEquals(actual, expected);

    }

    @Test
    public void testThatICanIncreaseVolume() {
        television.turnOff();
        assertFalse(television.tvIsOn());

        television.turnOn();

        television.increaseVolume();
        int actual = 1;
        int expected = television.getVolumeLevel();
        assertEquals(actual, expected);

    }

    @Test
    public void testThatICanIncreaseVolumeOnlyWhenTvIsOn(){
        television.turnOff();
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());

        television.increaseVolume();
        television.increaseVolume();
        television.increaseVolume();

        int actual = 3;
        int expected = television.getVolumeLevel();
        assertEquals(actual, expected);
    }

    @Test
    public void testThatWhileIncreasingVolume_ItDoesntExceed_100(){
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());

        for(int count = 1; count <= 201; count ++) {
            television.increaseVolume();
        }
        assertEquals(100, television.getVolumeLevel());
    }

    @Test
    public void testThatIfTvIsOffAndI_IncreaseVolume_VolumeStillRemainsAtItsInitialState_0(){
        television.turnOff();
        assertFalse(television.tvIsOn());

        television.increaseVolume();
        television.increaseVolume();
        television.increaseVolume();

        assertEquals(0, television.getVolumeLevel());
    }

    @Test
    public void testThatICanDecreaseVolume() {
        television.turnOff();
        assertFalse(television.tvIsOn());

        television.turnOn();
        television.increaseVolume();
        television.increaseVolume();
        assertEquals(2, television.getVolumeLevel());

        television.decreaseVolume();
        assertEquals(1, television.getVolumeLevel());


    }

    @Test
    public void testThatICanDecreaseVolumeOnlyWhenTvIsOn(){
        television.turnOff();
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());

        television.increaseVolume();
        television.increaseVolume();
        television.increaseVolume();
        assertEquals(3, television.getVolumeLevel());

        television.decreaseVolume();
        television.decreaseVolume();
        assertEquals(1, television.getVolumeLevel());

    }

    @Test
    public void testThatIfTvIsOffAndI_DecreaseVolume_VolumeStillRemainsAtItsInitialState_0(){
        television.turnOff();
        assertFalse(television.tvIsOn());

        television.increaseVolume();
        television.increaseVolume();
        television.increaseVolume();
        assertEquals(0, television.getVolumeLevel());

        television.decreaseVolume();
        assertEquals(0, television.getVolumeLevel());

    }

    @Test
    public void testThatWhileDecreasingVolume_ItDoesntGoBeyond_0(){
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());

        for(int count = 1; count <= 201; count ++) {
            television.increaseVolume();
        }
        assertEquals(100, television.getVolumeLevel());

        for(int count = 1; count <= 201; count ++) {
            television.decreaseVolume();
        }
        assertEquals(0, television.getVolumeLevel());
    }


    @Test
    public void testThatICanIncreaseChannel(){
        television.turnOn();
        assertTrue(television.tvIsOn());

        television.increaseChannel();
        television.increaseChannel();
        television.increaseChannel();
        assertEquals(4, television.getCurrentChannel());
    }

    @Test
    public void testThatICanOnlyIncreaseChannelWhenTvIsOn(){
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());

        television.increaseChannel();
        television.increaseChannel();
        television.increaseChannel();
        assertEquals(4, television.getCurrentChannel());

    }

    @Test
    public void testThatIfI_IncreaseChannelWhenTvIsOf_ChannelRemains_1(){
        assertFalse(television.tvIsOn());

        television.increaseChannel();
        television.increaseChannel();
        television.increaseChannel();
        assertEquals(1, television.getCurrentChannel());

    }

    @Test
    public void testThatWhileChannelCanBeIncreased_ItDoesntExceed_300(){
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());
        for(int count = 1; count <= 301; count ++) {
            television.increaseChannel();
        }

        assertEquals(300, television.getCurrentChannel());
    }

    @Test
    public void testThatICanDecreaseChannel(){
        television.turnOn();
        assertTrue(television.tvIsOn());

        for(int count = 1; count <= 4; count ++) {
            television.increaseChannel();
        }

        television.decreaseChannel();
        assertEquals(4, television.getCurrentChannel());
    }

    @Test
    public void testThatICanOnlyDecreaseChannelWhenTvIsOn(){
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());

        for(int count = 1; count <= 56; count ++) {
            television.increaseChannel();
        }

        for(int count = 1; count <= 20; count ++) {
            television.decreaseChannel();
        }
        assertEquals(37, television.getCurrentChannel());

    }

    @Test
    public void testThatIfI_DecreaseChannelWhenTvIsOf_ChannelRemains_1(){
        assertFalse(television.tvIsOn());

        for(int count = 1; count <= 301; count ++) {
            television.increaseChannel();
        }

        for(int count = 1; count <= 30; count ++) {
            television.decreaseChannel();
        }
        assertEquals(1, television.getCurrentChannel());

    }

    @Test
    public void testThatWhileChannelCanBeDecreased_ItDoesntGoBeyond_1(){
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());

        for(int count = 1; count <= 301; count ++) {
            television.increaseChannel();
        }

        for(int count = 1; count <= 301; count ++) {
            television.decreaseChannel();
        }

        assertEquals(1, television.getCurrentChannel());
    }

    @Test
    public void testThatICanSetChannel(){
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());

        television.setChannel(23);
        assertEquals(23, television.getCurrentChannel());
    }

    @Test
    public void testThatICanOnlySetChannelWhenTvIsOn(){
        assertFalse(television.tvIsOn());

        television.setChannel(23);
        assertEquals(1, television.getCurrentChannel());
    }

    @Test
    public void testThatICanOnlySetChannelWithinTheRangeOf_1_To_300(){
        assertFalse(television.tvIsOn());

        television.turnOn();
        assertTrue(television.tvIsOn());

        television.setChannel(0);
        assertEquals(1, television.getCurrentChannel());

        television.setChannel(301);
        assertEquals(1, television.getCurrentChannel());

    }

}





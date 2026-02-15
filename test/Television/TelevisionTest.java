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
    public void testThatIfAcIsOffAndI_IncreaseVolume_VolumeStillRemainsAtItsInitialState_0(){
        television.turnOff();
        assertFalse(television.tvIsOn());

        television.increaseVolume();
        television.increaseVolume();
        television.increaseVolume();

        int actual = 0;
        int expected = television.getVolumeLevel();
        assertEquals(actual, expected);
    }

}










































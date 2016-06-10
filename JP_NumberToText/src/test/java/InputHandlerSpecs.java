import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by matthewb on 6/9/16.
 */
public class InputHandlerSpecs {

    InputHandler inputHandler;

    @Before
    public void init(){
        inputHandler = new InputHandler();
    }

    @Test
    public void convertStringToStringWithCommasTest(){

        String before = "1234";
        String after = inputHandler.convertStringToStringWithCommas(before);

        String before1 = "10000";
        String after1 = inputHandler.convertStringToStringWithCommas(before1);

        String before2 = "9999999";
        String after2 = inputHandler.convertStringToStringWithCommas(before2);

        String before3 = "abc";
        String after3 = inputHandler.convertStringToStringWithCommas(before3);

        assertEquals("Should have commas separating the groups","1,234",after);
        assertEquals("Should have commas separating the groups","10,000",after1);
        assertEquals("Should have commas separating the groups","9,999,999",after2);
        assertEquals("Should have commas separating the groups","0",after3);

    }

    @Test
    public void splitTextOnCommasTest(){

        String[] expected = {"1","123"};
        String[] actual = inputHandler.splitTextOnCommas("1,123");

        String[] expected1 = {"1","123","000"};
        String[] actual1 = inputHandler.splitTextOnCommas("1,123,000");

        assertEquals("Should be split on the commas",expected,actual);
        assertEquals("Should be split on the commas",expected1,actual1);


    }
}

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by matthewb on 6/9/16.
 */
public class LogicControllerSpecs {

    LogicController logicController;

    @Before
    public void init(){
        logicController = new LogicController();
    }

    @Test
    public void countNumberOfGroupsTest(){

        String[] input = {"123","123","123"};
        int expected = 3;
        int actual = logicController.countNumberOfGroups(input);
        assertEquals("Should be 3 groups counted",expected,actual);
    }

    @Test
    public void placeSuffixTest(){

        int numberOfGroups = 0;
        int numberOfGroups1 = 2;
        int numberOfGroups2 = 3;
        int numberOfGroupsDefault = 5;


        String expected = "";
        String expected1 = "Thousand";
        String expected2 = "Million";
        String expected3 = "Hundred";


        String actual = logicController.placeSuffix(numberOfGroups);
        String actual1 = logicController.placeSuffix(numberOfGroups1);
        String actual2 = logicController.placeSuffix(numberOfGroups2);
        String actual3 = logicController.placeSuffix(numberOfGroupsDefault);


        assertEquals("Should be 0 groups - '' ",expected,actual);
        assertEquals("Should be 1 groups - Thousand ",expected1,actual1);
        assertEquals("Should be 2 groups - Million ",expected2,actual2);
        assertEquals("Should be default - Hundred ",expected3,actual3);

    }

    @Test
    public void isBetweenTenAndNineteenTest(){

        String input = "123";
        String input1 = "12";
        String input2 = "117";
        String input3 = "abc";


        assertFalse(logicController.isBetweenTenAndNineteen(input));
        assertTrue(logicController.isBetweenTenAndNineteen(input1));
        assertTrue(logicController.isBetweenTenAndNineteen(input2));
        assertFalse(logicController.isBetweenTenAndNineteen(input3));

    }

    @Test
    public void convertTenToNineteenTest(){

        String input = "15";
        String input1 = "22";
        String input2 = "113";
        String input3 = "abc";

        String expected = "Fifteen";
        String expected1 = "";
        String expected2 = "Thirteen";
        String expected3 = "";

        String actual = logicController.convertTenToNineteen(input);
        String actual1 = logicController.convertTenToNineteen(input1);
        String actual2 = logicController.convertTenToNineteen(input2);
        String actual3 = logicController.convertTenToNineteen(input3);

        assertEquals("Should be Fifteen",expected,actual);
        assertEquals("Should be '' ",expected1,actual1);
        assertEquals("Should be Thirteen",expected2,actual2);
        assertEquals("Should be '' ",expected3,actual3);

    }

    @Test
    public void convertStringToTextDollarsTest(){


        String[] input = {"12","123"};
        String expected = "TwelveThousandOneHundredTwentyThreeDollars";

        String[] input1 = {"24","123"};
        String expected1 = "TwentyFourThousandOneHundredTwentyThreeDollars";

        String actual = logicController.convertStringToTextDollars(input);
        String actual1 = logicController.convertStringToTextDollars(input1);


        assertEquals("Should have converted to textDollars",expected,actual);
        assertEquals("Should have converted to textDollars",expected1,actual1);

    }

    @Test
    public void blockLengthThreeConverterTest(){

        String input = "123";
        String input1 = "417";
        String input2 = "100";

        String expected = "OneHundredTwentyThree";
        String expected1 = "FourHundredSeventeen";
        String expected2 = "OneHundred";


        String actual = logicController.blockLengthThreeConverter(input);
        String actual1 = logicController.blockLengthThreeConverter(input1);
        String actual2 = logicController.blockLengthThreeConverter(input2);


        assertEquals("Should convert to text",expected,actual);
        assertEquals("Should convert to text",expected1,actual1);
        assertEquals("Should convert to text",expected2,actual2);


    }

    @Test
    public void blockLengthTwoConverterTest(){

        String input = "12";
        String input1 = "41";

        String expected = "Twelve";
        String expected1 = "FortyOne";

        String actual = logicController.blockLengthTwoConverter(input);
        String actual1 = logicController.blockLengthTwoConverter(input1);

        assertEquals("Should convert to text",expected,actual);
        assertEquals("Should convert to text",expected1,actual1);

    }


}

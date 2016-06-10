import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by matthewb on 6/9/16.
 */
public class InputHandler {

    LogicController logicController = new LogicController();


    public String convertStringToStringWithCommas(String input){
        input = input.replaceAll("[//D]","");
        int tempVal = 0;
        try{
         tempVal = Integer.parseInt(input);
            }catch (IllegalArgumentException e){
            //Error Handling / Stacktrace
        }
        input = NumberFormat.getInstance().format(tempVal);
        return input;
    }

    public String[] splitTextOnCommas(String input){
        return input.split(",");
    }

    public void runInputHandler(){
        System.out.println("Type Number to Convert: ");
        Scanner textInput = new Scanner(System.in);
        String response = textInput.nextLine();

        response = convertStringToStringWithCommas(response);
        System.out.println(logicController.convertStringToTextDollars(splitTextOnCommas(response)));

    }



}

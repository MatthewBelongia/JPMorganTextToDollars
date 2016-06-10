/**
 * Created by matthewb on 6/9/16.
 */
public class LogicController {

    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String result = "";
    String hundred = "Hundred";
    String thousand = "Thousand";
    String million = "Million";
    int numberOfGroups = 0;

    public int countNumberOfGroups(String[] input) {
        int groups = 0;
        for (String numBlock : input) {
            groups++;
        }
        return groups;
    }

    public String placeSuffix(int numberOfGroups) {
        switch (numberOfGroups) {
            case 0:
            case 1:
                return "";
            case 2:
                return thousand;
            case 3:
                return million;
            default:
                return hundred;
        }
    }

    public Boolean isBetweenTenAndNineteen(String input) {
        Boolean isBetween = false;
        if (input.length() == 3) {
            if (input.charAt(1) == '1') {
                isBetween = true;
            }
        } else if (input.length() == 2) {
            if (input.charAt(0) == '1') {
                isBetween = true;
            }
        }
        return isBetween;
    }

    public String convertTenToNineteen(String input) {
        String result = "";
        if (input.length() == 3) {
            if (input.charAt(1) == '1') {
                result = teens[Character.getNumericValue(input.charAt(2))];
            }
        } else if (input.length() == 2) {
            if (input.charAt(0) == '1') {
                result = teens[Character.getNumericValue(input.charAt(1))];
            }
        }
        return result;
    }

    public String convertStringToTextDollars(String[] input) {
        String convertedResult = "";
        numberOfGroups = countNumberOfGroups(input);

        for (String numBlock : input) {

            if (numBlock.length() == 3) {
                convertedResult += ones[Character.getNumericValue(numBlock.charAt(0))];
                convertedResult += placeSuffix(-1);
                if (isBetweenTenAndNineteen(numBlock.substring(1))) {
                    convertedResult += convertTenToNineteen(numBlock.substring(1));
                } else {
                    convertedResult += tens[Character.getNumericValue(numBlock.charAt(1))] +
                            ones[Character.getNumericValue(numBlock.charAt(2))];
                }
                convertedResult += placeSuffix(numberOfGroups);
                numberOfGroups--;
            }
            else if(numBlock.length() ==2){
                if (isBetweenTenAndNineteen(numBlock)) {
                    convertedResult += convertTenToNineteen(numBlock);
                } else {
                    convertedResult += tens[Character.getNumericValue(numBlock.charAt(0))] +
                            ones[Character.getNumericValue(numBlock.charAt(1))];
                }
                convertedResult+= placeSuffix(numberOfGroups);
                numberOfGroups--;
            }
            else {
                convertedResult+= ones[Character.getNumericValue(numBlock.charAt(0))];
                convertedResult+= placeSuffix(numberOfGroups);
                numberOfGroups--;
            }


        }
        if(convertedResult.equals("One")){
            return convertedResult + "Dollar";
        }
        else if(convertedResult.equals("")){
            return "ZeroDollars";
        }
        return convertedResult + "Dollars";
    }
}

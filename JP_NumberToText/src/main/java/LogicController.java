/**
 * Created by matthewb on 6/9/16.
 */
public class LogicController {

    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String result = "";
    String[] suffixs = {"", "", "Thousand", "Million", "Billion", "Hundred"};
    int numberOfGroups = 0;

    public int countNumberOfGroups(String[] input) {
        int groups = 0;
        for (String numBlock : input) {
            groups++;
        }
        return groups;
    }

    public String placeSuffix(int numberOfGroups) {
        try {
            return suffixs[numberOfGroups];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Boolean isBetweenTenAndNineteen(String input) {
        Boolean isBetween = false;

        if (input.length() == 3 && input.charAt(1) == '1') {
            isBetween = true;
        } else if (input.length() == 2 && input.charAt(0) == '1') {
            isBetween = true;
        }
        return isBetween;
    }

    public String convertTenToNineteen(String input) {
        String result = "";
        if (input.length() == 3 && input.charAt(1) == '1') {
            result = teens[Character.getNumericValue(input.charAt(2))];
        } else if (input.length() == 2 && input.charAt(0) == '1') {
            result = teens[Character.getNumericValue(input.charAt(1))];
        }
        return result;
    }

    public String blockLengthThreeConverter(String input) {
        String response = "";
        response += ones[Character.getNumericValue(input.charAt(0))];
        response += placeSuffix(5);
        if (isBetweenTenAndNineteen(input.substring(1))) {
            response += convertTenToNineteen(input.substring(1));
        } else {
            response += tens[Character.getNumericValue(input.charAt(1))] +
                    ones[Character.getNumericValue(input.charAt(2))];
        }
        return response;

    }

    public String blockLengthTwoConverter(String input) {
        String response = "";
        if (isBetweenTenAndNineteen(input)) {
            response += convertTenToNineteen(input);
        } else {
            response += tens[Character.getNumericValue(input.charAt(0))] +
                    ones[Character.getNumericValue(input.charAt(1))];
        }
        return response;
    }

    public Boolean isAllZeros(String input) {
        Boolean result = false;
        if (input.equals("000")) {
            result = true;
        }
        return result;
    }

    public String convertStringToTextDollars(String[] input) {
        String convertedResult = "";
        numberOfGroups = countNumberOfGroups(input);

        for (String numBlock : input) {

            if (isAllZeros(numBlock)) {
                numberOfGroups--;
                continue;
            }

            
            if (numBlock.length() == 3) {
                convertedResult += blockLengthThreeConverter(numBlock);
                convertedResult += placeSuffix(numberOfGroups);
                numberOfGroups--;
            } else if (numBlock.length() == 2) {
                convertedResult += blockLengthTwoConverter(numBlock);
                convertedResult += placeSuffix(numberOfGroups);
                numberOfGroups--;
            } else {
                convertedResult += ones[Character.getNumericValue(numBlock.charAt(0))];
                convertedResult += placeSuffix(numberOfGroups);
                numberOfGroups--;
            }


        }
        if (convertedResult.equals("One")) {
            return convertedResult + "Dollar";
        } else if (convertedResult.equals("")) {
            return "ZeroDollars";
        }
        return convertedResult + "Dollars";
    }
}

import java.util.*;

class LetterCombinationPhone {

    private static final String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current,
                           String digits, int index) {

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = keypad[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);           
            backtrack(result, current, digits, index + 1); 
            current.deleteCharAt(current.length() - 1); 
        }
    }
}

import java.util.*;

public class Deepika {
    private static Map<String, Integer> parseInput(String[] lines) {
        Map<String, Integer> digitMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(lines[j].substring(i * 3, (i + 1) * 3));
            }
            digitMap.put(sb.toString(), i);
        }

        return digitMap;
    }
    private static Set<String> toggleOneBit(String matrix) {
        Set<String> toggled = new HashSet<>();
        char[] chars = matrix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (chars[i] == '0') ? '1' : '0';
            toggled.add(new String(chars));
            chars[i] = (chars[i] == '0') ? '1' : '0';
        }
        return toggled;
    }
    private static List<List<Integer>> findValidNumbers(Map<String, Integer> digitMap, String[] inputDigits) {
        Map<String, Set<String>> allToggled = new HashMap<>();
        for (String ref : digitMap.keySet()) {
            allToggled.put(ref, toggleOneBit(ref));
        }

        List<List<Integer>> possibleNumbers = new ArrayList<>();
        for (String input : inputDigits) {
            List<Integer> validDigits = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : digitMap.entrySet()) {
                String ref = entry.getKey();
                if (input.equals(ref) || allToggled.get(ref).contains(input)) {
                    validDigits.add(entry.getValue());
                }
            }
            if (validDigits.isEmpty()) {
                return null;
            }
            possibleNumbers.add(validDigits);
        }

        return possibleNumbers;
    }
    private static int calculateSum(List<List<Integer>> possibleNumbers) {
        int totalSum = 0;
        calculateSumRecursive(possibleNumbers, 0, 0, totalSum);
        return totalSum;
    }
    private static void calculateSumRecursive(List<List<Integer>> possibleNumbers, int index, int currentNumber, int totalSum) {
        if (index == possibleNumbers.size()) {
            totalSum += currentNumber;
            return;
        }
        for (int digit : possibleNumbers.get(index)) {
            calculateSumRecursive(possibleNumbers, index + 1, currentNumber * 10 + digit, totalSum);
        }
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] lines = new String[6];
            for (int i = 0; i < 6; i++) {
                lines[i] = scanner.nextLine();
            }
            Map<String, Integer> digitMap = parseInput(lines);
            String[] inputDigits = new String[lines[3].length() / 3];
            for (int i = 0; i < inputDigits.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 3; j < 6; j++) {
                    sb.append(lines[j].substring(i * 3, (i + 1) * 3));
                }
                inputDigits[i] = sb.toString();
            }
            
            List<List<Integer>> possibleNumbers = findValidNumbers(digitMap, inputDigits);
            if (possibleNumbers == null) {
                System.out.println("Invalid");
            } else {
                int result = calculateSum(possibleNumbers);
                System.out.println(result);
            }
        }
    }
}
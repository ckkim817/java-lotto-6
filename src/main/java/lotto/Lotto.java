package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.global.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.lottoNumbersWithInteger(numbers);
    }

    // TODO: 추가 기능 구현
    public void printNumbers() {
        String numbersStr = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("[" + numbersStr + "]");
    }

    public int compareWinningNumbers(List<Integer> winningNumbers) {
        int matchedCount = 0;

        for (int winningNumber : winningNumbers) {
            if (compareNumber(winningNumber)) {
                matchedCount++;
            }
        }

        return matchedCount;
    }

    public boolean compareNumber(int winningNumber) {
        for (int number : this.numbers) {
            if (number == winningNumber) {
                return true;
            }
        }

        return false;
    }
}

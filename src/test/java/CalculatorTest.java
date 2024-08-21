import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource(value = {
            "'', 0",
            "'1,2', 3",
            "'1,2,3', 6",
            "'1,2:3', 6"
    }, delimiter = ',')
    @DisplayName("기본 구분자(쉼표, 콜론)를 사 용하여 숫자의 합을 계산")
    void addShouldReturnSumOfNumbersSeparatedByCommaOrColon(String input, int expected) {
        int result = calculator.add(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'//;\n1;2;3;', 6"
    }, delimiter = ',')
    @DisplayName("커스텀 구분자를 사용하여 숫자의 합을 계산")
    void addShouldReturnSumOfNumbersSeparatedByCustomDelimiter(String input, int expected) {
        int result = calculator.add(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'-1,2,3'",
            "'a,2,3'",
            "'1,2,b'"
    })
    @DisplayName("음수값, 숫자가 아닌 값일 경우 RunTimeException 예외 throw")
    void addShouldThrowRuntimeExceptionForNegativeOrInvalidNumbers(String input){
        assertThatThrownBy(() -> {
            calculator.add(input);
        }).isInstanceOf(RuntimeException.class);
    }
}
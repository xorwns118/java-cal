package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.\n" +
            "\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void split() {
        String str = "1,2";
        String[] result = str.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환\n" +
            "하도록 구현한다.")
    public void remove() {
        String str = "(1,2)";
        String result = str.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습\n" +
            "테스트를 구현한다.")
    public void getChar() {
        String str = "abc";
        char result = str.charAt(1);
        assertThat(result).isEqualTo('b');

    }

    @Test
    @DisplayName("String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면\n" +
            "StringIndexOutOfBoundsException 이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    public void getWrongChar() {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
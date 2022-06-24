import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonTest {

    private static Person person;

    @BeforeAll
    public static void setup() {
        person = new Person();
    }

    @ParameterizedTest(name = "O user {0} é válido?")
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String user) {
        person.setUser(user);
        Assertions.assertTrue(person.checkUser());
    }

    @ParameterizedTest(name = "O user {0} é inválido?")
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String user) {
        person.setUser(user);
        Assertions.assertFalse(person.checkUser());
    }

    @ParameterizedTest(name = "O password {0} é inválido?")
    @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest(name = "O password {0} é inválido?")
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest(name = "O password {0} é inválido?")
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(String password) {
        person.setPassword(password);
        Assertions.assertFalse(person.checkPassword());
    }

    @ParameterizedTest(name = "O password {0} é válido?")
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String password) {
        person.setPassword(password);
        Assertions.assertTrue(person.checkPassword());
    }

}
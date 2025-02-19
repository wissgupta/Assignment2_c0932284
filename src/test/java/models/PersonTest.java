package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testValidPersonCreation() {
        Person person = Person.builder()
                .id("P001")
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build();
        assertNotNull(person);
    }

    @Test
    void testPersonCreationWithNullIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Person.builder().id(null).firstName("John").lastName("Doe").age(30).gender("Male").build()
        );
        assertEquals("ID cannot be null", exception.getMessage());
    }
}

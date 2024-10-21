package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedPerson.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;

public class JsonAdaptedPersonTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_ROLE = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final List<JsonAdaptedEvent> VALID_EVENTS = BENSON.getEvents().stream()
            .map(JsonAdaptedEvent::new)
            .toList();
    private static final List<JsonAdaptedRole> VALID_ROLES = BENSON.getRoles().stream()
            .map(JsonAdaptedRole::new)
            .toList();

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        Map<JsonAdaptedEvent, Set<JsonAdaptedRole>> eventRoles = new HashMap<>();
        for (JsonAdaptedEvent event : VALID_EVENTS) {
            eventRoles.put(event, new HashSet<>(VALID_ROLES));
        }
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(INVALID_NAME, VALID_PHONE, VALID_EMAIL, eventRoles);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        Map<JsonAdaptedEvent, Set<JsonAdaptedRole>> eventRoles = new HashMap<>();
        for (JsonAdaptedEvent event : VALID_EVENTS) {
            eventRoles.put(event, new HashSet<>(VALID_ROLES));
        }
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(null, VALID_PHONE, VALID_EMAIL, eventRoles);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        Map<JsonAdaptedEvent, Set<JsonAdaptedRole>> eventRoles = new HashMap<>();
        for (JsonAdaptedEvent event : VALID_EVENTS) {
            eventRoles.put(event, new HashSet<>(VALID_ROLES));
        }
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, INVALID_PHONE, VALID_EMAIL, eventRoles);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        Map<JsonAdaptedEvent, Set<JsonAdaptedRole>> eventRoles = new HashMap<>();
        for (JsonAdaptedEvent event : VALID_EVENTS) {
            eventRoles.put(event, new HashSet<>(VALID_ROLES));
        }
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, null, VALID_EMAIL, eventRoles);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        Map<JsonAdaptedEvent, Set<JsonAdaptedRole>> eventRoles = new HashMap<>();
        for (JsonAdaptedEvent event : VALID_EVENTS) {
            eventRoles.put(event, new HashSet<>(VALID_ROLES));
        }
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, INVALID_EMAIL, eventRoles);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        Map<JsonAdaptedEvent, Set<JsonAdaptedRole>> eventRoles = new HashMap<>();
        for (JsonAdaptedEvent event : VALID_EVENTS) {
            eventRoles.put(event, new HashSet<>(VALID_ROLES));
        }
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, null, eventRoles);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidRoles_throwsIllegalValueException() {
        Map<JsonAdaptedEvent, Set<JsonAdaptedRole>> eventRoles = new HashMap<>();
        for (JsonAdaptedEvent event : VALID_EVENTS) {
            Set<JsonAdaptedRole> roles = new HashSet<>(VALID_ROLES);
            roles.add(new JsonAdaptedRole(INVALID_ROLE));
            eventRoles.put(event, roles);
        }
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, eventRoles);
        assertThrows(IllegalValueException.class, person::toModelType);
    }

}

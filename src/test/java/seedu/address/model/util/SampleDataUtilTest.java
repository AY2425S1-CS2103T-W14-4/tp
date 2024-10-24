package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventName;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.role.Role;

public class SampleDataUtilTest {
    @Test
    void getSamplePersons_returnsNonEmptyArray() {
        assertTrue(SampleDataUtil.getSamplePersons().length > 0);
    }

    @Test
    void getSamplePersons_containsExpectedPerson() {
        Map<Event, Set<Role>> eventRoles = new HashMap<>();
        eventRoles.put(new Event(new EventName("IFG")),
                SampleDataUtil.getRoleSet("Athlete - COM - Volleyball Women, Tennis"));
        Person[] samplePersons = SampleDataUtil.getSamplePersons();
        Person expectedPerson = new Person(new Name("Alex Yeoh"), new Phone("87438807"),
                new Email("alexyeoh@example.com"), eventRoles);
        assertTrue(Arrays.asList(samplePersons).contains(expectedPerson));
    }

    @Test
    void getSampleAddressBook_containsSamplePersons() {
        ReadOnlyAddressBook sampleAddressBook = SampleDataUtil.getSampleAddressBook();
        Person[] samplePersons = SampleDataUtil.getSamplePersons();
        for (Person samplePerson : samplePersons) {
            assertTrue(sampleAddressBook.getPersonList().contains(samplePerson));
        }
    }
}

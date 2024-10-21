package seedu.address.model.util;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.event.Event;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.role.Role;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        Map<Event, Set<Role>> eventRoles1 = new HashMap<>();
        eventRoles1.put(new Event("IFG"), getRoleSet("Athlete - COM - Volleyball Women, Tennis"));
        Map<Event, Set<Role>> eventRoles2 = new HashMap<>();
        eventRoles2.put(new Event("IFG"), getRoleSet("Volunteer - Photographer", "Committee - Publicity - Project Director"));
        Map<Event, Set<Role>> eventRoles3 = new HashMap<>();
        eventRoles3.put(new Event("SUNIG"), getRoleSet("Sponsor - OATSIDE"));
        Map<Event, Set<Role>> eventRoles4 = new HashMap<>();
        eventRoles4.put(new Event("AUG"), getRoleSet("Athlete - FASS - Swimming Men"));
        Map<Event, Set<Role>> eventRoles5 = new HashMap<>();
        eventRoles5.put(new Event("IVP"), getRoleSet("Audience"));

        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                eventRoles1),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                eventRoles2),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                eventRoles3),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                eventRoles4),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                eventRoles5),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                eventRoles1),
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Role> getRoleSet(String... strings) {
        return Arrays.stream(strings)
                .map(ParserUtil::parseRole)
                .collect(Collectors.toSet());
    }

    public static Set<Event> getEventSet(String ... strings) {
        return Arrays.stream(strings)
                .map(ParserUtil::parseEvent)
                .collect(Collectors.toSet());
    }

}

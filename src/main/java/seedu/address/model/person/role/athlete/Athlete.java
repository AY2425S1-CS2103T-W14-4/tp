package seedu.address.model.person.role.athlete;

import java.util.List;
import java.util.stream.Collectors;

import seedu.address.model.person.role.Faculty;
import seedu.address.model.person.role.Role;

/**
 * Represents an Athlete in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Athlete extends Role {
    private final Faculty faculty;
    private final List<Sport> sports;

    /**
     * Creates an {@code Athlete} object with the given {@link Faculty} and {@link Sport}.
     *
     * @param faculty Athlete's home {@link Faculty}.
     * @param sports   Athlete's participating {@link Sport}s in a {@link List}.
     */
    public Athlete(Faculty faculty, List<Sport> sports) {
        super("Athlete - " + faculty + " - " + sports.stream().map(SportString::getSportString)
                .collect(Collectors.joining(", ")));
        this.faculty = faculty;
        this.sports = sports;
    }
}

package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EVENT_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EVENT_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_ATHLETE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_VOLUNTEER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {
    // in typicaladdressbook.json
    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withEmail("alice@example.com")
            .withPhone("94351253")
            .withEventRoles("IFG" + PREFIX_ROLE + "Athlete - COM - Volleyball Women, Floorball Women")
            .build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withEmail("johnd@example.com")
            .withPhone("98765432")
            .withEventRoles("SUNIG" + PREFIX_ROLE + "Athlete - FASS - Swimming Men" + PREFIX_ROLE + "Volunteer - Emcee")
            .build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz")
            .withPhone("95352563")
            .withEmail("heinz@example.com")
            .withEventRoles("AUG")
            .build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier")
            .withPhone("87652533")
            .withEmail("cornelia@example.com")
            .withEventRoles("IVP" + PREFIX_ROLE + "Sponsor - OATSIDE")
            .build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer")
            .withPhone("9482224")
            .withEventRoles("IFG")
            .withEmail("werner@example.com").build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz")
            .withPhone("9482427")
            .withEmail("lydia@example.com")
            .withEventRoles("SUNIG" + PREFIX_ROLE + "Committee - Publicity - Project Director")
            .build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best")
            .withPhone("9482442")
            .withEmail("anna@example.com")
            .withEventRoles("IVP" + PREFIX_ROLE + "Committee - Sports - Vice Sports Director - BIZ")
            .build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withEventRoles(VALID_EVENT_AMY + PREFIX_ROLE + VALID_ROLE_VOLUNTEER).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withEventRoles(VALID_EVENT_BOB + PREFIX_ROLE + VALID_ROLE_ATHLETE + PREFIX_ROLE
                    + VALID_ROLE_VOLUNTEER)
            .build();

    private TypicalPersons() {} // prevents instantiation

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}

package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.event.Event;
import seedu.address.model.person.Person;
import seedu.address.model.person.role.Role;

/**
 * A utility class for Person.
 */
public class PersonUtil {
    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddCommand(Person person) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(person);
    }

    /**
     * Returns the part of command string for the given {@code person}'s details.
     */
    public static String getPersonDetails(Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + person.getName().fullName + " ");
        sb.append(PREFIX_PHONE + person.getPhone().value + " ");
        sb.append(PREFIX_EMAIL + person.getEmail().value + " ");
        person.getEvents().stream().forEach(
                e -> sb.append(PREFIX_EVENT + e.value + " ")
        );
        person.getRoles().stream().forEach(
            s -> sb.append(PREFIX_ROLE + s.roleName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        descriptor.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));

        if (descriptor.getEvents().isPresent()) {
            Set<Event> events = descriptor.getEvents().get();
            if (events.isEmpty()) {
                sb.append(PREFIX_EVENT);
            } else {
                events.forEach(e -> sb.append(PREFIX_EVENT).append(e.value).append(" "));
            }
        }

        if (descriptor.getRoles().isPresent()) {
            Set<Role> roles = descriptor.getRoles().get();
            if (roles.isEmpty()) {
                sb.append(PREFIX_ROLE);
            } else {
                roles.forEach(s -> sb.append(PREFIX_ROLE).append(s.roleName).append(" "));
            }
        }

        return sb.toString();
    }
}

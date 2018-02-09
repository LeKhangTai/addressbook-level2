package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = new String("(?<block>[^/]+),"
            + " (?<street>[^/]+),"
            + " (?<unit>[^/]+)"
            + " (?<postalCode>[^/]+)");

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.value = trimmedAddress;
        String[] splitAddress = trimmedAddress.split(", ");
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block = new Block(splitAddress[0]);
        this.street = new Street(splitAddress[1]);
        this.unit = new Unit(splitAddress[2]);
        this.postalCode = new PostalCode(splitAddress[3]);

    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }


    public class Block {
        String value;

        public Block(String block) {
            this.value = block;
        }
    }

    public class Street {
        String value;

        public Street(String street) {
            this.value = street;
        }
    }

    public class Unit {
        String value;

        public Unit(String unit) {
            this.value = unit;
        }
    }

    public class PostalCode {
        String value;

        public PostalCode(String postalCode) {
            this.value = postalCode;
        }
    }
}
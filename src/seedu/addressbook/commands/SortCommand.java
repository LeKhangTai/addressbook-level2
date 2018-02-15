package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_SUCCESS = "Address book has been sorted";
    public static final String MESSAGE_USAGE = COMMAND_WORD + " :Sort the names of the address book according to lexicographic order\n"
                                               + "Example: " + COMMAND_WORD;

    public SortCommand(){}

    @Override
    public CommandResult execute(){
        addressBook.sort();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(MESSAGE_SUCCESS, allPersons);

    }

}

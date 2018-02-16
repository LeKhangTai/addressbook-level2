package seedu.addressbook.ui;

import java.util.List;
import static seedu.addressbook.common.Messages.*;

/**
 * Formatter class that handles messages frrm textUI
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    /**
     *
     * @param version
     * @param storageFilePath
     * @return Formatted welcome message
     */



    public String getWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
       return getFormattedMessage(DIVIDER, DIVIDER, MESSAGE_WELCOME, version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }

    public String getEnterCommandMessage() {
        return LINE_PREFIX + "Enter command: ";
    }

    /**
     *  Gets goodbye message
     */
    public String getGoodByeMessage(){
        return getFormattedMessage(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    /**
     *  Gets format failure message
     */
    public String getInitFailedMessage(){
        return getFormattedMessage(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /**
     * Gets format message
     */
    public String getResultMessage(String feedbackToUser){
        return getFormattedMessage(feedbackToUser, DIVIDER);

    }
    protected boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
        }


    public String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    public String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
        }

    public String getFormattedMessage(String... message) {
        String getFormattedMessage = "";
        for (String m : message) {
            getFormattedMessage += LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX) + "\n";
        }
        return getFormattedMessage; }


}

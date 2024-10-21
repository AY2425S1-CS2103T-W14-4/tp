package seedu.address.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.util.StringUtil;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {
    private static final String HELP_PATH = "docs/help/help.txt";
    private static final String FXML = "HelpWindow.fxml";
    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(loadHelpMessage());
        copyButton.setOnAction(event -> copyUrl());
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Reads the help message from a file.
     */
    private String loadHelpMessage() {
        StringBuilder helpMessage = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(HELP_PATH));
            String line;
            while ((line = br.readLine()) != null) {
                helpMessage.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error! Could not retrieve help message from file.");
            return "Failed to load help message.";
        }
        return helpMessage.toString();
    }

    private void copyUrl() {
        StringUtil.copyToClipboard("https://ay2425s1-cs2103t-w14-4.github.io/tp/UserGuide.html");
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }
}

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.*;

public class GradeBookApp extends Application {

    // Form fields
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private ComboBox<String> gradeComboBox;

    // Results area
    private TextArea resultsArea;

    // CSV file path (same directory as the application)
    private static final String CSV_FILE = "grades.csv";
    private static final String CSV_HEADER = "firstName,lastName,course,grade";

    @Override
    public void start(Stage primaryStage) {

        // ── Root Layout ────────────────────────────────────────────────
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #f0f4f8;");

        // ── Header ─────────────────────────────────────────────────────
        VBox header = buildHeader();
        root.setTop(header);

        // ── Center: Form + Results ──────────────────────────────────────
        VBox centerContent = new VBox(20);
        centerContent.setPadding(new Insets(24, 32, 24, 32));

        VBox formCard = buildFormCard();
        VBox resultsCard = buildResultsCard();

        centerContent.getChildren().addAll(formCard, resultsCard);
        root.setCenter(centerContent);

        // ── Footer ─────────────────────────────────────────────────────
        HBox footer = buildFooter();
        root.setBottom(footer);

        // ── Scene & Stage ──────────────────────────────────────────────
        Scene scene = new Scene(root, 680, 680);
        primaryStage.setTitle("GradeBookApp — OpenEdX / learn.edu");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // ── Header Section ─────────────────────────────────────────────────────
    private VBox buildHeader() {
        VBox header = new VBox(4);
        header.setPadding(new Insets(24, 32, 16, 32));
        header.setStyle("-fx-background-color: #1a3a5c;");

        Text title = new Text("GradeBook App");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        title.setStyle("-fx-fill: #ffffff;");

        Text subtitle = new Text("OpenEdX Student Performance Tracking — learn.edu");
        subtitle.setFont(Font.font("Arial", 13));
        subtitle.setStyle("-fx-fill: #a8c4e0;");

        header.getChildren().addAll(title, subtitle);
        return header;
    }

    // ── Form Card ──────────────────────────────────────────────────────────
    private VBox buildFormCard() {
        VBox card = new VBox(16);
        card.setPadding(new Insets(20, 24, 20, 24));
        card.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #d0dce8;" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 6, 0, 0, 2);"
        );

        Text cardTitle = new Text("Grade Entry Form");
        cardTitle.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        cardTitle.setStyle("-fx-fill: #1a3a5c;");

        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: #e0eaf3;");

        // Form grid
        GridPane grid = new GridPane();
        grid.setHgap(16);
        grid.setVgap(14);
        grid.setAlignment(Pos.CENTER_LEFT);

        ColumnConstraints labelCol = new ColumnConstraints(120);
        ColumnConstraints fieldCol = new ColumnConstraints(320);
        grid.getColumnConstraints().addAll(labelCol, fieldCol);

        // First Name
        Label firstNameLabel = createLabel("First Name:");
        firstNameField = createTextField("Enter first name");
        grid.add(firstNameLabel, 0, 0);
        grid.add(firstNameField, 1, 0);

        // Last Name
        Label lastNameLabel = createLabel("Last Name:");
        lastNameField = createTextField("Enter last name");
        grid.add(lastNameLabel, 0, 1);
        grid.add(lastNameField, 1, 1);

        // Course
        Label courseLabel = createLabel("Course:");
        courseField = createTextField("Enter course name");
        grid.add(courseLabel, 0, 2);
        grid.add(courseField, 1, 2);

        // Grade
        Label gradeLabel = createLabel("Grade:");
        gradeComboBox = buildGradeComboBox();
        grid.add(gradeLabel, 0, 3);
        grid.add(gradeComboBox, 1, 3);

        // Button row
        HBox buttonRow = buildButtonRow();

        card.getChildren().addAll(cardTitle, separator, grid, buttonRow);
        return card;
    }

    // ── Label Factory ──────────────────────────────────────────────────────
    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        label.setStyle("-fx-text-fill: #2c4a6e;");
        return label;
    }

    // ── TextField Factory ─────────────────────────────────────────────────
    private TextField createTextField(String prompt) {
        TextField field = new TextField();
        field.setPromptText(prompt);
        field.setPrefHeight(36);
        field.setStyle(
            "-fx-font-family: Arial;" +
            "-fx-font-size: 13;" +
            "-fx-border-color: #b0c4d8;" +
            "-fx-border-radius: 4;" +
            "-fx-background-radius: 4;" +
            "-fx-padding: 6 10 6 10;"
        );
        return field;
    }

    // ── Grade ComboBox ─────────────────────────────────────────────────────
    private ComboBox<String> buildGradeComboBox() {
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("A", "B", "C", "D", "F");
        combo.setPromptText("Select grade");
        combo.setPrefWidth(320);
        combo.setPrefHeight(36);
        combo.setStyle(
            "-fx-font-family: Arial;" +
            "-fx-font-size: 13;" +
            "-fx-border-color: #b0c4d8;" +
            "-fx-border-radius: 4;" +
            "-fx-background-radius: 4;"
        );
        return combo;
    }

    // ── Button Row ─────────────────────────────────────────────────────────
    private HBox buildButtonRow() {
        HBox row = new HBox(12);
        row.setAlignment(Pos.CENTER_RIGHT);
        row.setPadding(new Insets(8, 0, 0, 0));

        Button clearBtn = createButton("Clear",       "#6b7c93", "#ffffff");
        Button viewBtn  = createButton("View Grades", "#2e6da4", "#ffffff");
        Button saveBtn  = createButton("Save Entry",  "#1a3a5c", "#ffffff");

        // ── Event Handlers ─────────────────────────────────────────────
        clearBtn.setOnAction(e -> handleClear());
        viewBtn.setOnAction(e  -> handleViewGrades());
        saveBtn.setOnAction(e  -> handleSave());

        row.getChildren().addAll(clearBtn, viewBtn, saveBtn);
        return row;
    }

    // ── Button Factory ─────────────────────────────────────────────────────
    private Button createButton(String text, String bgColor, String textColor) {
        Button btn = new Button(text);
        btn.setPrefHeight(36);
        btn.setPrefWidth(110);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        String base = String.format(
            "-fx-background-color: %s;" +
            "-fx-text-fill: %s;" +
            "-fx-border-radius: 4;" +
            "-fx-background-radius: 4;" +
            "-fx-cursor: hand;",
            bgColor, textColor
        );
        btn.setStyle(base);
        btn.setOnMouseEntered(e -> btn.setStyle(base + "-fx-opacity: 0.85;"));
        btn.setOnMouseExited(e  -> btn.setStyle(base));
        return btn;
    }

    // ── Results Card ───────────────────────────────────────────────────────
    private VBox buildResultsCard() {
        VBox card = new VBox(12);
        card.setPadding(new Insets(20, 24, 20, 24));
        card.setStyle(
            "-fx-background-color: #ffffff;" +
            "-fx-border-color: #d0dce8;" +
            "-fx-border-width: 1;" +
            "-fx-border-radius: 6;" +
            "-fx-background-radius: 6;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 6, 0, 0, 2);"
        );

        Text cardTitle = new Text("Grade Records");
        cardTitle.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        cardTitle.setStyle("-fx-fill: #1a3a5c;");

        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: #e0eaf3;");

        resultsArea = new TextArea();
        resultsArea.setPromptText("Saved grade entries will appear here after clicking \"View Grades\"...");
        resultsArea.setPrefHeight(160);
        resultsArea.setEditable(false);
        resultsArea.setWrapText(true);
        resultsArea.setStyle(
            "-fx-font-family: 'Courier New';" +
            "-fx-font-size: 12;" +
            "-fx-border-color: #b0c4d8;" +
            "-fx-border-radius: 4;" +
            "-fx-background-radius: 4;" +
            "-fx-control-inner-background: #f7fafd;"
        );

        card.getChildren().addAll(cardTitle, separator, resultsArea);
        return card;
    }

    // ── Footer ─────────────────────────────────────────────────────────────
    private HBox buildFooter() {
        HBox footer = new HBox();
        footer.setPadding(new Insets(10, 32, 12, 32));
        footer.setStyle("-fx-background-color: #dce8f0;");
        footer.setAlignment(Pos.CENTER_LEFT);

        Label footerText = new Label("Sprint 2 — Fully Functional  |  OpenEdX GradeBookApp");
        footerText.setFont(Font.font("Arial", 11));
        footerText.setStyle("-fx-text-fill: #5a7a96;");

        footer.getChildren().add(footerText);
        return footer;
    }

    // ──────────────────────────────────────────────────────────────────────
    // EVENT HANDLERS
    // ──────────────────────────────────────────────────────────────────────

    // ── Handle Clear ───────────────────────────────────────────────────────
    private void handleClear() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.getSelectionModel().clearSelection();
        gradeComboBox.setPromptText("Select grade");
        resultsArea.clear();
    }

    // ── Handle Save ────────────────────────────────────────────────────────
    private void handleSave() {
        // Validate all fields are filled
        String firstName = firstNameField.getText().trim();
        String lastName  = lastNameField.getText().trim();
        String course    = courseField.getText().trim();
        String grade     = gradeComboBox.getValue();

        if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty() || grade == null) {
            showAlert(Alert.AlertType.ERROR,
                "Missing Information",
                "All fields are required.",
                "Please fill in First Name, Last Name, Course, and Grade before saving.");
            return;
        }

        // Create Student object using parameterized constructor
        Student student = new Student(firstName, lastName, course, grade);

        // Write to CSV, creating header row if file does not exist
        try {
            File csvFile = new File(CSV_FILE);
            boolean isNewFile = !csvFile.exists();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
                if (isNewFile) {
                    writer.write(CSV_HEADER);
                    writer.newLine();
                }
                writer.write(firstName + "," + lastName + "," + course + "," + grade);
                writer.newLine();
            }

            showAlert(Alert.AlertType.INFORMATION,
                "Entry Saved",
                "Grade entry saved successfully.",
                student.toString());

            // Clear form after successful save
            handleClear();

        } catch (IOException ex) {
            showAlert(Alert.AlertType.ERROR,
                "Save Error",
                "Could not write to grades.csv.",
                ex.getMessage());
        }
    }

    // ── Handle View Grades ─────────────────────────────────────────────────
    private void handleViewGrades() {
        File csvFile = new File(CSV_FILE);

        if (!csvFile.exists()) {
            resultsArea.setText("No grade records found. Save an entry first.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Parse CSV line into Student object and display via toString()
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Student student = new Student(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim()
                    );
                    sb.append(student.toString()).append("\n");
                }
            }

            // Display results or a friendly empty state message
            if (sb.length() == 0) {
                resultsArea.setText("No grade entries found in grades.csv.");
            } else {
                resultsArea.setText(sb.toString());
            }

        } catch (IOException ex) {
            showAlert(Alert.AlertType.ERROR,
                "Read Error",
                "Could not read grades.csv.",
                ex.getMessage());
        }
    }

    // ── Alert Helper ───────────────────────────────────────────────────────
    private void showAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
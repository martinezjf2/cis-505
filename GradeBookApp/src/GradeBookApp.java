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

public class GradeBookApp extends Application {

    // Form fields
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private ComboBox<String> gradeComboBox;

    // Results area
    private TextArea resultsArea;

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

        // Card title
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

        // Column constraints: label col + field col
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

        Button clearBtn = createButton("Clear", "#6b7c93", "#ffffff");
        Button viewBtn  = createButton("View Grades", "#2e6da4", "#ffffff");
        Button saveBtn  = createButton("Save Entry", "#1a3a5c", "#ffffff");

        // Event handlers will be wired in Sprint 2 (Module 11)
        clearBtn.setOnAction(e -> { /* TODO: Sprint 2 */ });
        viewBtn.setOnAction(e ->  { /* TODO: Sprint 2 */ });
        saveBtn.setOnAction(e ->  { /* TODO: Sprint 2 */ });

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
        // Hover effect
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

        Label footerText = new Label("Sprint 1 — UI Only  |  Event handling coming in Sprint 2 (Module 11)");
        footerText.setFont(Font.font("Arial", 11));
        footerText.setStyle("-fx-text-fill: #5a7a96;");

        footer.getChildren().add(footerText);
        return footer;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
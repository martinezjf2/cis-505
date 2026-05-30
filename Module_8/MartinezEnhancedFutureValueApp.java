import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MartinezEnhancedFutureValueApp extends Application {

    // Step a: Private static int MONTHS_IN_YEAR with default value of 12
    private static int MONTHS_IN_YEAR = 12;

    // Created the private user interface variables
    private Label lblMonthlyPayment     = new Label("Monthly Payment:");
    private Label lblInterestRate       = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblYears              = new Label("Years:");
    private Label lblFutureValueDate    = new Label("");

    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate   = new TextField();
    private TextArea  txtResults        = new TextArea();

    private ComboBox<Integer> cboYears  = new ComboBox<>();

    private Button btnClear             = new Button("Clear");
    private Button btnCalculate         = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {

        // seetting up the gridpane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        for (int i = 1; i <= 30; i++) {
            cboYears.getItems().add(i);
        }
        cboYears.getSelectionModel().selectFirst();

        lblInterestRateFormat.setTextFill(Color.RED);

        // Adding the controls to GridPane
        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(txtMonthlyPayment, 1, 0);

        pane.add(lblInterestRate, 0, 1);
        pane.add(txtInterestRate, 1, 1);

        pane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        pane.add(lblYears, 0, 3);
        pane.add(cboYears, 1, 3);

        // HBox for buttons
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);
        pane.add(actionBtnContainer, 1, 4);

        // Calculation date label and results text area
        pane.add(lblFutureValueDate, 0, 5, 2, 1);
        pane.add(txtResults, 0, 6, 2, 1);
        txtResults.setPrefRowCount(5);
        txtResults.setEditable(false);

        // Button onAction events
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate(e -> calculateResults());

        // Scene and Stage
        Scene scene = new Scene(pane, 350, 420);
        primaryStage.setTitle("Martinez Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Step b: Static double method calculateFutureValue with three parameters
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {

        // Step c: Calculate months
        int months = years * MONTHS_IN_YEAR;

        // Step d: Calculate interest rate — Exhibit A: (1 + rate / 100)
        double interestRate = (1 + rate / 100);

        // Step e: Calculate presentValue
        double presentValue = monthlyPayment * months;

        // Step f: Calculate futureValue — Exhibit B
        double futureValue = presentValue * (Math.pow(interestRate, months));

        // Return the calculated futureValue
        return futureValue;
    }

    // Step 2a: clearFormFields() — void method
    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        lblFutureValueDate.setText("");
        cboYears.setValue(0);
    }

    // Step 2b: calculateResults() — collects values and calls calculateFutureValue
    private void calculateResults() {
        double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText());
        double rate           = Double.parseDouble(txtInterestRate.getText());
        int    years          = cboYears.getValue();

        double futureValue = calculateFutureValue(monthlyPayment, rate, years);

        lblFutureValueDate.setText("Calculation as of " + getTodaysDate());
        txtResults.setText(String.format("The future value is $%,.2f", futureValue));
    }

    // Step 2c: getTodaysDate() — returns date in MM/dd/yyyy format
    private String getTodaysDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
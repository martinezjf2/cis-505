package FutureValueApp;


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

public class MartinezFutureValueApp extends Application {

    // Step 5 Cretin the Private Varioables: — 2 TextFields, 1 TextArea, 5 Labels, 1 ComboBox<Integer>, 2 Buttons

    // Step 5a: Labels with default text values (Exhibit C)
    private Label lblMonthlyPayment     = new Label("Monthly Payment:");
    private Label lblInterestRate       = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblYears              = new Label("Years:");
    private Label lblResults            = new Label("Results:");

    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate   = new TextField();
    private TextArea  txtResults        = new TextArea();

    private ComboBox<Integer> cboYears  = new ComboBox<>();

    // Step 5b from instructions: Buttons with default text values (Exhibit D)
    private Button btnClear             = new Button("Clear");
    private Button btnCalculate         = new Button("Calculate");

    // Step 4 from instructions: @Override start(Stage primaryStage) — Exhibit B
    @Override
    public void start(Stage primaryStage) {

        // Step 5c from instructions: Create GridPane, set alignment, padding, Hgap, Vgap
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        for (int i = 1; i <= 30; i++) {
            cboYears.getItems().add(i);
        }
        cboYears.getSelectionModel().selectFirst();

        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(txtMonthlyPayment, 1, 0);
        pane.add(lblInterestRate, 0, 1);
        pane.add(txtInterestRate, 1, 1);
        lblInterestRateFormat.setTextFill(Color.RED);
        pane.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);


        pane.add(lblYears, 0, 3);
        pane.add(cboYears, 1, 3);

        // Step 5e form instruction: HBox for Clearing and Calculate buttons — spacing 10, padding 15,0,15,30 (Exhibit F)
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);
        pane.add(actionBtnContainer, 1, 4);

        // Row 5: TextArea for results (matches Exhibit A output area)
        pane.add(lblResults, 0, 5);
        pane.add(txtResults, 0, 6, 2, 1);

        // Step 5f: Setting primary stage title
        Scene scene = new Scene(pane, 350, 420);
        primaryStage.setTitle("LastName Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
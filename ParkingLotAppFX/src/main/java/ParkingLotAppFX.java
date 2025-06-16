import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.Stage;

public class ParkingLotAppFX extends Application {

    private final int FLOORS = 5;
    private final int SLOTS = 5;
    private Button[][] buttons = new Button[FLOORS][SLOTS];
    private ParkingLotManager manager = new ParkingLotManager();
    private Label feedbackLabel = new Label("Welcome to Parking Lot System!");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(5);
        grid.setHgap(5);

        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < SLOTS; j++) {
                Button btn = new Button("Empty");
                btn.setPrefSize(80, 40);
                int floor = i, slot = j;
                btn.setOnAction(e -> handleSlotClick(floor, slot, btn));
                grid.add(btn, j, i);
                buttons[i][j] = btn;
            }
        }

        TextField searchField = new TextField();
        searchField.setPromptText("Enter vehicle number");
        Button searchBtn = new Button("Search");
        searchBtn.setOnAction(e -> {
            String result = manager.searchVehicle(searchField.getText());
            feedbackLabel.setText(result);
        });

        VBox root = new VBox(10, grid, new HBox(10, searchField, searchBtn), feedbackLabel);
        root.setPadding(new Insets(15));

        primaryStage.setTitle("Parking Lot App - JavaFX");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

    private void handleSlotClick(int floor, int slot, Button btn) {
        if (manager.getVehicle(floor, slot) == null) {
            TextInputDialog nameDialog = new TextInputDialog();
            nameDialog.setHeaderText("Enter owner's name:");
            String name = nameDialog.showAndWait().orElse("");

            TextInputDialog modelDialog = new TextInputDialog();
            modelDialog.setHeaderText("Enter vehicle model:");
            String model = modelDialog.showAndWait().orElse("");

            TextInputDialog numDialog = new TextInputDialog();
            numDialog.setHeaderText("Enter vehicle number:");
            String number = numDialog.showAndWait().orElse("");

            if (!name.isEmpty() && !number.isEmpty()) {
                Vehicle vehicle = new Vehicle(name, model, number);
                boolean parked = manager.parkVehicle(floor, slot, vehicle);
                if (parked) {
                    btn.setText("Occupied");
                    btn.setStyle("-fx-background-color: red;");
                    feedbackLabel.setText("Parked at Floor " + (floor + 1) + ", Slot " + (slot + 1));
                }
            }
        } else {
            feedbackLabel.setText("Slot is already occupied.");
        }
    }
}

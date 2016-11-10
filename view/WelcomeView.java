package view;

import functionality.Board;
import functionality.ComputerPlayer;
import functionality.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WelcomeView extends BorderPane {

	public WelcomeView() {
		setPadding(new Insets(20, 0, 20, 20));
		setUp();
	}

	private void setUp() {
		VBox vbButtons = new VBox();
		vbButtons.setSpacing(10);
		vbButtons.setPadding(new Insets(0, 20, 10, 20));

		Button singlePlayerButton = new Button("Play single player");
		singlePlayerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				Stage stage = new Stage();
				stage.setTitle("Oware");

				ComputerPlayer player1 = new ComputerPlayer();
				Player player2 = new Player("Player");
				Board board = new Board(player1, player2, true); // isComputer

				StackPane stack = new StackPane();
				stack.getChildren().add(new Background());
				stack.getChildren().add(new BoardView(board));

				Scene scene = new Scene(stack, 800, 400);
				stage.setScene(scene);
				stage.show();

				((Node) event.getSource()).getScene().getWindow().hide();
			}
		});

		Button twoPlayerButton = new Button("Play two-player");
		twoPlayerButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = new Stage();
				stage.setTitle("Oware");

				Player player1 = new Player("Player 1");
				Player player2 = new Player("Player 2");
				Board board = new Board(player1, player2);

				StackPane stack = new StackPane();
				stack.getChildren().add(new Background());
				stack.getChildren().add(new BoardView(board));

				Scene scene = new Scene(stack, 800, 400);
				stage.setScene(scene);
				stage.show();

				((Node) event.getSource()).getScene().getWindow().hide();
			}
		});

		singlePlayerButton.setMaxWidth(Double.MAX_VALUE);
		twoPlayerButton.setMaxWidth(Double.MAX_VALUE);

		vbButtons.getChildren().addAll(singlePlayerButton, twoPlayerButton);

		Label welcomeLabel = new Label("Oware");
		welcomeLabel.setFont(new Font("Arial", 30));
		welcomeLabel.setMaxWidth(Double.MAX_VALUE);
		welcomeLabel.setAlignment(Pos.CENTER);
		welcomeLabel.setPadding(new Insets(20, 0, 20, 20));

		setTop(welcomeLabel);
		setCenter(vbButtons);
	}
}
package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

    public Label question;
    public Button optionOne;
    public Button optionTwo;
    public ProgressBar progress;
    public TableColumn biodiversity;
    public TableColumn money;
    public TableColumn pollution;
    public TableColumn publicSupport;
    private ArrayList<Question> temp;
    private boolean gameState = false;

    public void startGame(ActionEvent event)
    {
 /**https://stackoverflow.com/questions/30200461/javafx-how-can-i-modify-button-text-in-real-time
  * Changing button text ^^^^
  *
        question.setText(Backend.fromCSV().get(0).getScenario());
        optionOne.setText(Backend.fromCSV().get(0).getYes());
        optionTwo.setText(Backend.fromCSV().get(0).getNo());
  **/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameState = true;
        temp = Backend.fromCSV();

    }

    public void handler()
    {

    }
}

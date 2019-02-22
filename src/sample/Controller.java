package sample;

import javafx.fxml.Initializable;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Controller
{
    public Label question;
    public Label optionOne;
    public Label optionTwo;

    public void startGame(ActionEvent event)
    {
        question.setText(Backend.fromCSV().get(0).getScenario());
        optionOne.setText(Backend.fromCSV().get(0).getYes());
        optionTwo.setText(Backend.fromCSV().get(0).getNo());
    }
}

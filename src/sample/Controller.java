package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

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
    public TableView<PlayerStats> stats;
    public TableColumn biodiversity;
    public TableColumn money;
    public TableColumn pollution;
    public TableColumn publicSupport;
    private ArrayList<Question> temp;
    private boolean gameState = false;
    private int tracker = -1;

    private int bio = 10;
    private int mon = 10;
    private int pol = 10;
    private int pub = 10;

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

    private final ObservableList<PlayerStats> currentStats = FXCollections.observableArrayList(
            new PlayerStats(bio, mon, pol, pub)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameState = true;
        temp = Backend.fromCSV();
        update();
    }

    public void update()
    {
        if(tracker < temp.size())
        {
            tracker++;
            if(tracker>=temp.size())
            {

                question.setText("You have reached the end of your term.");
                optionOne.setText("Nice");
                optionTwo.setText("Not Nice");
                progress.setProgress((double)tracker/temp.size());
                return;
            }
            question.setText(temp.get(tracker).getScenario());
            optionOne.setText(temp.get(tracker).getYes());
            optionTwo.setText(temp.get(tracker).getNo());
            System.out.println(temp.size());
            setStats();

            progress.setProgress((double)tracker/temp.size());
        }
        /**else
        {
            question.setText("Your term is over!");
            optionOne.setVisible(false);
            optionTwo.setVisible(false);
        }
      **/

        else {
            question.setText("You have reached the end of your term.");
            optionOne.setText("Nice");
            optionTwo.setText("Not Nice");
        }

    }

    public void setStats()
    {
        biodiversity.setCellValueFactory(new PropertyValueFactory<>("Biodiversity"));
        money.setCellValueFactory(new PropertyValueFactory<>("Money"));
        pollution.setCellValueFactory(new PropertyValueFactory<>("Pollution"));
        publicSupport.setCellValueFactory(new PropertyValueFactory<>("PublicSupport"));
        stats.setItems(currentStats);
    }

    public void handler(javafx.event.ActionEvent event) {

        if(gameState &&tracker < temp.size())
        {

            if(event.getSource().equals(optionOne))
            {
                if(tracker < temp.size()) {

                bio += temp.get(tracker).getyBiodiversity();
                mon += temp.get(tracker).getyMoney();
                pol += temp.get(tracker).getyPollution();
                pub += temp.get(tracker).getySupport();
                currentStats.setAll(new PlayerStats(bio, mon, pol, pub));
                    /** updates values of w/e the choice brings **/
                update();
                }
            }
            else
            {
                if(tracker < temp.size()) {

                    bio += temp.get(tracker).getnBiodiversity();
                    mon += temp.get(tracker).getnMoney();
                    pol += temp.get(tracker).getnPollution();
                    pub += temp.get(tracker).getnSupport();
                    currentStats.setAll(new PlayerStats(bio, mon, pol, pub));
                    /** updates values of w/e the choice brings **/
                    update();
                }
            }
        }
    }
}

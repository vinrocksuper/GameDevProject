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
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class   Controller implements Initializable
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

    private ArrayList<Question> ineligible = new ArrayList<>();


    private int bio = 0;
    private int mon = 0;
    private int pol = 0;
    private int pub = 0;

    private final ObservableList<PlayerStats> currentStats = FXCollections.observableArrayList(
            new PlayerStats(bio, mon, pol, pub)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gameState = true;
        temp = Backend.fromCSV();
        Collections.shuffle(temp);
        filter(temp);
        update();

    }
    public void filter(ArrayList<Question> t)
    {
        for(int i=0;i<t.size();i++)
        {
            if(t.get(i).getqBio() != 0 || t.get(i).getqMon() != 0 || t.get(i).getqPol() != 0 || t.get(i).getqSup() !=0)
            {
                if(t.get(i).getqPol() >= this.pol)
                {
                    ineligible.add(t.remove(i));

                    break;
                }
                if(t.get(i).getqMon() > this.mon)
                {
                    ineligible.add(t.remove(i));

                    break;
                }
                if(t.get(i).getqSup() <= this.pub)
                {
                    ineligible.add((t.remove(i)));

                    break;
                }
                if(t.get(i).getqBio() > this.mon)
                {
                    ineligible.add(t.remove(i));

                    break;
                }
            }
        }
    }
    public void reAdd()
    {
        for(int i=0;i<ineligible.size();i++)
        {

                if(ineligible.get(i).getqPol() < this.pol)
                {
                    temp.add(ineligible.remove(i));
                    break;
                }
                if(ineligible.get(i).getqMon() <= this.mon)
                {
                    temp.add(ineligible.remove(i));
                    break;
                }
                if(ineligible.get(i).getqSup() > this.pub)
                {
                    temp.add((ineligible.remove(i)));
                    break;
                }
                if(ineligible.get(i).getqBio() <= this.mon)
                {
                    temp.add(ineligible.remove(i));
                    break;
                }
            }

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
            setStats();
            reAdd();
            filter(temp);
            progress.setProgress((double)tracker/temp.size());
        }
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

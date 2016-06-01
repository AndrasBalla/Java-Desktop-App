package main.java.UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.java.Buss_lines.LineDatabase;
import main.java.Buss_lines.TicketDatabase;
import main.java.Objekt.Line;
import main.java.Objekt.Stop;
import main.java.Objekt.Ticket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Spiks on 2016-05-30.
 * In the project Buss_System
 */
public class BookTicket {
    private TicketDatabase database = new TicketDatabase();
    private LineDatabase lineDatabase = new LineDatabase();
    private GridPane grid = new GridPane();
    private ComboBox<String> addOrigin;
    private ComboBox<String> addDest;
    private ComboBox<String> addLine;
    private TextField addDate;
    private TextField addName;
    private Ticket ticket = new Ticket();
    private ArrayList<Stop> stops;

    public VBox init(){
        gridSetup();
        HBox titleBox = new HBox();
        Text title = new Text("Book Ticket");
        titleBox.getChildren().addAll(title);
        titleBox.setAlignment(Pos.CENTER);
        title.getStyleClass().add("custom-title");
        title.setId("custom-title");

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        final VBox vbox = new VBox();
        vbox.getChildren().addAll(titleBox,grid);
        return vbox;
    }

    private void gridSetup(){
        Text name = new Text("Name");
        grid.add(name,0,1);

        addName = new TextField();
        addName.setPromptText("Enter Name");
        grid.add(addName,1,1);

        Text line = new Text("Choose a line");
        grid.add(line,0,2);

        addLine = new ComboBox<>();
        grid.add(addLine,1,2);

        Text source = new Text("Origin");
        grid.add(source,0,3);

        addOrigin = new ComboBox<>();
        grid.add(addOrigin,1,3);

        Text dest = new Text("Destination");
        grid.add(dest,0,4);

        addDest = new ComboBox<>();
        grid.add(addDest,1,4);

        Text date = new Text("Fare Date");
        grid.add(date,0,5);

        addDate = new TextField();
        addDate.setPromptText("YYYY-MM-DD");
        grid.add(addDate,1,5);

        Button book = new Button("Submit");
        grid.add(book,1,6);

        database.ticketId(ticket);

        getLineInfo(addOrigin,addDest, addLine);
        submit(book);
    }

    private void getLineInfo(ComboBox<String> addOrigin, ComboBox<String> addDest, ComboBox<String> addLine){
        ArrayList<Line> lines = new ArrayList<>();
        stops = new ArrayList<>();
        lineDatabase.getLineIds(addLine,lines);
        addLine.setOnAction(event -> {
            addOrigin.getItems().clear();
            addDest.getItems().clear();
            stops.clear();
            lineDatabase.getStopsComboBox(addOrigin,addDest,addLine.getValue(),stops);
        });
    }

    private void submit(Button book){
        final Text warn = new Text("Invalid input! Please try again");
        warn.getStyleClass().add("custom-redTitle");
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        book.setOnAction(event -> {
            if (checkInput()){
                grid.getChildren().remove(warn);
                ticket.setPassengerName(addName.getText());
                ticket.setFareDate(addDate.getText());
                ticket.setPurchaseDate(currentDate);
                ticket.setDestination(getStop(addDest.getValue()));
                ticket.setLineId(addLine.getValue());
                ticket.setCost("30");
                ticket.setSource(getStop(addOrigin.getValue()));
                database.saveTicket(ticket);
            }else {
                System.out.println(ticket.getId());
                System.out.println("Try again");
                grid.add(warn, 2, 7);
            }
        });
    }

    private boolean checkInput(){
        if (addOrigin.getValue() == null || addDest.getValue() == null || addLine.getValue() == null){
            return false;
        }else if (addName.getText().length() == 0 || addDate.getText().length() != 10){
            return false;
        }else if (addOrigin.getValue().equals(addDest.getValue())){
            return false;
        }
        String name = addName.getText();
        for (int i = 0; i < name.length(); i++){
            if (Character.isDigit(name.charAt(i))){
                return false;
            }
        }
        String date = addDate.getText();
        for (int i = 0; i < date.length(); i++){
            if (!(Character.isDigit(date.charAt(i))) && date.charAt(i) != '-'){
                return false;
            }
        }
        return true;
    }

    private Stop getStop(String name){
        for (int i = 0; i < stops.size(); i++){
            if (stops.get(i).getName().equals(name)){
                return stops.get(i);
            }
        }
        return null;
    }
}

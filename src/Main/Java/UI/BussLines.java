package main.java.UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import main.java.Buss_lines.LineDatabase;

/**
 * Created by Spiks on 2016-04-30.
 * In the project Buss_System
 */
public class BussLines {
    private GridPane grid = new GridPane();
    private LineDatabase database = new LineDatabase();

    public GridPane init(){
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        staticElements();

        return grid;
    }

    private void staticElements(){
        Text title = new Text("Buss Lines");
        title.getStyleClass().add("custom-smallTitle");
        HBox titleHolder = new HBox();
        titleHolder.getChildren().add(title);
        titleHolder.setAlignment(Pos.TOP_RIGHT);
        grid.add(titleHolder,0,0);

        ComboBox lines = new ComboBox();
        database.updateLine(lines);
        grid.add(lines, 0, 1);

        Button confirm = new Button("Select");
        grid.add(confirm,1,1);
    }
}

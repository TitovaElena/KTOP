package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.InputStream;

public class Controller {
    @FXML
    CheckBox checkBox1 = new CheckBox();
    @FXML
    CheckBox checkBox2 = new CheckBox();
    @FXML
    CheckBox checkBox3 = new CheckBox();
    @FXML
    ImageView imageView = new ImageView();

    Class<?> clazz = this.getClass();

    public void onClickMethod(ActionEvent actionEvent) {

        checkBox1.setOnAction(event -> show());
        checkBox2.setOnAction(event -> show());
        checkBox3.setOnAction(event -> show());


    }
    String path = "";
    private void show() {

        if(checkBox1.isSelected()){
            path = "/ImagePackage/C0R0S0Q0.jpg";
        }
        if(checkBox2.isSelected()){
            path = "/ImagePackage/C0R0S0Q0.jpg";
        }
        if(checkBox3.isSelected()){
            path = "/ImagePackage/C1R0S0Q0.jpg";
        }
        InputStream input = clazz.getResourceAsStream(path);
        Image image = new Image(input);
        imageView.setImage(image);
    }






}

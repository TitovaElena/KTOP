package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private CheckBox C = new CheckBox();
    @FXML
    private CheckBox S = new CheckBox();
    @FXML
    private CheckBox R = new CheckBox();
    @FXML
    private ImageView imageView = new ImageView();
    @FXML
    private TextArea textArea = new TextArea();
    @FXML
    private Button button = new Button();
    @FXML
    private TextArea textArea2 = new TextArea();

    private int Q = 0;
    private boolean remembered = false;
    private Class<?> clazz = this.getClass();

    private String path = "";

    public void onClickMethod(ActionEvent actionEvent) {
        C.setOnAction(event -> show());
        S.setOnAction(event -> show());
        R.setOnAction(event -> show());
    }

    private void show() {
        textArea.clear();
        if(C.isSelected()){
            if (!S.isSelected() && !R.isSelected() && !remembered){
                path = "/ImagePackage/C1SXRXQX.jpg";
                Q = 0;
            }
            else if(S.isSelected() && !R.isSelected() && (Q == 0)){
                path = "/ImagePackage/C1S1R0Q0.jpg";
                Q = 1;
                remembered = true;
            }
            else if(S.isSelected() && !R.isSelected() && (Q == 1)){
                path = "/ImagePackage/C1S1R0Q1.jpg";
                Q = 1;
                remembered = true;
            }
            else if(!S.isSelected() && R.isSelected() && (Q == 1)){
                path = "/ImagePackage/C1S0R1Q1.jpg";
                Q = 0;
                remembered = true;
            }
            else if(!S.isSelected() && R.isSelected() && (Q == 0)){
                path = "/ImagePackage/C1S0R1Q0.jpg";
                Q = 0;
                remembered = true;
            }
            else if(!S.isSelected() && !R.isSelected() && (Q == 1)){
                path = "/ImagePackage/C1S0R0Q1.jpg";
                Q = 1;
                remembered = true;
            }
            else if(!S.isSelected() && !R.isSelected() && (Q == 0)){
                path = "/ImagePackage/C1S0R0Q0.jpg";
                Q = 0;
                remembered = true;
            }
            else if(S.isSelected() && R.isSelected()){
                textArea.setText("Не определено");
                path = "/ImagePackage/C0S0R0Q0.jpg";
                Q = 0;
                remembered = false;
            }
        }else{
            if (!remembered){
                path = "/ImagePackage/C0S0R0Q0.jpg";
            }else if (S.isSelected() && R.isSelected()){
                path = "/ImagePackage/C0S0R0Q0.jpg";
                Q = 0;
                remembered = false;
            }
            else if(Q == 1){
                path = "/ImagePackage/C0SXRXQ1.jpg";
            }else if (Q == 0){
                path = "/ImagePackage/C0SXRXQ0.jpg";
            }

        }

        InputStream input = clazz.getResourceAsStream(path);
        Image image = new Image(input);
        imageView.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button.setStyle("-fx-font: 16 arial; -fx-base: black;");
        textArea.setStyle("-fx-background-color: black; -fx-font: 16 arial;");
        C.setStyle("-fx-font: 16 arial;");
        S.setStyle("-fx-font: 16 arial;");
        R.setStyle("-fx-font: 16 arial;");
        textArea2.setStyle("-fx-background-color: black; -fx-font: 14 arial;");
        textArea2.setText("В данной работе представлена визуализация синхронного RS-триггера." +
                "\nДля запуска нажмите кнопку 'Start'. " +
                "\nДля изменения состояния триггера переключите входные сигналы C, S или R.");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button.setText("Started");
            }
        });
        InputStream input = clazz.getResourceAsStream("/ImagePackage/C0S0R0Q0.jpg");
        Image image = new Image(input);
        imageView.setImage(image);
    }
}

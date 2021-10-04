/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t01a03_1_iu_innerclass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static javafx.scene.shape.StrokeType.CENTERED;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author jose
 */
public class T01A03_1_IU_InnerClass extends Application {
    
    // Atributos
    Circle circulo = new Circle(540, 400, 200);
    StackPane canvas = new StackPane();
    
    @Override
    public void start(Stage primaryStage) {
       
        GridPane botonera = new GridPane();
        botonera.setHgap(5.0);
        botonera.setVgap(5.0);
        botonera.setAlignment(Pos.CENTER);
        botonera.setPadding(new Insets(15.0));
        
        circulo.setStroke(Color.BLACK);
        circulo.setStrokeType(CENTERED);
        circulo.setStrokeWidth(5.0);
        circulo.setFill(Color.rgb(0, 0, 0, 0));
        canvas.getChildren().add(circulo);
        
        Button btnMas = new Button("Aumentar");
        btnMas.setOnAction(new ManejadorHandler());
        btnMas.setPadding(new Insets(10.0));
        btnMas.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.ITALIC, 20));
        Button btnMenos = new Button("Reducir");
        btnMenos.setOnAction(new ManejadorHandler());
        btnMenos.setPadding(new Insets(10.0));
        btnMenos.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.ITALIC, 20));
        botonera.add(btnMas, 0, 0);
        botonera.add(btnMenos, 1, 0);
        
        VBox root = new VBox(canvas, botonera);
        root.setSpacing(5.0);
        root.setPadding(new Insets(5.0));
        Scene scene = new Scene(root, 1080, 800);
        canvas.setPrefSize(scene.getWidth(), scene.getHeight() - botonera.getHeight());
        
        primaryStage.setTitle("T0A03_1_InnerClass");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class ManejadorHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            String target = e.getTarget().toString();
           
            if(target.contains("Aumentar"))
                circulo.setRadius(circulo.getRadius() * 1.05);
            else
                circulo.setRadius(circulo.getRadius() * 0.95);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.*;
import java.io.*;
import java.util.*;

public class Main extends Application {

    private Label label1;
    private Label label2;
    private Label resultLabel;
    
    private TextField textField;
    private Button chooseFileButton;

    private VBox vBox;

    String[] keywordString = {"abstract", "assert", "boolean",
                                "break", "byte", "case", "catch", "char", "class", "const",
                                "continue", "default", "do", "double", "else", "enum",
                                "extends", "for", "final", "finally", "float", "goto",
                                "if", "implements", "import", "instanceof", "int",
                                "interface", "long", "native", "new", "package", "private",
                                "protected", "public", "return", "short", "static",
                                "strictfp", "super", "switch", "synchronized", "this",
                                "throw", "throws", "transient", "try", "void", "volatile",
                                "while", "true", "false", "null"};

    ArrayList<String> kwList = new ArrayList<>(Arrays.asList(keywordString));
    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));

    @Override
    public void init() {
        label1 = new Label("KEYWORD COUNT");
        label2 = new Label("Enter a Java keyword:");
        resultLabel = new Label("Result:");

        textField = new TextField();

        chooseFileButton = new Button("Search a keyword from file:");

        vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label1, label2, textField, chooseFileButton, resultLabel);
    }

    public void countKeywords(File javaFile) {
        Scanner fin = null;
        try {
            fin = new Scanner(javaFile);
        } catch (FileNotFoundException exc) {
            resultLabel.setText("The file is not found.");
        }

        String searchKeyword = textField.getText();
        int totalCounter = 0;
        int searchCounter = 0;
        while (fin.hasNext()) {
            String nextToken = fin.next();
            if (keywordSet.contains(nextToken)) {
                totalCounter++;
            }
            if (nextToken.equals(searchKeyword)) {
                searchCounter++;
            }
        }

        resultLabel.setText(String.format("Number of keywords in file: %d\nNumber of keyword \"%s\": %d", totalCounter, searchKeyword, searchCounter));
    }

    @Override
    public void start(Stage primaryStage) {

        chooseFileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Java File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Java Files", "*.java")
                    );
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            
            if (selectedFile == null) {
                resultLabel.setText("Something is wrong with the file.");
                return;
            }

            countKeywords(selectedFile);
        });

        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setTitle("Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

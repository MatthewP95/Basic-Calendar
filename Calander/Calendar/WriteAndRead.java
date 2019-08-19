package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class WriteAndRead {
  
  //constructor
  WriteAndRead(ToggleButton days, DayOfWeek dayofWeek, int daynumber) {
    days.setOnAction(event -> {

      Group root = new Group();

      TextArea ta = new TextArea();
      Button buttonSave = new Button("Save");

      Stage stage = new Stage();

      File file = new File("events.txt");

      if (file != null) {
        try {
          OpenFile(ta, file);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }

      writeToFile(buttonSave, stage, ta);

      VBox vBox = new VBox();
      vBox.getChildren().addAll(ta, buttonSave);

      root.getChildren().add(vBox);

      stage.setTitle("Events For Today: ");
      stage.setScene(new Scene(root, 450, 500));
      stage.show();
    });
  }

  private Button writeToFile(Button save, Stage stage, TextArea ta) {
    save.setOnAction(event2 -> {
      FileChooser fileChooser = new FileChooser();

      // Set extension filter
      FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
      fileChooser.setInitialDirectory(new File("C:\\Users\\gce\\Documents"));
      fileChooser.setInitialFileName("events");
      fileChooser.getExtensionFilters().add(extFilter);

      // Show save file dialog
      File file = fileChooser.showSaveDialog(stage);

      if (file != null) {
        SaveFile(ta.getText(), file);
      }
    });
    return save;
  }

  //opens file, displays in text area
  private void OpenFile(TextArea ta, File file) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\gce\\Documents\\events.txt")))) {

      String line;
      while ((line = reader.readLine()) != null)
        ta.appendText(line);

    } catch (IOException e) {
      // TODO Auto-generated catch block
      System.out.println("No events file found... Created events.txt in My Documents.");     
     
      File create = new File("C:\\Users\\gce\\Documents\\events.txt");   
      
      create.createNewFile(); 
      
     
    }
  }

  // save to file
  private void SaveFile(String content, File file) {

    try {
      FileWriter fileWriter;

      fileWriter = new FileWriter(file);
      fileWriter.write(content);
      fileWriter.close();
    } catch (IOException ex) {
      Logger.getLogger(CalendarFrame.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}

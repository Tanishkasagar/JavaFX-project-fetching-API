package com.example.fassignment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.List;

public class DogInfoController {
    @FXML
    private TextField dogBreedField;

    @FXML
    private Label dogInfoLabel;

    @FXML
    private void initialize()
    {
        dogInfoLabel.setVisible(false);
    }
    @FXML
    private void onSearchButtonClick(ActionEvent event) {
        String dogBreedName = dogBreedField.getText().trim();
        if (!dogBreedName.isEmpty()) {
            try {
                List<DogInfo> dogInfos = HttpHelpRequester.getDogBreedInfo(dogBreedName);
                if (!dogInfos.isEmpty()) {
                    dogInfoLabel.setVisible(true);
                    DogInfo dogInfo = dogInfos.get(0);
                    dogInfoLabel.setText("Name: " + dogInfo.getName() + "\n"
                            + "Energy: " + dogInfo.getEnergy() + "\n"
                            + "Image link: " + dogInfo.getImage() + "\n"
                            + "Playfulness: " + dogInfo.getPlayfulness() + "\n"
                            + "Grooming: " + dogInfo.getGrooming());
                } else {
                    dogInfoLabel.setText("Dog breed information not found.");
                }
            } catch (InterruptedException e) {
                dogInfoLabel.setText("Error fetching dog breed information.");
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            dogInfoLabel.setText("Please enter a dog breed name.");
        }
    }
}

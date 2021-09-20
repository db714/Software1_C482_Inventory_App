package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;

public class Modify_Product {

    Stage stage;
    Parent scene;

    @FXML
    private TextField modProIDTxt;

    @FXML
    private TextField modProNameTxt;

    @FXML
    private TextField modProInvTxt;

    @FXML
    private TextField modProPriceTxt;

    @FXML
    private TextField modProMinTxt;

    @FXML
    private TextField modProMaxTxt;

    @FXML
    private TextField modProSearchTxt;

    @FXML
    private Button modProAddBut;

    @FXML
    private Button modProRmvBut;

    @FXML
    private Button modProCnclBut;

    @FXML
    private Button modProSaveBut;

    @FXML
    private TableView<Part> modProSlctTable;

    @FXML
    private TableColumn<Part, Integer> modProSlctPartIDCol;

    @FXML
    private TableColumn<Part, String> modProSlctPartNameCol;

    @FXML
    private TableColumn<Part, Integer> modProSlctPartInvCol;

    @FXML
    private TableColumn<Part, Double> modProSlctPartPriceCol;

    @FXML
    private TableView<Part> modProdAssPTable;

    @FXML
    private TableColumn<Part, Integer> modProdAssPIDCol;

    @FXML
    private TableColumn<Part, String> modProdAssPNameCol;

    @FXML
    private TableColumn<Part, Integer> modProdAssPInvCol;

    @FXML
    private TableColumn<Part, Double> modProdAssPPrideCol;

    @FXML
    void onActionModProAdd(ActionEvent event) {
//TODO changed the class to an instance operation
        Product product = null;
        product.addAssPart(modProSlctTable.getSelectionModel().getSelectedItem());



    }

    @FXML
    void onActionModProCncl(javafx.event.ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        //telling program where we want it to go once button is clicked
        scene = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
        //program makes new scene
        stage.setScene(new Scene((Parent) scene));
        //new scene starts
        stage.show();

    }

    @FXML
    void onActionModProID(ActionEvent event) {

    }

    @FXML
    void onActionModProInv(ActionEvent event) {

    }

    @FXML
    void onActionModProMax(ActionEvent event) {

    }

    @FXML
    void onActionModProMin(ActionEvent event) {

    }

    @FXML
    void onActionModProName(ActionEvent event) {

    }

    @FXML
    void onActionModProPrice(ActionEvent event) {

    }

    @FXML
    void onActionModProRmv(ActionEvent event) {

    }

    @FXML
    void onActionModProSave(javafx.event.ActionEvent actionEvent) throws IOException {

        try {
            //Parses the text fields and converts them to the appropriate primitive
            int id = Integer.parseInt(modProIDTxt.getText());
            String name = modProNameTxt.getText();
            int stock = Integer.parseInt(modProInvTxt.getText());
            double price = Double.parseDouble(modProPriceTxt.getText());
            int min = Integer.parseInt(modProMinTxt.getText());
            int max = Integer.parseInt(modProMaxTxt.getText());

            //To make it easier, make variable names above match the object variable names
            Inventory.updateProduct(id, new Product(id, name, stock, price, min, max));


            //Inventory.addProduct(new Product(id, name, stock, price, min, max));

            //----This block of code takes you back to main after you input new object----
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            //telling program where we want it to go once button is clicked
            scene = FXMLLoader.load(getClass().getResource("/view/Main_Screen.fxml"));
            //program makes new scene
            stage.setScene(new Scene((Parent) scene));
            //new scene starts
            stage.show();
        }

        catch(NumberFormatException numEx) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error Dialog");
            error.setContentText("Please enter valid values in text fields");
            error.showAndWait();
        }



    }

    @FXML
    void onActionModProSearch(ActionEvent event) {

    }

    public void receiveProduct(Product product){
        //Getting different value getters and placing them inside text fields (sometimes converting ints to strings)
        modProIDTxt.setText(String.valueOf(product.getId()));
        modProNameTxt.setText(product.getName());
        modProInvTxt.setText(String.valueOf(product.getStock()));
        modProPriceTxt.setText(String.valueOf(product.getPrice()));
        modProMaxTxt.setText(String.valueOf(product.getMax()));
        modProMinTxt.setText(String.valueOf(product.getMin()));
    }

    public void receiveTable(){
        modProSlctTable.setItems(Inventory.getAllParts());

        modProSlctPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProSlctPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProSlctPartInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProSlctPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void receiveModSlctTable(){
        //TODO changed the class to an instance operation

        modProdAssPTable.setItems(Product.getAssParts());

        modProdAssPIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        modProdAssPNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        modProdAssPInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modProdAssPPrideCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /*public void update(int id ,Product product){
        System.out.println("Id is equal to "+ id);
        int index = -1;

        for( Product x : Inventory.getAllProducts()){
                index++;

                if(x.getId() == id){
                    product = x;
                    Inventory.getAllProducts().set(index, product);
                            return;
                }
        }


        *//*for(int i = -1; i < Inventory.getAllProducts().size(); i++){
            //Inventory.getAllProducts();
            System.out.println("this array was checked");
            if(product.getId() == id){
                Inventory.getAllProducts().set(i, product);
                System.out.println("this is true");
                return true;

        }*//*

    }*/
}



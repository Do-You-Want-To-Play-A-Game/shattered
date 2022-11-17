module com.dywtpag.shattered {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.dywtpag.shattered to javafx.fxml;
	exports com.dywtpag.shattered;
}
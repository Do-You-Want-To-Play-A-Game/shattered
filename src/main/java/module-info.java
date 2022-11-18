module com.dywtpag.shattered {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;


	opens com.dywtpag.shattered to javafx.fxml;
	exports com.dywtpag.shattered;
}
module com.dywtpag.shattered {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.swing;


	opens com.dywtpag.shattered to javafx.fxml;
	exports com.dywtpag.shattered;
}
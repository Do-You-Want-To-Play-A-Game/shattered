module com.dywtpag.shattered {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.swing;
    requires java.net.http;
    requires s3.client;


    opens com.dywtpag.shattered to javafx.fxml;
	exports com.dywtpag.shattered;
	exports com.dywtpag.shattered.puzzle;
}
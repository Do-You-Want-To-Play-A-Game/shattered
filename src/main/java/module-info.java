module com.dywtpag.shattered {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.swing;
    requires java.net.http;
	requires software.amazon.awssdk.services.s3;
	requires software.amazon.awssdk.regions;

    opens com.dywtpag.shattered to javafx.fxml;
	exports com.dywtpag.shattered;
	exports com.dywtpag.shattered.puzzle;
}
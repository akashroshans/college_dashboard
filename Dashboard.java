import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Dashboard extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("College Automation | Student Dashboard");

        // Main layout
        BorderPane root = new BorderPane();

        // Top Menu Bar
        MenuBar menuBar = new MenuBar();
        Menu homeMenu = new Menu("Home");
        Menu innovationMenu = new Menu("Innovation & Startup");
        Menu iqacMenu = new Menu("IQAC");
        Menu nirfMenu = new Menu("NIRF");
        Menu skillMenu = new Menu("Skill Development Program");
        Menu alumniMenu = new Menu("Alumni");
        Menu grievanceMenu = new Menu("Grievance");
        Menu contactMenu = new Menu("Contact Us");
        menuBar.getMenus().addAll(homeMenu, innovationMenu, iqacMenu, nirfMenu, skillMenu, alumniMenu, grievanceMenu, contactMenu);
        root.setTop(menuBar);

        HBox header = createHeader();
        root.setTop(new VBox(menuBar, header));

        VBox sidebar = createSidebar();
        root.setLeft(sidebar);

        VBox dashboard = createDashboardContent();
        root.setCenter(dashboard);

        HBox footer = createFooter();
        root.setBottom(footer);

        Scene scene = new Scene(root, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(20));
        header.setSpacing(10);
        header.setStyle("-fx-background-color: #059cfa;");
        Label emptyLabel = new Label(" "); 
        Label logoPlaceholder = new Label("St. Xavier's Catholic College of Engineering");
        logoPlaceholder.setFont(Font.font("Arial", 24));
        logoPlaceholder.setTextFill(Color.WHITE);
        HBox.setHgrow(logoPlaceholder, Priority.ALWAYS);
        logoPlaceholder.setAlignment(Pos.CENTER_RIGHT);
        header.getChildren().addAll(emptyLabel, logoPlaceholder);
        return header;
    }

    private VBox createSidebar() {
        VBox sidebar = new VBox();
        sidebar.setStyle("-fx-background-color: #d5dee3;");
        sidebar.setPrefWidth(250);
        sidebar.setPadding(new Insets(20, 10, 10, 10));
        sidebar.setSpacing(15);

        Button homeButton = createSidebarButton("Home");
        Button attendanceButton = createSidebarButton("Attendance Details");
        Button resultButton = createSidebarButton("Student Details");
        Button leaveButton = createSidebarButton("Faculty Details");
        Button feedbackButton = createSidebarButton("Discipline Details");
        Button feesButton = createSidebarButton("Fees Balance");
        Button eventsButton = createSidebarButton("College Events");
        Button internalMarksButton = createSidebarButton("Internal Marks");
        Button endSemesterButton = createSidebarButton("End Semester Marks");

        sidebar.getChildren().addAll(
            homeButton, attendanceButton, resultButton, leaveButton, feedbackButton,
            feesButton, eventsButton, internalMarksButton, endSemesterButton
        );
        return sidebar;
    }

    private Button createSidebarButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setStyle("-fx-background-color: #059cfa; -fx-text-fill: white;");
        button.setFont(new Font(20));
        return button;
    }

    private VBox createDashboardContent() {
        VBox dashboard = new VBox();
        dashboard.setPadding(new Insets(20));
        dashboard.setSpacing(20);
        dashboard.setStyle("-fx-background-color: #f8f8f8;");

        Label imagePlaceholder = new Label("College Image");
        imagePlaceholder.setFont(Font.font("Arial", 24));
        imagePlaceholder.setTextFill(Color.GRAY);
        imagePlaceholder.setAlignment(Pos.CENTER);
        imagePlaceholder.setPrefHeight(250);

        Label announcementsLabel = new Label("College Announcements");
        announcementsLabel.setFont(Font.font("Arial",20));
        announcementsLabel.setTextFill(Color.DARKBLUE);

        Label announcementContent = new Label("Announcements will be displayed here...");
        announcementContent.setFont(Font.font("Arial", 14));
        announcementContent.setWrapText(true);

        dashboard.getChildren().addAll(imagePlaceholder, announcementsLabel, announcementContent);
        return dashboard;
    }

    private HBox createFooter() {
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        footer.setStyle("-fx-background-color: #f8f8f8;");

        Label footerLabel = new Label("St. Xavier's Catholic College of Engineering © 2024");
        footerLabel.setFont(Font.font("Arial", 12));
        footerLabel.setTextFill(Color.GRAY);

        footer.getChildren().add(footerLabel);
        return footer;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

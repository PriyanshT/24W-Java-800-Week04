module org.georgiancollege.week04 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.georgiancollege.week04 to javafx.fxml;
    exports org.georgiancollege.week04;
}
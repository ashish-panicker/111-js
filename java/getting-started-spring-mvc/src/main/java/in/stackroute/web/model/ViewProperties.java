package in.stackroute.web.model;

import org.springframework.stereotype.Component;

@Component
public class ViewProperties {

    private String title;

    private String message;

    public ViewProperties() {}

    public ViewProperties(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

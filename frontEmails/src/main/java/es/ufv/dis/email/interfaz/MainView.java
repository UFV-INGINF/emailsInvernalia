package es.ufv.dis.email.interfaz;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import es.ufv.dis.email.model.Email;
import es.ufv.dis.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route(value = "")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired EmailService service) {




        Grid<Email> grid = new Grid<>(Email.class, false);
        grid.setWidth("100%");
        grid.setWidthFull();
//        grid.setHeightByRows(true);
        grid.addColumn(Email::getTo).setHeader("To");
        grid.addColumn(Email::getSubject).setHeader("Subject");
        grid.addColumn(Email::getText).setHeader("Text");
        grid.addColumn(Email::getHtml).setHeader("Html");

        List<Email> people = service.getEmails();
        grid.setItems(people);

        addClassName("centered-content");

        add(grid);
    }
}

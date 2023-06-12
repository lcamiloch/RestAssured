package cl.cenco.qa.task;

import cl.cenco.qa.models.UsersModel;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUserTask implements Task {

    private final String tittle;
    private final String body;
    private final int userId;
    private final String complementPath;

    public CreateUserTask(String tittle, String body, int userId, String complementPath) {
        this.tittle = tittle;
        this.body = body;
        this.userId = userId;
        this.complementPath = complementPath;
    }

    public static Performable withInfo(String tittle, String body, int userId, String complementPath){
        return instrumented(CreateUserTask.class, tittle, body, userId, complementPath);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        UsersModel usersModel = new UsersModel();
        usersModel.setTitle(tittle);
        usersModel.setBody(body);
        usersModel.setUserId(userId);

        actor.attemptsTo(
                Post.to(complementPath).with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body(usersModel))
        );
    }
}

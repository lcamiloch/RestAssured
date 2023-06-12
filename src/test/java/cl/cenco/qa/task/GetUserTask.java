package cl.cenco.qa.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class GetUserTask implements Task {

    private final int id;
    private final String complementPath;

    public GetUserTask(String complementPath, int userId){
        this.id = userId;
        this.complementPath = complementPath;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(complementPath + id)
        );
    }
}

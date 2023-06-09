package cl.cenco.qa.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class Hooks {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }
}

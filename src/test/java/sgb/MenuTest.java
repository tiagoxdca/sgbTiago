package sgb;

import domain.Menu;
import org.junit.Assert;
import org.junit.Test;

public class MenuTest {



    @Test
    public void chooseNumberFromFirstMenu(){

        //Menu.presentFirstMenu();
        int numero = 7;
        Assert.assertEquals(8,numero);

    }
}

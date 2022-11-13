package testCases;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.Payload;

public class Test02WicketKeeper {

    @Test
    public void wicketKeeper() {

        System.out.println("Validating that there is at least one wicket keeper");

        JsonPath js = new JsonPath(Payload.players());

        int countPlayers = js.getInt("player.size()");
        System.out.println("Total Players: " + countPlayers);

        int countWicketKeeper = 0;

        for(int i =0; i<countPlayers; i++)
        {
            String playerRole = js.getString("player["+i+"].role");

            if(playerRole.equalsIgnoreCase("Wicket-keeper"))
            {
                countWicketKeeper++;
                break;
            }
        }
        System.out.println("Wicket-keeper: "+ countWicketKeeper);

        Assert.assertEquals(countWicketKeeper, 1);

    }


}

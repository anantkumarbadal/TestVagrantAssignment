package testCases;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.Payload;

public class Test01ForeignPlayers {

    @Test
    public void validateForeignPlayer() {

        System.out.println("Validating that the team has only 4 foreign players");

        JsonPath js = new JsonPath(Payload.players());

        int countPlayers = js.getInt("player.size()");
        System.out.println("Total Players: " + countPlayers);

        int countForeignPlayers = 0;

        for(int i=0; i<countPlayers; i++)
        {
            String country = js.getString("player["+i+"].country");

            if(!country.equalsIgnoreCase("India"))
            {
                countForeignPlayers++;
            }

        }
        System.out.println("Foreign Players: "+ countForeignPlayers);

        Assert.assertEquals(countForeignPlayers, 4);

    }

}

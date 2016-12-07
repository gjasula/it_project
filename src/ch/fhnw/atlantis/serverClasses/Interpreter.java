package ch.fhnw.atlantis.serverClasses;

/**
 * Created by Richard on 06/12/2016.
 */
public class Interpreter {

    public void interpretServerMsg(String messagefromClient){

        String monthString;

        switch (messagefromClient) {
            case "Monday":
                monthString = "[Monday] specific output from client to server interpreter";
                System.out.println(monthString);
                break;
            default:
                monthString = "Default output from client to server interpreter";
                System.out.println(monthString);
        }

    }

}

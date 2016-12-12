package ch.fhnw.atlantis.clientClasses.GUI;

/**
 * Created by Richard on 10/12/2016.
 */
public class Interpreter {

    public String interpretClientMsg(String messagefromServer){

        String monthString;

        switch (messagefromServer) {
            case "Monday":
                monthString = "[Monday] specific output from client to server interpreter";
                System.out.println(monthString);
                break;
            default:
                monthString = "Default output from client to server interpreter";
                System.out.println(monthString);
        }
        return monthString;
    }

}

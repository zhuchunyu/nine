package actors;

import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloActor extends UntypedActor {

    public static Props props = Props.create(HelloActor.class);

    public void onReceive(Object message) throws Exception {
        sender().tell("actor:"+message, self());
    }
}

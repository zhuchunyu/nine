import actors.HelloActor;
import play.*;
import play.libs.Akka;
import play.mvc.Action;
import play.mvc.Http.Request;
import java.lang.reflect.Method;

public class Global extends GlobalSettings {

    public Action onRequest(Request request, Method actionMethod) {
        //System.out.println("before each request..." + request.toString());
        return super.onRequest(request, actionMethod);
    }

    public void onStart(Application app) {
        Akka.system().actorOf(HelloActor.props, "actor");
        Logger.info("Application has started");
    }

    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }
}


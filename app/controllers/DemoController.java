package controllers;

import akka.actor.ActorRef;
import com.fasterxml.jackson.databind.node.ObjectNode;
import filters.VerboseAction;
import play.cache.Cached;
import play.libs.Akka;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.index;

import static akka.pattern.Patterns.ask;

/**
 * Demo 控制器
 */
public class DemoController extends Controller {

    @Cached(key = "homePage")
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    @With(VerboseAction.class)
    public static Result json() {
        ObjectNode result = Json.newObject();
        result.put("name", "foobar");
        result.put("descr", "Hello world!");
        return ok(result);
    }

    public static Result show(Long id) {
        return ok(String.valueOf(id));
    }

    public static Promise<Result> sync() {
        return Promise.promise(() -> ok("sync http"));
    }

    public static Promise<Result> actor(String message) {
        ActorRef helloActor = Akka.system().actorFor("user/actor");
        return Promise.wrap(ask(helloActor, message, 1000))
                .map(response -> ok((String) response));
    }

    public static Result notfound() {
        return notFound(index.render("notFound"));
    }
}

package controllers;

import akka.actor.ActorRef;
import com.alibaba.fastjson.JSON;
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
import views.html.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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

    public static Promise<Result> syncmap() {
        return Promise.promise(() -> "helloasync").map(res -> ok((String) res));
    }

    public static Promise<Result> actor(String message) {
        ActorRef helloActor = Akka.system().actorFor("user/actor");
        return Promise.wrap(ask(helloActor, message, 1000))
                .map(response -> ok((String) response));
    }

    public static Promise<Result> blogActor(Long id) {
        ActorRef blogActor = Akka.system().actorFor("user/blog");
        return Promise.wrap(ask(blogActor, id, 1000))
                .map(response -> { System.out.println(JSON.toJSON(response)); return ok(Json.toJson(response));});
    }

    public static Result notfound() {
        return notFound(index.render("notFound"));
    }

    public static Result upload() {
        return ok(upload.render("File Upload!"));
    }

    public static Result doUpload() throws Exception {

        play.mvc.Http.MultipartFormData body = request().body().asMultipartFormData();
        play.mvc.Http.MultipartFormData.FilePart picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            System.out.println(fileName);
            String contentType = picture.getContentType();
            System.out.println(contentType);
            java.io.File file = picture.getFile();
            System.out.println(file.length());
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("E:/file/play/"+fileName));
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[4096];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            in.close();
            out.close();
            return ok(upload.render("Do Upload Finished!"));
        } else {
            flash("error", "Missing file");
            return badRequest(upload.render("Not Found Upload File!"));
        }
    }
}

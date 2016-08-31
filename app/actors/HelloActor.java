package actors;

import akka.actor.Props;
import akka.actor.UntypedActor;
import com.alibaba.fastjson.JSON;
import com.avaje.ebean.Ebean;
import models.Blog;

public class HelloActor extends UntypedActor {

    public static Props props = Props.create(HelloActor.class);

    public void onReceive(Object message) throws Exception {
        Blog blog = Ebean.find(Blog.class, 1);
        System.out.println(JSON.toJSON(blog));
        sender().tell("actor:"+message, self());
    }
}

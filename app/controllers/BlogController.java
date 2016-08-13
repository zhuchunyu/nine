package controllers;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import models.Blog;
import play.cache.Cached;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Date;
import java.util.List;

public class BlogController extends Controller {

    public static Result index() {
        return ok(views.html.blog.index.render("Blog"));
    }

    public static Result post() {
        Blog blog = new Blog();
        blog.name = "Blog";
        blog.passwd = "123456";
        blog.registerTime = new Date();
        blog.done = true;
        Ebean.save(blog);
        return ok(Json.toJson(blog));
    }

    public static Result show(Long id) {
        Blog blog = Ebean.find(Blog.class, id);
        return ok(Json.toJson(blog));
    }

    @Cached(key = "shows")
    public static Result shows() {
        List<Blog> blogs = Ebean.find(Blog.class).findList();
        return ok(Json.toJson(blogs));
    }

    public static Result sql(Long id) {
        SqlQuery sqlQuery = Ebean.createSqlQuery("select * from blog where id>=?");
        sqlQuery.setParameter(1, id);
        return ok(Json.toJson(sqlQuery.findList()));
    }
}

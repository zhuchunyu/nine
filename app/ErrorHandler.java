import play.http.HttpErrorHandler;
import play.mvc.*;
import play.mvc.Http.*;
import play.libs.F.*;

public class ErrorHandler implements HttpErrorHandler {
    public Promise<Result> onClientError(RequestHeader request, int statusCode, String message) {
        return Promise.<Result>pure(
                Results.status(statusCode, "A client error occurred: " + message)
        );
    }

    public Promise<Result> onServerError(RequestHeader request, Throwable exception) {
        return Promise.<Result>pure(
                Results.internalServerError("A server error occurred: " + exception.getMessage())
        );
    }
}
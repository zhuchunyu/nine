package filters;

import play.Logger;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;

/**
 * Demo拦截器
 */
public class VerboseAction extends play.mvc.Action.Simple {
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        Logger.info("Calling action for " + ctx);
        return delegate.call(ctx);
    }
}

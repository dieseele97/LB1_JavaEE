package ejbpackage;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Singleton
@LocalBean
@WebListener
public class HttpSessionManager implements HttpSessionListener {
    private static int counter = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        counter++;
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        counter--;
    }

    public static int getActiveSessionsCount() {
        return counter;
    }

}


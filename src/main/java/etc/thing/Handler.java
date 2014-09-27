package etc.thing;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Created by baris on 27/09/2014.
 */
public class Handler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        System.out.println("Dummy handling of url " + u);
        return null;
    }
}

package etc.thing;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by baris on 27/09/2014.
 */
public class OhDear {

    public static void main(String[] args) throws MalformedURLException {
        System.setProperty("java.protocol.handler.pkgs", "etc");

        URL u = new URL("thing:foo");
    }
}

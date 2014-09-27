import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import static org.junit.Assert.*;

public class TestClasspath {

    @Test
    public void test() throws IOException {

        System.out.println("java.class.path: \n  " +
                System.getProperty("java.class.path").replace(";","\n  "));

        assertNull(ClassLoader.class.getClassLoader());

        // ClassLoader.class's class loader is 'null'
        // according to the getResource docs, this means it will delegate
        // to the system class loader to actually load the resource

        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println("System class loader: " + cl.getClass().toString());
        URL[] urls = ((URLClassLoader)cl).getURLs();
        System.out.println("System class loader classpath:");
        for(URL url: urls){
            System.out.println("  " + url.getFile());
        }
        System.out.println("------------------------------");

        cl = TestClasspath.class.getClassLoader();
        System.out.println("TestClasspath's class loader: " + cl.getClass().toString());
        urls = ((URLClassLoader)cl).getURLs();
        System.out.println("TestClasspath's class loader's classpath:");
        for(URL url: urls){
            System.out.println("  " + url.getFile());
        }
        System.out.println("------------------------------");

        assertNotNull(TestClasspath.class.getResource("/resource.txt"));

        //fails, but only if dynamic.classpath=true
        assertNotNull(ClassLoader.class.getResource("/resource.txt"));
    }
}

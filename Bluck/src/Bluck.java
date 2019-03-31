import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

import parcs.*;

public class Bluck {
    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("DFS.jar");
        Node n = new Node(0, 0, 1, 1, 1);

        AMInfo info = new AMInfo(curtask, null);
        point p = info.createPoint();
        channel c = p.createChannel();
        p.execute("DFS");
        c.write(n);

        System.out.println("Waiting for result...");
        System.out.println("Result: " + c.readLong());
        curtask.end();
    }

}

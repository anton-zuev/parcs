import java.util.List;
import java.util.ArrayList;

import parcs.*;

public class DFS implements AM {
    public void run(AMInfo info) {
        Node n = (Node) info.parent.readObject();
        //  System.out.println("[" + n.getId() + "] Build started.");

        List<point> points = new ArrayList<>();
        List<channel> chans = new ArrayList<>();

        if (n.yl + n.yr > n.MAX_DEPTH) {
            System.out.println("Bad thread,return " + n.getId() + "] Build started.");
            info.parent.write(new Long(0));
            return;
        }
        System.out.println("Generated " + (n.xl + n.xr) + "/" + (n.yl + n.yr) + " ");
        Node leftsearch = new Node(2 * n.getId(), n.xl, n.yl, n.xl + n.xr, n.yl + n.yr);
        Node rightsearch = new Node(2 * n.getId() + 1, n.xl + n.xr, n.yl + n.yr, n.xr, n.yr);

        point p1 = info.createPoint();
        channel c1 = p1.createChannel();
        p1.execute("DFS");
        c1.write(leftsearch);

        point p2 = info.createPoint();
        channel c2 = p2.createChannel();
        p2.execute("DFS");
        c2.write(rightsearch);


        long res = 1;
        long sum = n.getTime();


        res += c1.readLong() + c2.readLong();

        try {
            Thread.sleep(n.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("[" + n.getId() + "] Finished.");
        info.parent.write(res);
    }
}

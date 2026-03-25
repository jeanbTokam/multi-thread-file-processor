import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ReportWriter {

    public static void write(ConcurrentHashMap<String, LongAdder> counts) throws Exception {

        List<Map.Entry<String, LongAdder>> sorted = new ArrayList<>(counts.entrySet());
        sorted.sort((a,b) -> Long.compare(b.getValue().longValue(), a.getValue().longValue()));

        try(PrintWriter writer = new PrintWriter("report.txt")) {
            for(Map.Entry<String, LongAdder> e : sorted) {
                writer.println(e.getKey() + " : " + e.getValue());
            }
        }
    }
}
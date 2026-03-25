import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class FileConsumer implements Runnable {

        private BlockingQueue<Path> queue;
        private ResultAggregator aggregator;

        public FileConsumer(BlockingQueue<Path> queue, ResultAggregator aggregator) {
            this.queue = queue;
            this.aggregator = aggregator;
        }

        public void run() {

            while(true) {

                try {
                    Path file = queue.poll(5, TimeUnit.SECONDS);
                    if(file == null) break;

                    Map<String,Integer> counts = WordCounter.count(file);
                    aggregator.merge(counts);

                } catch(Exception e) {
                    System.err.println("Bad file skipped");
                }
            }
        }
    }

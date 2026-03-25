import java.nio.file.Path;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {

        String folderPath = args[0];
        int threadCount = 4;

        BlockingQueue<Path> queue = new LinkedBlockingQueue<>();
        ExecutorService pool = Executors.newFixedThreadPool(threadCount);

        ResultAggregator aggregator = new ResultAggregator();

        // Producer
        new Thread(new FileProducer(folderPath, queue)).start();

        // Consumers
        for(int i = 0; i < threadCount; i++) {
            pool.submit(new FileConsumer(queue, aggregator));
        }

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.MINUTES);

        ReportWriter.write(aggregator.getWordCounts());
    }
}

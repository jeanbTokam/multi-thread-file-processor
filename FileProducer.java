import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.concurrent.BlockingQueue;

public class FileProducer implements Runnable{


    private String folder;
    private BlockingQueue<Path> queue;


    public FileProducer(String folder, BlockingQueue<Path> queue) {
        this.folder = folder;
        this.queue = queue;
    }

    public void run(){
        try(DirectoryStream<Path> stream =
                    Files.newDirectoryStream(Paths.get(folder), "*.txt")
                ){
            for(Path file : stream){
                queue.put(file);
            }
        } catch (Exception e){
            System.out.println("Produce error"+ e.getMessage());

        }
    }
}


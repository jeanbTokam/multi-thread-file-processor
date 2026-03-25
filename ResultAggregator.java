import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResultAggregator {

    private ConcurrentHashMap<String,Integer> globalMap = new ConcurrentHashMap<>();

    public void merge(Map<String,Integer> local) {

        local.forEach((word,count) ->
                globalMap.merge(word,count,Integer::sum)
        );
    }

    public Map<String,Integer> getWordCounts() {
        return globalMap;
    }
}
package learn.stream;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Rod ,have fun with coding
 * @date 2021/1/26 20:11
 */
public class StreamFilter {

    /**
     * be more time cost sense for programing
     * @param args
     */
    public static void main(String[] args) {
        List<MockData> mockData = getMockData();
        StopWatch started = StopWatch.createStarted();
        mockData.stream().filter(x -> x.getId()>900000).filter(y -> y.getCategory().equals("B")).collect(Collectors.toList());
        System.out.printf("cost {%d} ms \n",started.getTime(TimeUnit.MILLISECONDS));

        started = StopWatch.createStarted();
        mockData.stream().filter(y -> y.getCategory().equals("B")).filter(x -> x.getId()>900000).collect(Collectors.toList());
        System.out.printf("cost {%d} ms \n",started.getTime(TimeUnit.MILLISECONDS));

        started = StopWatch.createStarted();
        mockData.stream().filter(y -> y.getCategory().equals("B") && y.getId()>900000 ).collect(Collectors.toList());
        System.out.printf("cost {%d} ms \n",started.getTime(TimeUnit.MILLISECONDS));

    }
    private static  List<MockData> getMockData(){
        int size = 5000*1000;
        List<MockData> dataList = new ArrayList<>(size);
        for(int i=0;i<=size;i++){
            String category ="A";
            if (i % 3 == 0){
                category = "B";
            }else if (i % 5 ==0  ){
                category = "C";
            }
            dataList.add(new MockData(i,category));
        }
        return dataList;
    }
}

/**
 * @author Rod ,have fun with coding
 * @date 2021/1/26 20:12
 */
class MockData {

    private int id;
    private String category;

    public MockData(int id , String category){
        this.id = id ;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }
}

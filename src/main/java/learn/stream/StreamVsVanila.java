//package learn.stream;
//
//import javax.jws.WebParam;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author Rod ,have fun with coding
// * @date 2021/1/26 21:19
// */
//@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@BenchmarkMode(WebParam.Mode.AverageTime)
//@OperationsPerInvocation(StreamVsVanilla.N)
//public class StreamVsVanilla {
//    public static final int N = 10000;
//
//    static List<Integer> sourceList = new ArrayList<>();
//    static {
//        for (int i = 0; i < N; i++) {
//            sourceList.add(i);
//        }
//    }
//
//    @Benchmark
//    public List<Double> vanilla() {
//        List<Double> result = new ArrayList<>(sourceList.size() / 2 + 1);
//        for (Integer i : sourceList) {
//            if (i % 2 == 0){
//                result.add(Math.sqrt(i));
//            }
//        }
//        return result;
//    }
//
//    @Benchmark
//    public List<Double> stream() {
//        return sourceList.stream()
//                .filter(i -> i % 2 == 0)
//                .map(Math::sqrt)
//                .collect(Collectors.toCollection(
//                        () -> new ArrayList<>(sourceList.size() / 2 + 1)));
//    }
//}

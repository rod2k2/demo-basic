package redis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class RedisHashTest {

    public static void main(String[] args) throws Exception
            {
        Jedis jedis = new Jedis("localhost", 6379);

        Student s1 = Student.builder().id(1).name("Zhang San").score(90.00f).registerDate(LocalDate.parse("2012-09-01")).build();
        Student s2 = Student.builder().id(2).name("Li Si").score(120.12f).registerDate(LocalDate.parse("2013-09-01")).build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        jedis.hmset("student:" + s1.getId(), mapper.convertValue(s1, HashMap.class));
        jedis.hmset("student:" + s2.getId(), mapper.convertValue(s2, HashMap.class));




        Map<String, String> s1Map = jedis.hgetAll("student:" + s1.getId());
        System.out.println(s1Map);
        Map<String, String> s2Map = jedis.hgetAll("student:" + s2.getId());
        System.out.println(s2Map);

        System.out.println(mapper.convertValue(s1Map, Student.class));
        System.out.println(mapper.convertValue(s2Map, Student.class));


    }
}

@Builder
@AllArgsConstructor
@Data
class Student {

    //have to add it cause redis hash read both key and value as string.
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;
    private String name;
    @JsonSerialize(using = ToStringSerializer.class)
    private float score;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate registerDate;

    public Student() {

    }
}

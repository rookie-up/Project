package com.example.autoconfig.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Java 8 Lambda 实现  {@link CalculateService}
 *
 * @author zhengyumin
 * @create 2019-01-04 8:18 PM
 */
@Profile("Java8")
@Service
public class Java8CalculateService implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        System.err.println("Java 8 Lambda 实现 ");
        return Stream.of(values).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java8CalculateService();
        System.out.println(calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

}
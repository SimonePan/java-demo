package com.example.demo.collection;

import com.example.demo.basic.Animal;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.MDC;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Grace.Pan
 * @date 2019/6/24
 */
@Slf4j
public class StreamTest {

    private List<Animal> animalList;

    @Before
    public void setUp() {
        ArrayList<String> skills = new ArrayList<>();
        skills.add("swim");
        skills.add("run");

        ArrayList<String> skills2 = new ArrayList<>();
        skills2.add("swim");
        skills2.add("sing");

        ArrayList<String> skills3 = new ArrayList<>();
        skills3.add("sing");
        skills3.add("fly");

        ArrayList<String> skills4 = new ArrayList<>();
        skills3.add("sing");
        skills3.add("fly");

        Animal animal = new Animal("dog", true, skills);
        Animal animal2 = new Animal("fish", false, skills2);
        Animal animal3 = new Animal("bird", true, skills3);
        Animal animal4 = new Animal("bird2", false, skills3);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);
        this.animalList = animals;
    }

    @Test
    public void test2Stream() {
        long start = System.currentTimeMillis();
        log.info("--start-" + start);
        animalList.stream().forEach(animal -> animal.setSkill(animal.getSkill().stream().map(this::getName).collect(Collectors
                .toList())));
        log.info("--cost-" + (System.currentTimeMillis() - start));
        animalList.stream().forEach(animal -> animal.getSkill().stream().forEach(System.out::println));
    }

    @Test
    public void test2StreamParallel() {
        MDC.put("locale", "zh_CN");
        long start = System.currentTimeMillis();
        log.info("--start-" + start);
        animalList.stream().parallel().forEach(animal -> animal.setSkill(animal.getSkill().parallelStream()
                .parallel().map
                        (this::getName).collect
                        (Collectors
                                .toList())));
        log.info("--cost-" + (System.currentTimeMillis() - start));
        animalList.stream().forEach(animal -> animal.getSkill().stream().forEach(System.out::println));
    }

    private String getName(String name) {
        // 线程不安全，只有主线程有locale值，worker线程locale=null。
        String locale = MDC.get("locale");
        if (StringUtils.isEmpty(locale)) {
            System.out.println("----locale=" + locale + "---" + Thread.currentThread().getName());
            return name;
        } else {
            System.out.println("----locale=" + locale + "---" + Thread.currentThread().getName());
        }
        switch (name) {
            case "sing":
                return "唱歌";
            case "swim":
                return "游泳";
            case "dance":
                return "跳舞";
            case "run":
                return "跑步";
            case "fly":
                return "飞";
            default:
                return name;
        }
    }

    @Test
    public void testSorted() {
        animalList.forEach(animal -> System.out.println(animal.getName()));
        System.out.println("-----------------------------------------");
        List<Animal> afterSorted = animalList.stream().sorted((o1, o2) -> {
            Boolean o1AllowBooking = o1.getShow();
            Boolean o2AllowBooking = o2.getShow();
            Boolean o1ContainsLocation = !CollectionUtils.isEmpty(o1.getSkill()) && o1.getSkill().contains("fly");
            Boolean o2ContainsLocation = !CollectionUtils.isEmpty(o2.getSkill()) && o2.getSkill().contains("fly");
            // 可展示
            if (o1AllowBooking ^ o2AllowBooking) {
                return o1AllowBooking ? -1 : 1;
            } else if (o1ContainsLocation ^ o2ContainsLocation) {
                return o1ContainsLocation ? -1 : 1;
            } else {
                return 0;
            }
        }).collect(Collectors.toList());

        afterSorted.forEach(animal -> System.out.println(animal.getName()));
    }

    @Test
    public void testSorted2() {
        animalList.forEach(animal -> System.out.println(animal.getName()));
        System.out.println("-----------------------------------------");
        List<Animal> afterSorted = animalList.stream().sorted((o1, o2) -> {
            Integer score = getScore(o1);
            Integer score2 = getScore(o2);
            System.out.println(o1.getName() + "=" + score + ";" + o2.getName() + "=" + score2 + ";cha=" + (score2 - score));
            return score2 - score;
        }).collect(Collectors.toList());

        afterSorted.forEach(animal -> System.out.println(animal.getName()));
    }

    private Integer getScore(Animal animal) {
        Integer o1Score = 0;
        if (animal.getShow()) {
            o1Score += 2;
        }
        Boolean fly = !CollectionUtils.isEmpty(animal.getSkill()) && animal.getSkill().contains("fly");
        if (fly) {
            o1Score++;
        }
        if (fly && animal.getShow()) {
            o1Score++;
        }
        return o1Score;
    }
}

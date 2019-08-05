package com.example.demo.concurrent;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author Grace.Pan
 * @date 2019/8/5
 */
public class CallableTest {

    public class MyCallable implements Callable<String> {
        @Getter
        @Setter
        private String name;
        @Getter
        @Setter
        private long time;

        public MyCallable(String name,long time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(time);
            System.out.println(name+"end");
            return "return:" + name;
        }
    }

    @Test
    public void testBlock() throws ExecutionException, InterruptedException {
        MyCallable name1 = new MyCallable("name1",10000);
        MyCallable name2 = new MyCallable("name2",0);
        MyCallable name3 = new MyCallable("name3",1000);
        ArrayList<MyCallable> list = new ArrayList<>();
        list.add(name1);
        list.add(name2);
        list.add(name3);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        Future<String> submit = executor.submit(name1);
        Future<String> submit1 = executor.submit(name2);
        Future<String> submit2 = executor.submit(name3);
        System.out.println(submit.get());
        System.out.println(submit1.get());
        System.out.println(submit2.get());
        /**
         * name2end
         name3end
         name1end
         return:name1
         return:name2
         return:name3
         */
    }

    @Test
    public void testBlockNo() throws ExecutionException, InterruptedException {
        Callable name1 = new MyCallable("name1",10000);
        Callable name2 = new MyCallable("name2",0);
        Callable name3 = new MyCallable("name3",1000);
        ArrayList<Callable> list = new ArrayList<>();
        list.add(name1);
        list.add(name2);
        list.add(name3);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        CompletionService<Object> cs = new ExecutorCompletionService<>(executor);
        cs.submit(name1);
         cs.submit(name2);
         cs.submit(name3);
         for (int i=0;i<3;i++){
             System.out.println(cs.take().get());
         }
        /**
         * name2end
         return:name2
         name3end
         return:name3
         name1end
         return:name1
         */
    }
}

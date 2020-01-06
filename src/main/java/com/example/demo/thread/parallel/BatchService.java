package com.example.demo.thread.safe;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2019-12-18 15:11
 */
@Service
public class BatchService {

    @Resource
    private ThreadPoolManager threadPoolManager;

    public void batchImport() {
        // 配置同步执行的最大线程数。
        int bound = 200;
        BoundedExecutor boundedExecutor = new BoundedExecutor(threadPoolManager, bound);
        // 假如DB中有10万条数据要处理导入另一个DB。
        // 根据ID从1开始，每次查询600条数据保存至list。
        Long startId = 1L;
        // 最大的id
        Long maxId = 100000L;
        ArrayList<Data> list = getDataFromDB(startId);
        // 批量处理600条数据。处理时根据配置分批处理。
        while (startId <= maxId) {
            try {
                boundedExecutor.submitTask(() -> list.forEach(o -> System.out.println("处理完成")));
            } catch (InterruptedException e) {
                // 被中断后,恢复中断。
                Thread.currentThread().interrupt();
            }
            startId = list.get(list.size() - 1).getId();
        }

    }

    private ArrayList<Data> getDataFromDB(Long startId) {
        return new ArrayList<>();
    }

    @Getter
    @Setter
    public class Data {
        private Long id;
    }
}

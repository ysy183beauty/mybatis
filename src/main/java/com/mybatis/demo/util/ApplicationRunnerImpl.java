package com.mybatis.demo.util;
import com.mybatis.demo.load.LoadData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
/**
 * 项目启动时候会自动调用的代码
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Autowired
    private LoadData loadData;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //项目刚启动时候需要的代码
        loadData.loadDataInfo();
    }
}

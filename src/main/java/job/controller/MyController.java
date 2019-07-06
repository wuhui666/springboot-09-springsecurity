package job.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import job.mappers.JobMapper;
import job.pojo.Job;
import job.pojo.JobExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wuhui
 * @time: 2019/7/3 18:39
 * @desc:
 */
@Controller
public class MyController {
    @Autowired
    JobMapper jobMapper;
    @RequestMapping("/advice")
    @ResponseBody
    public List<Job> getAdviceList(@RequestBody String data){
        JSONObject jsonObject = (JSONObject) JSON.parse(data);
        System.out.println(jsonObject);
        List<Job> jobs = jobMapper.getAdvice(jsonObject.getString("language"),jsonObject.getString("jobType"));

        return jobs;
    }
    @RequestMapping(value = {"/","/index"})
    public String toIndex(){
        return "index";
    }


}

package com.survey.modules.service;

import com.survey.modules.bean.DataBean;
import com.survey.modules.bean.SeriesBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ChartService {

    public DataBean getChartData() {
        List<SeriesBean> list = new ArrayList<SeriesBean>();
        list.add(new SeriesBean(new double[] {7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3}));
        
        String[] categories = new String[] {"A1", "A2","A3","A4"};
        return new DataBean("chart-container", "Poll Analysis", "answers", "Count", Arrays.asList(categories), list);
    }
}

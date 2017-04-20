/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.resource.media.xml;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class VirtualDatas {
     public  static Hospital hospital;
     static {
         hospital = new Hospital();
         
                 Department da = new Department();
        da.setId(1);
        da.setName("科室A");
        da.setCapacity(10);

        Department db = new Department();
        db.setId(2);
        db.setName("科室B");
        db.setCapacity(15);

        List<Department> departmentList = new ArrayList<Department>();
        departmentList.add(da);
        departmentList.add(db);

       
        hospital.setCode("h_1234");
        hospital.setId(1);
        hospital.setName("南京鼓楼医院");
        hospital.setDepartmentList(departmentList);
     }
}

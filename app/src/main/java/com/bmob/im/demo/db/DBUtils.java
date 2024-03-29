package com.bmob.im.demo.db;

import android.content.Context;
import android.util.Log;

import com.bmob.im.demo.bean.Plan;
import com.bmob.im.demo.util.util.Calculator;
import com.bmob.im.demo.util.util.GetDate;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * ************************************************************
 * *********    User : SuLinger(462679107@qq.com) .
 * *********    Date : 2014-09-10  .
 * *********    Time:  2014-09-10  .
 * *********    Project name :PBOX1.3 .
 * *********    Copyright @ 2014, SuLinger, All Rights Reserved
 * *************************************************************
 */


public class DBUtils {


    private final static String TAG = "DBUtils";
    public static Dao<Plan, Integer> planDao = null;

    public DBUtils(Context context) {
        if (planDao == null) {
            DataHelper dbHelper = new DataHelper(context);
            try {
                planDao = dbHelper.getDao(Plan.class);
            } catch (SQLException e) {
                Log.e(TAG, "得到Dao失败");
                e.printStackTrace();
            }
        }
    }

    public void createPlans(List<Plan> lists) {
        for (Plan plan : lists) {
            try {
                planDao.createOrUpdate(plan);
            } catch (SQLException e) {
                Log.e(TAG, "增加失败");
                e.printStackTrace();
            }
        }
    }

    public void createPlan(Plan plan) {
        try {
            planDao.createOrUpdate(plan);
        } catch (SQLException e) {
            Log.e(TAG, "增加失败");
            e.printStackTrace();
        }
    }

    public void deletePlan(Plan plan) {
        try {
            planDao.delete(plan);
        } catch (SQLException e) {
            Log.e(TAG, "删除失败");
            e.printStackTrace();
        }
    }

    public void deletePlanById(int id) {
        try {
            planDao.deleteById(id);
        } catch (SQLException e) {
            Log.e(TAG, "删除失败");
            e.printStackTrace();
        }
    }

    public List<Plan> getPlans() {
        List<Plan> plans = new ArrayList<Plan>();
        try {
            plans = planDao.queryForAll();
        } catch (SQLException e) {
            Log.e(TAG, "查询失败");
            e.printStackTrace();
        }
        return plans;
    }

    public List<Plan> getSortPlans() {
        List<Plan> plans = new ArrayList<Plan>();
        try {
            plans = planDao.queryForAll();
        } catch (SQLException e) {
            Log.e(TAG, "查询失败");
            e.printStackTrace();
        }
        sortPlans(plans);
        return plans;
    }

    public Plan getPlanById(int id) {
        Plan plan = null;
        try {
            plan = planDao.queryForId(id);
        } catch (SQLException e) {
            Log.e(TAG, "查询失败");
            e.printStackTrace();
        }
        return plan;
    }

    public void updatePlan(Plan plan) {
        try {
            planDao.update(plan);
        } catch (SQLException e) {
            Log.e(TAG, "更新失败");
            e.printStackTrace();
        }

    }

    public void updatePlanById(int id) {
        Plan plan = null;
        try {
            plan = planDao.queryForId(id);

        } catch (SQLException e) {
            Log.e(TAG, "查询失败");
            e.printStackTrace();
        }
    }

    private void sortPlans(List<Plan> plans) {
        for (Plan plan : plans) {
            int m = plan.getProgress();
            if (plan.getTop().equals("true"))
                plan.setType(Plan.URGENT_TOP);
            else if (m == 100) {
                plan.setType(Plan.URGENT_FINISHED);
            } else {
                int a = Calculator.calculate(GetDate.getDatetimeString(plan.getPlanDate()));
                if (a > 20)
                    plan.setType(Plan.URGENT_LOW);
                else if (a > 10)
                    plan.setType(Plan.URGENT_MIDDLE);
                else if (a > 5)
                    plan.setType(Plan.URGENT_HIGH);
                else
                    plan.setType(Plan.URGENT_EXTRA);
            }


        }


    }

}



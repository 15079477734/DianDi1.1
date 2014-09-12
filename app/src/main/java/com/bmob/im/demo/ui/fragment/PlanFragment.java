package com.bmob.im.demo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bmob.im.demo.R;
import com.bmob.im.demo.adapter.PlanAdapter;
import com.bmob.im.demo.db.DBUtils;


/**
 * ************************************************************
 * *********    User : SuLinger(462679107@qq.com) .
 * *********    Date : 2014-09-12  .
 * *********    Time:  2014-09-12  .
 * *********    Project name :PBOX1.3 .
 * *********    Copyright @ 2014, SuLinger, All Rights Reserved
 * *************************************************************
 */


public class PlanFragment extends BaseFragment {

    DBUtils mDBUtils;
    private ListView mPlanListView;
    private View mView;
    private PlanAdapter mPlanAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        mView = layoutInflater.inflate(R.layout.activity_my_list, null);

        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findView();
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPlanAdapter.setList(mDBUtils.getSortPlans());
    }

    @Override
    void findView() {
        mPlanListView = (ListView) mView.findViewById(android.R.id.list);
    }

    @Override
    void initData() {
    }

    @Override
    void initView() {
        mDBUtils = new DBUtils(getActivity());
        mPlanAdapter = new PlanAdapter(getActivity(), mDBUtils.getSortPlans());
        mPlanListView.setAdapter(mPlanAdapter);
        bindEvent();
    }

    @Override
    void bindEvent() {
        mPlanListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {


            }
        });
    }

}

package com.yollpoll.sbgymanager.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yollpoll.sbgymanager.R;
import com.yollpoll.sbgymanager.base.BaseHolder;
import com.yollpoll.sbgymanager.view.bean.TaskBean;

import java.util.List;

/**
 * Created by 鹏祺 on 2017/8/18.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
    private List<TaskBean> listData;

    public TaskAdapter(List<TaskBean> listData) {
        this.listData = listData;
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskHolder holder, int position) {
        TaskBean item = listData.get(position);
        holder.tvDeviceName.setText(item.getDeviceName());
        holder.tvLubricatingPart.setText(item.getLubricatingPart());
        holder.tvGreasePart.setText(item.getGreasePart());
        holder.tvLubricatingPoint.setText(item.getLubricatingPoint());
        holder.tvGreaseTool.setText(item.getGreaseTool());
        holder.tvLubricatingBumber.setText(item.getLubricatingNumber());
        holder.tvAddOilMass.setText(item.getAddOilStandardBean().getOilMass());
        holder.tvAddOilCycle.setText(item.getAddOilStandardBean().getAddCycle());
        holder.tvAddOilCheckCycle.setText(item.getAddOilStandardBean().getCheckCycle());
        holder.tvUpdateOilMass.setText(item.getUpdateOilStandardBean().getMass());
        holder.tvUpdateCycle.setText(item.getUpdateOilStandardBean().getUpdateCycle());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class TaskHolder extends BaseHolder {
        TextView tvDeviceName, tvLubricatingPart, tvGreasePart, tvLubricatingPoint,
                tvGreaseTool, tvLubricatingBumber, tvAddOilMass, tvAddOilCycle, tvAddOilCheckCycle,
                tvUpdateOilMass, tvUpdateCycle;

        public TaskHolder(View itemView) {
            super(itemView);
            tvDeviceName = (TextView) itemView.findViewById(R.id.tv_device);
            tvLubricatingPart = (TextView) itemView.findViewById(R.id.tv_lubricatingPart);
            tvGreasePart = (TextView) itemView.findViewById(R.id.tv_greasePart);
            tvLubricatingPoint = (TextView) itemView.findViewById(R.id.tv_lubricatingPoint);
            tvGreaseTool = (TextView) itemView.findViewById(R.id.tv_greaseTool);
            tvLubricatingBumber = (TextView) itemView.findViewById(R.id.tv_lubricatingNumber);
            tvAddOilMass = (TextView) itemView.findViewById(R.id.tv_add_oil_mass);
            tvAddOilCycle = (TextView) itemView.findViewById(R.id.tv_add_oil_cycle);
            tvAddOilCheckCycle = (TextView) itemView.findViewById(R.id.tv_add_oil_check_cycle);
            tvUpdateOilMass = (TextView) itemView.findViewById(R.id.tv_update_oil_mass);
            tvUpdateCycle = (TextView) itemView.findViewById(R.id.tv_update_oil_cycle);
        }
    }
}

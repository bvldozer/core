package com.cartenz.design.wizard;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cartenz.design.R;

import java.util.ArrayList;
import java.util.List;


public class WizardAdapter extends RecyclerView.Adapter<WizardAdapter.MyViewHolder> {

    private List<WizardDao> titles = new ArrayList<>();
    private Context context;
    private RecyclerView rvWizard;

    public WizardAdapter(List<WizardDao> titles, RecyclerView rvWizard) {
        this.titles = titles;
        this.rvWizard = rvWizard;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rlWizard;

        MyViewHolder(View view) {
            super(view);
            rlWizard = (RelativeLayout) view.findViewById(R.id.rl_wizard);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wizard_item, parent, false);
        context = parent.getContext();
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        int grey = R.drawable.shape_round_square_grey;
        int blue_soft = R.drawable.shape_round_square_blue_soft;
        int blue = R.drawable.shape_round_square_blue;
        int drawable = grey;
        if (titles.get(position).getType() == 1) {
            drawable = blue_soft;
        }
        if (titles.get(position).getType() == 2) {
            drawable = blue;
        }
        holder.rlWizard.setBackground(ContextCompat.getDrawable(context, drawable));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}

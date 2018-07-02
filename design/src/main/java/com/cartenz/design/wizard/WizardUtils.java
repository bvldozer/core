package com.cartenz.design.wizard;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.cartenz.core.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratama on 2/15/2018.
 */

public class WizardUtils {
    private RecyclerView rvWizard;
    private TextView tvWizardTitle;

    private Context context;
    private WizardAdapter wizardAdapter;
    private List<WizardDao> titles = new ArrayList<>();

    public WizardUtils(Context context) {
        this.context = context;
        rvWizard = ((Activity) context).findViewById(R.id.rv_wizard);
        tvWizardTitle = ((Activity) context).findViewById(R.id.tv_wizard_title);
        if (titles.size() > 0) {
            titles.clear();
        }
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rvWizard.setLayoutManager(mLayoutManager);
        wizardAdapter = new WizardAdapter(titles, rvWizard);
        wizardAdapter.notifyDataSetChanged();
        rvWizard.setAdapter(wizardAdapter);
    }

    public void add(String title) {
        WizardDao wizardDao = new WizardDao(title, 0);
        titles.add(wizardDao);
        wizardAdapter.notifyDataSetChanged();
    }

    public void setSelection(int selection) {
        for (int i = 0; i < titles.size(); i++) {
            if (i < selection) {
                titles.get(i).setType(1);
            } else if (i == selection) {
                titles.get(i).setType(2);
            } else {
                titles.get(i).setType(0);
            }


        }

        tvWizardTitle.setText(titles.get(selection).getTitle());
        rvWizard.getLayoutManager().scrollToPosition(selection);
        wizardAdapter.notifyDataSetChanged();
    }


}

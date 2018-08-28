package com.cloudifive.healthcare.helpers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.cloudifive.healthcare.R;


/**
 * Created by angler142 on 06/08/16.
 */
public class Progress_Dialog {
    ProgressDialog aProgressDialog;

    public Progress_Dialog(FragmentActivity aActivity) {
        aProgressDialog = new ProgressDialog(aActivity);
    }

    public Progress_Dialog(Activity aActivity) {
        aProgressDialog = new ProgressDialog(aActivity);
    }

    public Progress_Dialog(Context aCtx) {
        aProgressDialog = new ProgressDialog(aCtx);
    }

    public void show(String aMessage) {
        try {
            aProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            aProgressDialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT));
            aProgressDialog.setCancelable(false);
            aProgressDialog.setMessage(aMessage);
            aProgressDialog.show();
            aProgressDialog.setContentView(R.layout.loadingbar_spinner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismiss() {
        try {
            aProgressDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setColor(String s) {
    }
}
package com.cloudifive.healthcare.utils;


public interface IDialogListener {
    void onPositiveButtonClick(int responseCode) ;
    void onNegativeButtonClick(int responseCode);
}

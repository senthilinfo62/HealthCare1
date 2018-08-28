package com.cloudifive.healthcare.Models;

/**
 * Created by kirandani on 19-02-2017.
 */

public class SubCategoryInfo {

  private String subCategoryId;
  private String subCategoryName = "";
  private boolean isChecked = false;

  public String getSubCategoryId( ) {
    return subCategoryId;
  }

  public void setSubCategoryId(String subCategoryId) {
    this.subCategoryId = subCategoryId;
  }

  public String getSubCategoryName( ) {
    return subCategoryName;
  }

  public void setSubCategoryName(String subCategoryName) {
    this.subCategoryName = subCategoryName;
  }

  public boolean isChecked() {
    return isChecked;
  }

  public void setChecked(boolean checked) {
    isChecked = checked;
  }
}

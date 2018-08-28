package com.cloudifive.healthcare.Models;

import java.util.ArrayList;

/**
 * first level item
 */
public class MenuItems {

  private String name;

  private String MenuItemId = "";

  private ArrayList<Category> mCategoryList;

  public MenuItems(String name, ArrayList<Category> mCategoryList ) {
    super();
    this.name = name;
    this.mCategoryList = mCategoryList;
  }

  public String getName( ) {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public ArrayList<Category> getmCategoryList( ) {
    return mCategoryList;
  }

  public void setmCategoryList( ArrayList<Category> mCategoryList ) {
    this.mCategoryList = mCategoryList;
  }

  public String getMenuItemId( ) {
    return MenuItemId;
  }

  public void setMenuItemId( String menuItemId ) {
    MenuItemId = menuItemId;
  }

  /**
   * second level item
   */

  public static class Category {

    private boolean isChecked = false;
    private String CategoryName;
    private String CategortId = "";
    private ArrayList<SubCategory> CategoryArray;

    public Category( ) {

    }

    public Category(String CategoryName, ArrayList<SubCategory> CategoryArray ) {
      super();
      this.CategoryName = CategoryName;
      this.CategoryArray = CategoryArray;
    }

    public boolean isChecked() {
      return isChecked;
    }

    public void setChecked(boolean checked) {
      isChecked = checked;
    }

    public String getCategoryName( ) {
      return CategoryName;
    }

    public void setCategoryName( String categoryName ) {
      this.CategoryName = categoryName;
    }

    public ArrayList<SubCategory> getCategoryArray( ) {
      return CategoryArray;
    }

    public void setCategoryArray( ArrayList<SubCategory> categoryArray ) {
      this.CategoryArray = categoryArray;
    }

    public String getCategortId( ) {
      return CategortId;
    }

    public void setCategortId( String categortId ) {
      CategortId = categortId;
    }


    /**
     * third level item
     */
    public static class SubCategory {

      private boolean isChecked = false;
      private String SubCategoryId = "";
      private String subCategotyName = "";
      private String CategoryId = "";

      public SubCategory( ) {

      }

      public boolean isChecked() {
        return isChecked;
      }

      public void setChecked(boolean checked) {
        isChecked = checked;
      }

      public SubCategory(String subCategotyName ) {
        super();
        this.subCategotyName = subCategotyName;
      }

      public String getSubCategotyName( ) {
        return subCategotyName;
      }

      public void setSubCategotyName( String subCategotyName ) {
        this.subCategotyName = subCategotyName;
      }

      public String getSubCategoryId( ) {
        return SubCategoryId;
      }

      public void setSubCategoryId( String subCategoryId ) {
        this.SubCategoryId = subCategoryId;
      }

      public String getCategoryId( ) {
        return CategoryId;
      }

      public void setCategoryId( String categoryId ) {
        this.CategoryId = categoryId;
      }
    }

  }

}

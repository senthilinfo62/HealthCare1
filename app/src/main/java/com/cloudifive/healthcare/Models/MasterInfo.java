package com.cloudifive.healthcare.Models;

import java.util.ArrayList;

/**
 * Created by gopalakrishnan.s on 13-02-2017.
 */

public class MasterInfo {

    public String getLanguageName() {
        return LanguageName;
    }

    public void setLanguageName(String languageName) {
        LanguageName = languageName;
    }

    public String getLanguageID() {
        return LanguageID;
    }

    public void setLanguageID(String languageID) {
        LanguageID = languageID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getSubCategoryName() {
        return SubCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        SubCategoryName = subCategoryName;
    }

    public String getSubCategoryID() {
        return SubCategoryID;
    }

    public void setSubCategoryID(String subCategoryID) {
        SubCategoryID = subCategoryID;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductTechName() {
        return ProductTechName;
    }

    public void setProductTechName(String productTechName) {
        ProductTechName = productTechName;
    }

    public String getProductDesc() {
        return ProductDesc;
    }

    public void setProductDesc(String productDesc) {
        ProductDesc = productDesc;
    }

    public String getProductRec() {
        return ProductRec;
    }

    public void setProductRec(String productRec) {
        ProductRec = productRec;
    }

    public String getProductAMT() {
        return ProductAMT;
    }

    public void setProductAMT(String productAMT) {
        ProductAMT = productAMT;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String productImage) {
        ProductImage = productImage;
    }


    public String getProductQuantity( ) {
        return ProductQuantity;
    }

    public void setProductQuantity( String productQuantity ) {
        ProductQuantity = productQuantity;
    }

    private String ProductQuantity = "";

    private String LanguageName = "";

    private String LanguageID = "";

    private String CategoryName = "";

    private String CategoryID = "";

    private String SubCategoryName = "";

    private String SubCategoryID = "";

    private String ProductID = "";

    private String ProductName = "";

    private String ProductTechName = "";

    private String ProductDesc = "";

    private String ProductRec = "";

    private String ProductAMT = "";

    private String ProductImage = "";

    public String getHeaderTitle() {
        return HeaderTitle;
    }

    public void setHeaderTitle(String headertitle) {
        HeaderTitle = headertitle;
    }

    private String HeaderTitle = "";

    public String getSubHeaderTitle() {
        return SubHeaderTitle;
    }

    public void setSubHeaderTitle(String subHeaderTitle) {
        SubHeaderTitle = subHeaderTitle;
    }

    private String SubHeaderTitle = "";

    public String getSubCategoryEnable() {
        return subCategoryEnable;
    }

    public void setSubCategoryEnable(String subCategoryEnable) {
        this.subCategoryEnable = subCategoryEnable;
    }

    private String subCategoryEnable = "";


    public ArrayList<MasterInfo> getProductDetails() {
        return ProductDetails;
    }

    public void setProductDetails(ArrayList<MasterInfo> productDetails) {
        ProductDetails = productDetails;
    }

    private ArrayList<MasterInfo> ProductDetails;

    //Menu page

    private String MenuName = "";

    private String MenuID = "";

    private String MenuSelection = "";

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }

    public String getMenuSelection() {
        return MenuSelection;
    }

    public void setMenuSelection(String menuSelection) {
        MenuSelection = menuSelection;
    }


    //Landing page

    private String LandingImage = "";

    private String LandingDesc = "";

    private String LandObject = "";

    public String getLandingImage() {
        return LandingImage;
    }

    public void setLandingImage(String landingImage) {
        LandingImage = landingImage;
    }

    public String getLandingDesc() {
        return LandingDesc;
    }

    public void setLandingDesc(String landingDesc) {
        LandingDesc = landingDesc;
    }

    public String getLandObject() {
        return LandObject;
    }

    public void setLandObject(String landObject) {
        LandObject = landObject;
    }
}

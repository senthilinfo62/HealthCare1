package com.cloudifive.healthcare.Models;

import java.util.ArrayList;

/**
 * Created by kirandani on 17-02-2017.
 */

public class ProductInfo {

  private String productID;
  private String productName = "";
  private String productTechName = "";
  private String productDesc = "";
  private String productAMT = "";
  private String productRec = "";
  private String productImage = "";
  private String productQuantity = "";

  public String getProductQuantity( ) {
    return productQuantity;
  }

  public void setProductQuantity( String productQuantity ) {
    this.productQuantity = productQuantity;
  }


  private ArrayList<ProductInfo> ProductInfoList;

  public String getProductID( ) {
    return productID;
  }

  public void setProductID( String productID ) {
    this.productID = productID;
  }

  public String getProductName( ) {
    return productName;
  }

  public void setProductName( String productName ) {
    this.productName = productName;
  }

  public String getProductTechName( ) {
    return productTechName;
  }

  public void setProductTechName( String productTechName ) {
    this.productTechName = productTechName;
  }

  public String getProductDesc( ) {
    return productDesc;
  }

  public void setProductDesc( String productDesc ) {
    this.productDesc = productDesc;
  }

  public String getProductAMT( ) {
    return productAMT;
  }

  public void setProductAMT( String productAMT ) {
    this.productAMT = productAMT;
  }

  public String getProductRec( ) {
    return productRec;
  }

  public void setProductRec( String productRec ) {
    this.productRec = productRec;
  }

  public String getProductImage( ) {
    return productImage;
  }

  public void setProductImage( String productImage ) {
    this.productImage = productImage;
  }

  public ArrayList<ProductInfo> getProductInfoList( ) {
    return ProductInfoList;
  }

  public void setProductInfoList( ArrayList<ProductInfo> productInfoList ) {
    ProductInfoList = productInfoList;
  }


}

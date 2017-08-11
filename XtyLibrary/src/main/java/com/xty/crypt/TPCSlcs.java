package com.xty.crypt;

public class TPCSlcs
{
  static
  {
    System.loadLibrary("tpcslcs");
  }


 public static native int tm_license_verify(String path);


 public static int tpcs_lcs_verify(String path)
  {
    
   int result = tm_license_verify(path);

    return result;
  }



}
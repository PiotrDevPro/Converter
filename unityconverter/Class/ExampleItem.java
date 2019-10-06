package com.piotrdevelop.unityconverter.Class;

import android.content.Intent;

import com.piotrdevelop.unityconverter.DavlActivity;
import com.piotrdevelop.unityconverter.FavoriteNav;


public class ExampleItem
{
        private String mLine1;
        private String mLine2;

        public ExampleItem(String line1, String line2)
        {
        mLine1 = line1;
        mLine2 = line2;
        }

        public void changeText1(String text){
            mLine1 = text;
        }


        public String getLine1() {
            return mLine1;
        }

        public String getLine2() {
            return mLine2;
        }
      //  public String getLine3(){
       //     return mLine3;
     //   }

}
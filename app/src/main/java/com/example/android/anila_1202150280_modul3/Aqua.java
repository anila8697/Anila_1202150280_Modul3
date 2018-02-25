package com.example.android.anila_1202150280_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;


class Aqua {

        //Member variables representing the title, image and information about the sport
        private final String title;
        private final String info;
        private final int imageResource;
        private final String aquaDetail;

        static final String TITLE_KEY = "Title";
        static final String IMAGE_KEY = "Image Resource";
        static final String DETAIL_KEY = "Detail";

        /**
         * Constructor for the Aqua class data model
         * @param title The name if the sport.
         * @param info Information about the sport.
         * @param imageResource The resource for the sport image
         */
        Aqua(String title, String info, int imageResource, String aquaDetail) {
            this.title = title;
            this.info = info;
            this.imageResource = imageResource;
            this.aquaDetail = aquaDetail;
        }

        String getTitle() { return title; }

        String getInfo() {
            return info;
        }

        String getDetail() {
        return aquaDetail;
    }

        int getImageResource() {
            return imageResource;
        }


        static Intent starter(Context context, String title, @DrawableRes int imageResId, String detailAqua) {
            Intent detailIntent = new Intent(context, DetailActivity.class);
            detailIntent.putExtra(TITLE_KEY, title);
            detailIntent.putExtra(IMAGE_KEY, imageResId);
            detailIntent.putExtra(DETAIL_KEY, detailAqua);
            return detailIntent;
        }
    }


package com.cartenz.core.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by pratama on 1/15/2018.
 */

public class ImageHelper {

    public static void loadImageCenterCrop(Context context, String url, ImageView imageView, int placeholder) {
        DrawableRequestBuilder<String> glide = loadImage(context, url, placeholder);
        glide.centerCrop();
        glide.into(imageView);
    }

    public static void loadImageFitCenter(Context context, String url, ImageView imageView, int placeholder) {
        DrawableRequestBuilder<String> glide = loadImage(context, url, placeholder);
        glide.fitCenter();
        glide.into(imageView);
    }

    public static DrawableRequestBuilder<String> loadImage(Context context, String url, int placeholder) {
        DrawableRequestBuilder<String> glide = Glide.with(context).load(url);
        if (placeholder > 0) {
            glide.placeholder(placeholder);
        }
        return glide;
    }

    public static void setImage(Context context, String url, ProgressBar progressBar, ImageView imageview, int placeholder, int error) {
        imageview.setImageResource(0);
        if (!TextUtils.isEmpty(url)) {

            if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }

            DrawableTypeRequest<String> glide = Glide.with(context).load(url);
            if (placeholder > 0) {
                glide.placeholder(placeholder);
            }
            if (error > 0) {
                glide.error(error);

            }
            glide.listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    if (progressBar != null) {
                        progressBar.setVisibility(View.GONE);
                    }
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    if (progressBar != null) {
                        progressBar.setVisibility(View.GONE);
                    }
                    return false;
                }
            }).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().into(imageview);
        } else {
            if (progressBar != null) {
                progressBar.setVisibility(View.GONE);
            }
//            imageview.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_default_image));
        }
    }

}

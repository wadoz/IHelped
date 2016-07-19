package com.cpuschedule.xdev.cpushedule;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.cpuschedule.xdev.cpushedule.util.FastBlur;

import mehdi.sakout.fancybuttons.FancyButton;

public class MainFragment extends Fragment {

    public static final String TAG = "MainFragment";

    private ImageView mainFragmentBackgroundImageView;
    private FancyButton mainFragmentStudentButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!MainActivity.isNetworkAvailable(getContext())) {
            return inflater.inflate(R.layout.view_internet_missing, container, false);
        }
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        hideStatusBar();
        bindElements(view);
        blur();

        return view;
    }

    private void blur() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.main_background);
        mainFragmentBackgroundImageView.setImageBitmap(FastBlur.doBlur(bitmap, 12, false));
    }

    private void bindElements(View v) {
        mainFragmentBackgroundImageView = (ImageView)v.findViewById(R.id.background_fragment_main_image_view);
        mainFragmentStudentButton = (FancyButton)v.findViewById(R.id.main_fragment_student_button);
    }


    public void hideStatusBar() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (Build.VERSION.SDK_INT < 16) {
                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } else {
                View decorView = getActivity().getWindow().getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);

            }

        }
    }
}

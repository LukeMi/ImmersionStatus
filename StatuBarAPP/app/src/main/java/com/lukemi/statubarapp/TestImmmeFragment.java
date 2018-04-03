package com.lukemi.statubarapp;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestImmmeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestImmmeFragment extends DialogFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TextView tv;
    private View view;


    public TestImmmeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestImmmeFragment.
     */
    public static TestImmmeFragment newInstance(String param1, String param2) {
        TestImmmeFragment fragment = new TestImmmeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setStyle(R.style.DialogFragment_Bottom_In_Out_Style, R.style.AppTheme);
       /* StatusBarUtils.with(getActivity())
                .setColorRes(R.color.blue_deep)
                .init();*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_test_immme, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = view.findViewById(R.id.tv_content);
        ViewGroup.LayoutParams layoutParams = tv.getLayoutParams();
        Log.i("TAG", getStatusBarHeight() + "");
        tv.setPadding(0, getStatusBarHeight(), 0, 0);
    }


    public int getStatusBarHeight() {
        //给一个默认值，不同机型可能存在误差
        float v = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
        int result = (int) v;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            window.setWindowAnimations(R.style.DialogFragment_Bottom_In_Out_Style);
        }
    }
}

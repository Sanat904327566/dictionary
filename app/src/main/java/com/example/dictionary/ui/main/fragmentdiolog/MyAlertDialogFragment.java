package com.example.dictionary.ui.main.fragmentdiolog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dictionary.R;
import com.example.dictionary.db.model.Words;

public class MyAlertDialogFragment extends DialogFragment {
    private static final String ARGUMENT_ORDER = "ARGUMENT_ORDER";
   static String name;
    TextView textView;
    static Bundle args;
    public static MyAlertDialogFragment newInstance(String  title, Words words) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        args= new Bundle();
        args.putString("title", words.component1());
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.material_dialog, container, false);
        textView = view.findViewById(R.id.tv_one);
        textView.setText(args.getString("title"));
        return view;
    }
//
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        final Dialog dialog = super.onCreateDialog(savedInstanceState);
//        final Window window = dialog.getWindow();
//        if (window != null) {
//            window.setGravity(Gravity.TOP);
//            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            window.requestFeature(Window.FEATURE_NO_TITLE);
//        }
//        return dialog;
//    }

}
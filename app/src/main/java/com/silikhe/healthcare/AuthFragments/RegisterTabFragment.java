package com.silikhe.healthcare.AuthFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.silikhe.healthcare.R;

public class RegisterTabFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_fragment, container, false);
        return root;
    }
}

package com.sornsophearum.pcstore.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.sornsophearum.pcstore.databinding.FragmentAboutBinding;

public class AboutFragment extends Fragment {

    private FragmentAboutBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Get ViewModel
        AboutViewModel aboutViewModel = new ViewModelProvider(this).get(AboutViewModel.class);

        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Set up text views
        final TextView textAboutTitle = binding.textAboutTitle;
        final TextView textAboutDescription = binding.textAboutDescription;
        final TextView textMissionTitle = binding.textMissionTitle;
        final TextView textMissionDescription = binding.textMissionDescription;
        final TextView textTeamTitle = binding.textTeamTitle;
        final TextView textContactTitle = binding.textContactTitle;
        final TextView textContactInfo = binding.textContactInfo;

        // Observe ViewModel data
        aboutViewModel.getAboutTitle().observe(getViewLifecycleOwner(), textAboutTitle::setText);
        aboutViewModel.getAboutDescription().observe(getViewLifecycleOwner(), textAboutDescription::setText);
        aboutViewModel.getMissionTitle().observe(getViewLifecycleOwner(), textMissionTitle::setText);
        aboutViewModel.getMissionDescription().observe(getViewLifecycleOwner(), textMissionDescription::setText);
        aboutViewModel.getTeamTitle().observe(getViewLifecycleOwner(), textTeamTitle::setText);
        aboutViewModel.getContactTitle().observe(getViewLifecycleOwner(), textContactTitle::setText);
        aboutViewModel.getContactInfo().observe(getViewLifecycleOwner(), textContactInfo::setText);

        // Set up WebView for the map
        WebView webViewMap = binding.webviewMap;
        webViewMap.setWebViewClient(new WebViewClient());
        webViewMap.getSettings().setJavaScriptEnabled(true);
        webViewMap.loadUrl("https://www.google.com/maps/place/The+University+of+Cambodia/@11.5583133,104.8685105,17z/data=!4m14!1m7!3m6!1s0x310951b83795d97b:0x735f8f7a3e5bc507!2sThe+University+of+Cambodia!8m2!3d11.5583081!4d104.8710854!16s%2Fm%2F0cpb480!3m5!1s0x310951b83795d97b:0x735f8f7a3e5bc507!8m2!3d11.5583081!4d104.8710854!16s%2Fm%2F0cpb480?entry=ttu");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clean up binding
        binding = null;
    }
}

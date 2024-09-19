package com.aidootk.gmenu.activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aidootk.gmenu.droid.R;


public class HomeActivity extends AppCompatActivity {

    ActivityResultLauncher<Void> romsFolderLauncher = registerForActivityResult(new ActivityResultContract<Void, String>() {

        @Override
        public String parseResult(int resultCode, @Nullable Intent intent) {
            if (resultCode != RESULT_OK)
                return null;
            return intent.getStringExtra("result");
        }

        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Void unused) {
            return new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
        }
    }, result -> {
        if (result != null) {
            Log.d("HomeActivity", "Selected folder: " + result);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.select_roms_folder).setOnClickListener(this::selectRomsFolder);
    }

    public void selectRomsFolder(View view) {
        romsFolderLauncher.launch(null);
    }
}
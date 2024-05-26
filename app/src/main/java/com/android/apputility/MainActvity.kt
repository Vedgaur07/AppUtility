package com.android.apputility

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.apputilitylibrary.file_provider.FileProvider
import com.android.apputilitylibrary.utils.StringHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FileProvider.TRIM_MEMORY_COMPLETE
    }

}
package hydroxid.file;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

import hydroxid.R;
import hydroxid.utils.base.BaseUtil;
import hydroxid.utils.file.FileUtil;

/**
 * This util class is used to display files and perform file-related operations
 *
 * @author hydroxid
 * @since 2022-08-31
 */
public class ActivityFile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        // get all files in directory
        ArrayList<File> files = new FileUtil().filesInDirectory(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS);
        Log.d("activity_file_arraylist", files.toString());
        ArrayList<ListFile> arrFiles = new ArrayList<ListFile>();

        /**
         * loop
         * convert ArrayList<File> to ArrayList<ListFile>
         */
        if (files != null) {
            for (int i = 0; i < files.size(); i++) {
                File file = files.get(i);
                arrFiles.add(new ListFile(file.toString(), R.drawable.ic_home_24));
            }
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        AdapterFile adapter = new AdapterFile(arrFiles);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

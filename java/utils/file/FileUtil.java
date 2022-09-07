package hydroxid.utils.file;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * File utils
 *
 * @author hydroxid
 */
public class FileUtil {

    /**
     * get all files in directory in
     *
     * @param context context
     * @param path dir path
     * @author hydroxid
     */
    public ArrayList<File> filesInDirectory(Context context, String path) {
        // init vars
        File dir = Environment.getExternalStoragePublicDirectory(path);
        File[] files = dir.listFiles();
        // results
        ArrayList<File> results = new ArrayList<File>();

        if (files != null) {
            for (File file : files) {
                results.add(file);
            }
        } else {
            Log.d("filesInDirectory() == null", "Please check storage permissions for app!");
        }

        Log.d("filesInDirectory", results.toString());

        return results;
    }
}

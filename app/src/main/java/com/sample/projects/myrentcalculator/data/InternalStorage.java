package com.sample.projects.myrentcalculator.data;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/16/18.
 */

public class InternalStorage {

    private Context context;
    private List<String> contentList;

    public InternalStorage(Context context) {
        this.context = context;
    }

    public List<String> readInternalStorage(String filename) {
        StringBuilder sb = null;
        try {
            FileInputStream fis = context.openFileInput(filename);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            contentList = new ArrayList<>();
//            String container = br.readLine();
//            contentList.add(container);

            sb = new StringBuilder();
            String container = null;
            while ((container = br.readLine()) != null) {
                sb.append(container).append(",\n");
                contentList.add(container);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentList;
    }

    public void writeInternalStorage(String filename, String json) {
        contentList = new ArrayList<>();
        try {
            FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(json.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

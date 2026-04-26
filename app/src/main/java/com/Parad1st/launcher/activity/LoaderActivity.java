package com.byparad1st.launcher.activity;

import android.content.Intent;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
// import com.hzy.libp7zip.P7ZipApi; // Закомментировано — библиотека недоступна
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadSampleListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.byparad1st.launcher.R;
import com.byparad1st.launcher.utils.Utils;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import java.io.File;
import java.util.Formatter;

public class LoaderActivity extends AppCompatActivity {

    private RoundCornerProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        progressbar = findViewById(R.id.progress_bar);
        TextView textprogress = findViewById(R.id.loading_percent);
        TextView textloading = findViewById(R.id.loading_text);

        String url = "https://example.com/black-cache.7z"; // Замените на реальный URL
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/black-cache.7z";

        FileDownloader.setup(this);
        FileDownloader.getImpl().create(url)
                .setPath(path)
                .setListener(new FileDownloadSampleListener() {
                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.progress(task, soFarBytes, totalBytes);
                        float progressPercent = (float) soFarBytes / (float) totalBytes * 100;
                        TextView textprogress = findViewById(R.id.loading_percent);
                        textprogress.setText(new Formatter().format("%s из %s", Utils.bytesIntoHumanReadable(soFarBytes), Utils.bytesIntoHumanReadable(totalBytes)).toString());
                        progressbar.setProgress((int) progressPercent);
                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        super.error(task, e);
                        Toast.makeText(getApplicationContext(), "Произошла ошибка начните заново установку", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoaderActivity.this, MainActivity.class));
                    }

                    @Override
                    protected void connected(BaseDownloadTask task, String et, boolean isContinue, int soFarBytes, int totalBytes) {
                        super.connected(task, et, isContinue, soFarBytes, totalBytes);
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.paused(task, soFarBytes, totalBytes);
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        super.completed(task);
                        TextView textprogress = findViewById(R.id.loading_percent);
                        TextView textloading = findViewById(R.id.loading_text);

                        textloading.setText("Идёт распаковка файлов игры...");
                        textprogress.setText("2/2");
                        // UnZipCache(); // Закомментировано — библиотека P7ZipApi недоступна
                        afterDownload();
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {
                        super.warn(task);
                    }
                }).start();
    }

    /*
    // Метод UnZipCache закомментирован, так как библиотека P7ZipApi недоступна
    public void UnZipCache(){
        String mInputFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/black-cache.7z";
        String mOutputPath = Environment.getExternalStorageDirectory().toString();
        new Thread() {
            @Override
            public void run() {
                // P7ZipApi.executeCommand(String.format("7z x '%s' '-o%s' -aoa", mInputFilePath, mOutputPath));
                Utils.delete(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/black-cache.7z"));
                Utils.delete(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/black-cache.7z.temp"));
                runOnUiThread(() -> {
                    afterDownload();
                }); 
            }
        }.start();
    }
    */

    public void afterDownload(){
        Toast.makeText(this, "Игра успешно установлена!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
}

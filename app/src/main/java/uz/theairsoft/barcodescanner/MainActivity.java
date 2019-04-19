package uz.theairsoft.barcodescanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.vision.barcode.Barcode;

import uz.theairsoft.barcodescanner.materialbarcodescanner.MaterialBarcodeScanner;
import uz.theairsoft.barcodescanner.materialbarcodescanner.MaterialBarcodeScannerBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void startScan() {
        /**
         * Build a new MaterialBarcodeScanner
         */
        final MaterialBarcodeScanner materialBarcodeScanner = new MaterialBarcodeScannerBuilder()
                .withActivity(MainActivity.this)
                .withEnableAutoFocus(true)
                .withBleepEnabled(true)
                .withBackfacingCamera()
                .withCenterTracker()
                .withText("Scanning...")
                .withResultListener(new MaterialBarcodeScanner.OnResultListener() {
                    @Override
                    public void onResult(Barcode barcode) {

                    }
                })
                .build();
        materialBarcodeScanner.setActivityCompat(this);
        materialBarcodeScanner.setContainerId(R.id.content);
        materialBarcodeScanner.startScan();
    }
}

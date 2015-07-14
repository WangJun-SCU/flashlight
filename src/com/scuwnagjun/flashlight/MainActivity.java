package com.scuwnagjun.flashlight;

import com.scuwangjun.flashlight.R;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private Button button;
	private Button exitId;
	private LinearLayout main;
	private Camera camera;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.main_button);
		exitId = (Button) findViewById(R.id.main_exit);
		main = (LinearLayout) findViewById(R.id.main_id);
		
		exitId.setVisibility(View.INVISIBLE);

		button.setTag("2");
		
		button.setText("关闭");
		button.setTextColor(getResources().getColor(R.color.black));
		main.setBackgroundColor(getResources().getColor(
				R.color.white));

		camera = Camera.open();
		Parameters params = camera.getParameters();
		params.setFlashMode(Parameters.FLASH_MODE_TORCH);
		camera.setParameters(params);
		camera.startPreview(); // 开始亮灯

		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if (button.getTag().equals("1")) {
					button.setText("关闭");
					button.setTextColor(getResources().getColor(R.color.black));
					main.setBackgroundColor(getResources().getColor(
							R.color.white));

					camera = Camera.open();
					Parameters params = camera.getParameters();
					params.setFlashMode(Parameters.FLASH_MODE_TORCH);
					camera.setParameters(params);
					camera.startPreview(); // 开始亮灯
					
					exitId.setVisibility(View.INVISIBLE);

					button.setTag("2");
				} else if (button.getTag().equals("2")) {
					button.setText("打开");
					button.setTextColor(getResources().getColor(R.color.white));
					main.setBackgroundColor(getResources().getColor(
							R.color.black));

					camera.stopPreview(); // 关掉亮灯
					camera.release(); // 关掉照相机
					
					exitId.setVisibility(View.VISIBLE);

					button.setTag("1");
				}
			}
		});
		
		exitId.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				System.exit(0);
			}
		});
	}
}

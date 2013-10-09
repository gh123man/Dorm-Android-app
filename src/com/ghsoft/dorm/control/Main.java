package com.ghsoft.dorm.control;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class Main extends Activity {

	Button b, b1;
	TextView redTV, greenTV, blueTV;
	SeekBar red, green, blue;
	int cR, cB, cG;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button b = (Button) findViewById(R.id.unlock);
		Button b1 = (Button) findViewById(R.id.lock);

		redTV = (TextView) findViewById(R.id.redout);
		red = (SeekBar) findViewById(R.id.red);
		
		greenTV = (TextView) findViewById(R.id.greenout);
		green = (SeekBar) findViewById(R.id.green);
		
		blueTV = (TextView) findViewById(R.id.blueout);
		blue = (SeekBar) findViewById(R.id.blue);

		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated captmethod stub

				new Thread(new Runnable() {
					public void run() {
						try {
							ServerContact serv = new ServerContact("unlock");
							serv.connect();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}).start();

			}
		});

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				new Thread(new Runnable() {
					public void run() {
						try {
							ServerContact serv = new ServerContact("lock");
							serv.connect();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}).start();

			}
		});
		
		red.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				redTV.setText("R: " + progress);
				cR = progress;
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				new Thread(new Runnable() {
					public void run() {
						try {
							ServerContact serv = new ServerContact("color " + cR + "-" + cG + "-" + cB);
							serv.connect();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}).start();
			}
		});
		
		green.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				greenTV.setText("G: " + progress);
				cG = progress;
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				new Thread(new Runnable() {
					public void run() {
						try {
							ServerContact serv = new ServerContact("color " + cR + "-" + cG + "-" + cB);
							serv.connect();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}).start();
			}
		});
		
		blue.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				blueTV.setText("B: " + progress);
				cB = progress;
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				new Thread(new Runnable() {
					public void run() {
						try {
							ServerContact serv = new ServerContact("color " + cR + "-" + cG + "-" + cB);
							serv.connect();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}).start();
			}
		});
		
	}
}

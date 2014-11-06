package mad.app.tipcalculator;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView splashTV1;
	private TextView splashTV2;
	private MediaPlayer song;

	class Splash extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
			Log.d("B", "launching");
			
			Intent i=new Intent(MainActivity.this,Calculator.class);
			Log.d("B", "launched");
			startActivity(i);
			}
		}
	}
	
	
	
	@Override
	protected void onPause() {
		song.stop();
		song.release();
		finish();
		super.onPause();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*splashTV1=(TextView)findViewById(R.id.splashTextView1);
		splashTV2=(TextView)findViewById(R.id.splashTextView2);
		try{
			Typeface face;
			face = Typeface.createFromAsset(getAssets(), "machingun.ttf");
			splashTV1.setTypeface(face);
			splashTV2.setTypeface(face);	
		}catch(Exception e){
			e.getCause();
			e.printStackTrace();
		}*/
		Log.v("content set", "");
		setContentView(R.layout.activity_main);
		song = MediaPlayer.create(this,R.raw.coin_sms); 
		song.start();
		Splash t=new Splash();
		t.start();
	}

}
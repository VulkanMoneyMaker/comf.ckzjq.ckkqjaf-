package comz.dsaddfsad.sfasf.slotmania;


import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.opengl.CCTexture2D;
import org.cocos2d.transitions.CCFadeTransition;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import comz.dsaddfsad.sfasf.Layer.LogoLayer;
import comz.dsaddfsad.sfasf.Layer.TitleLayer;
import comz.dsaddfsad.sfasf.Other.ksdfkjasdhfdashfkjsdhakf;
import comz.dsaddfsad.sfasf.utils.fqpwejfdlskdjglfg;
import comz.dsaddfsad.sfasf.utils.fdlsfklsdflksakjlfjlksda;



public class GameActivity extends Activity {
	private CCGLSurfaceView mGLSurfaceView;	
	private boolean startState ;

	//@Override 
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
        getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,
                LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(LayoutParams.FLAG_KEEP_SCREEN_ON,
                LayoutParams.FLAG_KEEP_SCREEN_ON);

        mGLSurfaceView = new CCGLSurfaceView(this);        
        if(!startState){
        	CCDirector.sharedDirector().setScreenSize(CCDirector.sharedDirector().winSize().width, 
	        CCDirector.sharedDirector().winSize().height);
	        CCDirector.sharedDirector().setDeviceOrientation(CCDirector.kCCDeviceOrientationLandscapeLeft);
		    CCDirector.sharedDirector().getActivity().setContentView(mGLSurfaceView, createLayoutParams());
		    CCDirector.sharedDirector().attachInView(mGLSurfaceView);       
	        CCDirector.sharedDirector().setAnimationInterval(1.0f / 60);
	        CCDirector.sharedDirector().setDisplayFPS(false);
	        CCTexture2D.setDefaultAlphaPixelFormat(Config.ARGB_8888);  
//	        getAdmob();
	        
//		    getInterstitialAd();
//		    getVungleAd();
			InitParam();
			CCDirector.sharedDirector().runWithScene( LogoLayer.scene());
			startState = true;
        }
	    
    }
	public void getAdmob(){

	}
	public void getInterstitialAd(){       	

	}
    public void getVungleAd(){

    }
    
    //@Override 
    public void onStart() {
        super.onStart();       

    }    
   
    @Override
	public void onBackPressed() {
//    	if(!G.titleState)
//    		getInterstitialAd();
    	DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
    	    @Override
    	    public void onClick(DialogInterface dialog, int which) {
    	        switch (which){
    	        case DialogInterface.BUTTON_POSITIVE:
    	        	if(G.titleState){
    					G.titleState = false;
    					CCDirector.sharedDirector().replaceScene(CCFadeTransition.transition(0.5f, TitleLayer.scene()));								
    				}else{
    					G.stopSound();    					
    					CCDirector.sharedDirector().end();
    			        ksdfkjasdhfdashfkjsdhakf.flsdakjfdklsafjlksdajfkl();
    			        finish();
    				}	
    	            break;

    	        case DialogInterface.BUTTON_NEGATIVE:
    	            //No button clicked
    	            break;
    	        }
    	    }
    	};

    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setMessage("Are you sure? You may lose all your coins.").setPositiveButton("Yes", dialogClickListener)
    	    .setNegativeButton("No", dialogClickListener).show();
	}
    
    
	private void InitParam() { 		
		G.g_Context = this;		
		G.curLevel = 1;
		G.curLine = 1;
		G.maxline = 1;
		G.bet = 1;		
		
	}	
	@Override public void onPause() {
	      super.onPause();
	      CCDirector.sharedDirector().pause();
	      G.pauseSound();
	        
	 }

	 @Override public void onResume() {
	     super.onResume();
	     CCDirector.sharedDirector().resume();
	     G.resumeSound();
	     review();
	  }

	  @Override public void onDestroy() {
	       super.onDestroy();
	       G.stopSound();
	       CCDirector.sharedDirector().end();
	       ksdfkjasdhfdashfkjsdhakf.flsdakjfdklsafjlksdajfkl();
	  }
   
	
    private LayoutParams createLayoutParams() {
        final DisplayMetrics pDisplayMetrics = new DisplayMetrics();
		CCDirector.sharedDirector().getActivity().getWindowManager().getDefaultDisplay().getMetrics(pDisplayMetrics);
		
		//final float mRatio = (float)G.DEFAULT_W / G.DEFAULT_H;
		final float mRatio = (float)G.DEFAULT_W / G.DEFAULT_H;
		final float realRatio = (float)pDisplayMetrics.widthPixels / pDisplayMetrics.heightPixels;

		final int width;
		final int height;
		if(realRatio < mRatio) {
			width = pDisplayMetrics.widthPixels;
			height = Math.round(width / mRatio);
		} else {
			height = pDisplayMetrics.heightPixels;
			width = Math.round(height * mRatio);
		}

		final LayoutParams layoutParams = new LayoutParams(width, height);

		layoutParams.gravity = Gravity.CENTER;
		return layoutParams;
	}


	
	/**
	 * Review
	 */
	private void review() {
		int random = fdlsfklsdflksakjlfjlksda.random.nextInt(100);
		if (random < 15) {
			GameActivity.this.showReviewDialog();
		}
	}

    /**
     * Set Review Dialog
     */
    public void showReviewDialog() {
//    	String message = "Do you Like this app? Get FREE 200 coins by giving us 5 STARS review or SHARE this app to your friends!";
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(message)
//            .setPositiveButton("Give Review!", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                	G.allCoin += 200;
//                	G.saveSetting();
//                    fqpwejfdlskdjglfg.giveUsReview(GameActivity.this);
//                }
//            })
//            .setNegativeButton("Share with Friends!", new DialogInterface.OnClickListener() {
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					G.allCoin += 200;
//					G.saveSetting();
//					fqpwejfdlskdjglfg.shareApp(GameActivity.this);
//				}
//            });
//        builder.create().show();
    }	
	
}
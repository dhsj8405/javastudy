package prob2;

public class SmartPhone extends MusicPhone {
	public void execute ( String function ) {
	      if (function.equals("음악") ) {
	          playMusic();
	          return;
	      }else if (function.equals("통화") ) {
		      super.execute( function );
	      }else if (function.equals("앱")) {
	    	  playApp();
	      }
	}
	public void playMusic(){
		    System.out.println("다운로드해서 음악재생");
		  }
	 public void playApp() {
		    System.out.println("앱실행");
		    
	 }

}

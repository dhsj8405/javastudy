package tv;

public class TV {
	private int channel; 	// 채널은 1~255  255넘어가면 1로 넘어가야함
	private int volume;		// 0~100
	private boolean power;	//꺼져있으면 작동하지않게
	public TV(int channel, int volume, boolean power){
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	public void status() {
		System.out.println( "TV [channel=" + this.channel + ", volume=" + this.volume + ", power=" + this.power + "]");
	}
	public int getChannel() {
		return channel;
	}
	public int getVolume() {
		return volume;
	}
	public boolean isPower() {
		return power;
	}
	public void power(boolean on) {
		this.power = on;
	}

	public void channel(int channel) {
		if(!this.power) {
			return;
		}else {
			if(channel > 255) {
				this.channel = 0;
			}else if( channel < 1) {
				this.channel = 255;
			}
		}
		this.channel = channel;
	}
	public void channel(boolean up) {
		channel(channel + (up ? 1 : -1));
		}
	public void volume(int volume) {
		if(!this.power) {
			return;
		}else {
			this.volume = volume;
			if(this.volume > 100) {
				this.volume = 100;
			}else if(this.volume < 0) {
				this.volume = 0;
			}
		}
	}
	public void volume(boolean up) {
		volume(volume + (up ? 1 : -1));
	}
}

package chapter03;

public class SongTest {
	public static void main(String[] args) {
		Song song = new Song();
		song.setArtist("아이유");
		song.setTitle("좋은날");
		song.setAlbum("Real");
		song.setYear(2010);
		song.setTrack(3);
		song.setComposer("이민수");
		song.show();
		
	}
}

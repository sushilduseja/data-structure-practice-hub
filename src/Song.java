public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {

        Song slow_p = this, fast_p = this;
        while (slow_p != null && fast_p != null && fast_p.nextSong!= null) {
            slow_p = slow_p.nextSong;
            fast_p = fast_p.nextSong.nextSong;
            if (slow_p == fast_p) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}
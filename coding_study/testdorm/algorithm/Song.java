/*
A playlist is considered a repeating playlist if any of the songs contain a reference to a previous song in the playlist. Otherwise, the playlist will end with the last song which points to null.

Implement a function isRepeatingPlaylist that, efficiently with respect to time used, returns true if a playlist is repeating or false if it is not.

For example, the following code prints "true" as both songs point to each other.

Song first = new Song("Hello");
Song second = new Song("Eye of the tiger");

first.setNextSong(second);
second.setNextSong(first);

System.out.println(first.isRepeatingPlaylist());

This would appear to be equivalent to checking for cycles in a linked-list, so we can simply use Floyd's "Tortoise and Hare" cycle detection algorithm:
 */



package testdorm.algorithm;

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
        Song tortoise = this;
        Song hare = this;

        // 비어있거나 하나 있는 요소들은 싸이클이 없다.
        if(tortoise == null || tortoise.nextSong == null) return false;

        // 리스트가 있을 때 까지 싸이클에서 달린다.
        while(hare != null && hare.nextSong != null){

            tortoise = tortoise.nextSong;
            hare = hare.nextSong.nextSong;

            // 거북이와 토끼가 루프 안에서 만날때까지 돌린다.
            if( tortoise == hare ) return true;
        }
        //토끼는 끝까지 달렸을 때 루프가 아닌 것을 발견했다.
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
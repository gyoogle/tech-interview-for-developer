#### Design Pattern - Adapter Pattern

---

[어댑터 패턴]

국가별 사용하는 전압이 달라서 220v를 110v형으로 바꿔서 끼우는 경우를 생각해보기.

- 실행 부분 (Main.java)

  ```java
  public class Main {
      public static void main (String[] args) {
          MediaPlayer player = new MP3();
          player.play("file.mp3");
          
          // MediaPlayer로 실행 못하는 MP4가 있음.
          // 이것을 mp3처럼 실행시키기 위해서,
          // Adapter를 생성하기.
          player = new FormatAdapter(new MP4());
          player.play("file.mp4");
      }
  }
  ```

- 변환 장치 부분 (FormatAdapter.java)

  ```java
  // MediaPlayer의 기능을 활용하기 위해 FormatAdapter라는 새로운 클래스를 생성
  // 그리고 그 클래스 내부에 (MP4, MKV와 같은) 클래스를 정리하려고 함.
  public class FormatAdapter implements MediaPlayer {
      private MediaPackage media;
      public FormatAdapter(MediaPackage m) {
          media = m;
      }
      // 그리고 반드시 사용해야하는 클래스의 함수를 선언해 둠
      @Override
      public void play(String filename) {
          System.out.print("Using Adapter");
          media.playFile(filename);
      }
  }
  ```


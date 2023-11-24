## carousel resets position state when using Navigation Component

Preconditions:

- Epoxy 5.1.3
- Navigation Component 2.7.5

Test:
- `./gradlew installDebug`
-  Scroll list item to a random postion, click Next to `SecondFragment`, and then back.
-  The carousel list resets to head position.

Screenrecord:

https://github.com/shawnlinboy/epoxy-carousel-issue/raw/master/S31124-16483901.mp4

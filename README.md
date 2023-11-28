# Fix Carousel resets position state when using Navigation Component

## Bug:
https://github.com/airbnb/epoxy/issues/1369#issuecomment-1827407601

## Preconditions:
- Epoxy 5.1.3
- Navigation Component 2.7.5

## Test:
- `./gradlew installDebug`
-  Scroll list item to a random position, click Next to `SecondFragment`, and then back.
-  The carousel list can restore list position.

## Keynote:
Carousel can not save its state when using Navigation Component, while `Fragment.onSaveInstanceState(Bundle)`
is called only when the fragment's host activity calls its own `onSaveInstanceState(Bundle)`, switching
fragments by using Navigation Component did not trigger source fragment's `onSaveInstanceState(Bundle)`,
so the best way to store a view's state is `onDestroyView` and `onViewCreated`. Thanks to [viroth-ty](https://github.com/viroth-ty)
with the inspiration.

This demo used a `SavedStateViewModel` to save state `Bundle` in memory. For more information,
 see: https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-savedstate#savedstate-compose-state
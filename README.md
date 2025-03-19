# WorkManager 2.10.0 breaking API change

## Problem
WorkManager 2.10.0 rewrites the WorkManager class in Kotlin. While the change does not require any code changes it is a breaking change as demonstrated by this sample.

Running the app via `./gradlew installDebug` will result in the following exception:
```bash
FATAL EXCEPTION: main (Ask Gemini)
 Process: com.example.workmanagerapi, PID: 5697
 java.lang.NoSuchFieldError: No field Companion of type Landroidx/work/WorkManager$Companion; in class Landroidx/work/WorkManager; or its superclasses (declaration of 'androidx.work.WorkManager' appears in /data/app/~~lXaMPfHlH6UF25BlMc9JWw==/com.example.workmanagerapi-hAkDqnriSeQp7f5LKMu42Q==/base.apk!classes6.dex)
 	at com.example.work_manager_using_library.UseWorkmanager.use(UseWorkmanager.kt:9)
 	at com.example.workmanagerapi.MainActivity.onCreate(MainActivity.kt:31)
 	at android.app.Activity.performCreate(Activity.java:9002)
 	at android.app.Activity.performCreate(Activity.java:8980)
 	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1526)
 	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:4030)
 	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:4235)
 	at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:112)
 	at android.app.servertransaction.TransactionExecutor.executeNonLifecycleItem(TransactionExecutor.java:174)
 	at android.app.servertransaction.TransactionExecutor.executeTransactionItems(TransactionExecutor.java:109)
 	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:81)
 	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2636)
 	at android.os.Handler.dispatchMessage(Handler.java:107)
 	at android.os.Looper.loopOnce(Looper.java:232)
 	at android.os.Looper.loop(Looper.java:317)
 	at android.app.ActivityThread.main(ActivityThread.java:8705)
 	at java.lang.reflect.Method.invoke(Native Method)
 	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:580)
 	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:886)
```

The `:work-manager-using-library` is compiled against `androidx.work:work-runtime-ktx:2.10.0`.

The `:app` is compiled against `androidx.work:work-runtime-ktx:2.9.0`.

The `getInstance()` method in the `WorkManager` class is annotated with `@JvmStatic` which should result in the same API but the compiled code is not compatible.

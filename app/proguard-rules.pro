# Add project specific ProGuard rules here.
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

# Keep Android support library classes
-keep class androidx.** { *; }
-keep interface androidx.** { *; }
